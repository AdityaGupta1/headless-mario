package com.devoxx4kids.species;

import com.devoxx4kids.NetworkBuilder;
import com.devoxx4kids.RunConfiguration;
import com.devoxx4kids.supermario.MarioGameI;
import com.devoxx4kids.ui.EventCtx;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Generation {
    private static final Logger log = LogManager.getLogger(Generation.class);
    private List<Species> species = new ArrayList<>();
    private static final Random random = new Random();
    private GameWrapperPool gameWrapperPool;
    private Deque<SingleNetwork> networksToRun = new ConcurrentLinkedDeque<>();
    private Deque<SingleNetwork> networksRunning = new ConcurrentLinkedDeque<>();
    private List<SingleNetwork> networksCompleted = new ArrayList<>();

    private double previousBestMean = 0;
    private int staleGenerations = 0;
    private int purges = 0;
    private int generationsToRun;
    private int generationsCompleted;
    private int concurrentRuns;
    private ExecutorService executor;
    private List<GAMachineObserver> observers;
    private final RunConfiguration runConfiguration;

    public Generation(GameWrapperPool gameWrapperPool, NetworkGenerator networkGenerator,
                      List<GAMachineObserver> observers, RunConfiguration runConfiguration) {
        this.gameWrapperPool = gameWrapperPool;
        this.runConfiguration = runConfiguration;

        for (int i = 0; i < runConfiguration.getGenerationSize(); i++) {
            networksToRun.push(networkGenerator.getNetwork());
        }
        sortIntoSpecies();
        concurrentRuns = gameWrapperPool.numberOfWrappers();
        executor = Executors.newFixedThreadPool(concurrentRuns);
        this.generationsToRun = runConfiguration.getGenerationsToRun();
        this.observers = observers;
    }

    public void runNextGeneration(){
            int i = 0;
            List<Runnable> tasks = new ArrayList<>();
            while(!networksToRun.isEmpty() && i++ < concurrentRuns){
                Runnable runnableGameInstance = createRunnableGameInstance(networksToRun.pop());
                tasks.add(runnableGameInstance);
            }

            tasks.forEach(executor::submit);
    }

    private Runnable createRunnableGameInstance(SingleNetwork network) {

        return () -> {
            try {
                MarioGameI gameWrapper = gameWrapperPool.getGameWrapper();
                gameWrapper.reregisterGameWrapper(network);
                networksRunning.add(network);
                while (!network.isDead()) {
                    try {
                        gameWrapper.updateFrame();
                    } catch (Exception e) {
                        completeSingleGameInstance(gameWrapper, network);
                    }

                }
                completeSingleGameInstance(gameWrapper, network);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }


    synchronized  void completeSingleGameInstance(MarioGameI gameWrapper, SingleNetwork completedNetwork){
        gameWrapper.reloadLevel();
        gameWrapperPool.releaseGameWrapper(gameWrapper);
        networksRunning.remove(completedNetwork);
        networksCompleted.add(completedNetwork);


        //@TODO will notify for each thread
        if(generationsToRun < generationsCompleted){
            observers.stream().forEach(g -> g.gaEventOccured(GAEvent.GAME_COMPLETE, new EventCtx()));
            return;
        }

        if(networksToRun.isEmpty() && networksRunning.isEmpty()){
            generationsCompleted++;
            advance();
            runNextGeneration();
        }else {
            if(!networksToRun.isEmpty())
            executor.submit(createRunnableGameInstance(networksToRun.pop()));
        }

    }

    private void advance() {

        networksCompleted.sort((o1, o2) -> o2.getFitness() - o1.getFitness());
        double mean = networksCompleted.stream().mapToInt(SingleNetwork::getFitness).sorted().average().orElse(0);
        observers.stream().forEach(g -> g.gaEventOccured(GAEvent.INSTANCE_COMPLETE,new EventCtx(generationsCompleted,mean,
                networksCompleted.get(0).getFitness())));
        networksCompleted.stream()
                .limit(runConfiguration.getGenerationTopNumber())
                .forEach(network -> log.trace("UUID: {} Fitness: {}",network.getId(), network.getFitness()));




        log.trace("TOP {} {}" ,networksCompleted.get(0).getFitness(), networksCompleted.get(0).toJSONString());
        if (mean - previousBestMean <= runConfiguration.getStaleThreshold()) {
            staleGenerations++;
        } else {
            staleGenerations = 0;
        }

        if (mean > previousBestMean) {
            previousBestMean = mean;
        }

        if (staleGenerations == runConfiguration.getStaleGenerationsBeforePurge()) {
            species = sortDescendingByTopNetwork().stream().limit(2).collect(Collectors.toList());
            staleGenerations = 0;
            purges++;
            log.trace("Purging {} so far, remaining species: {}", purges,
                    species.stream().map(x -> Integer.toString(x.getId())).collect(Collectors.joining(", ")));
        }

        networksToRun.addAll(crossOver());
        sortIntoSpecies();
        networksCompleted.forEach(SingleNetwork::reset);
        networksCompleted.clear();

    }



    private List<SingleNetwork> crossOver() {
        List<SingleNetwork> newNetworks = new ArrayList<>();
        Map<Species, Integer> offspringPerSpecies = offspringPerSpecies();

        for (Species species : this.species) {
            int offspring = offspringPerSpecies.get(species);

            if (offspring == 0) {
                continue;
            }

            List<SingleNetwork> top = species.getNetworks().stream().sorted(Comparator.reverseOrder())
                    .limit((int) Math.ceil(runConfiguration.getSpeciesTopPercent() * species.getSize())).collect(Collectors.toList());
            Supplier<SingleNetwork> randomNetwork = () -> top.get(random.nextInt(top.size()));

            for (SingleNetwork network : top) {
                newNetworks.add(NetworkBuilder.copyFromNetwork(network,false));
            }

            for (int j = top.size(); j < offspring; j++) {
                if (top.size() == 1 || Math.random() < 1 - runConfiguration.getCrossoverChance()) {
                    SingleNetwork newNetwork = NetworkBuilder.copyFromNetwork(randomNetwork.get(), false);
                    newNetwork.mutate(runConfiguration);
                    newNetworks.add(newNetwork);
                } else {
                    SingleNetwork parent1;
                    SingleNetwork parent2;

                    do {
                        parent1 = randomNetwork.get();
                        parent2 = randomNetwork.get();
                    } while (parent1 == parent2);

                    newNetworks.add(NetworkBuilder.fromTwoParents(parent1, parent2, runConfiguration));
                }
            }
        }
            newNetworks.forEach(SingleNetwork::reset);
           return newNetworks.stream().limit(30).collect(Collectors.toList());

    }

    // list of all non-empty species, sorted in descending order by top network's fitness
    private List<Species> sortDescendingByTopNetwork() {
        return this.species.stream().filter(Species::notEmpty)
                .sorted(Comparator.comparingInt((Species x) -> x.getNetworks().stream().sorted(Comparator.reverseOrder())
                        .limit(1).findFirst().get().getFitness()).reversed()).collect(Collectors.toList());
    }

   public SingleNetwork getHighestValuedNetwork(){
        networksCompleted.sort((o1, o2) -> o2.getFitness() - o1.getFitness());
        return networksCompleted.get(0);
    }

    private Map<Species, Integer> offspringPerSpecies() {
        double totalAdjustedFitness = this.species.stream().mapToDouble(Species::getAdjustedFitness).sum();

        List<Species> nonEmptySpecies = sortDescendingByTopNetwork();
        int[] offspringPerNonEmptySpecies = round(nonEmptySpecies.stream().mapToDouble(x -> runConfiguration.getGenerationSize()
                * x.getAdjustedFitness() / totalAdjustedFitness).toArray());

        Map<Species, Integer> output = new HashMap<>();

        for (int i = 0; i < nonEmptySpecies.size(); i++) {
            output.put(nonEmptySpecies.get(i), offspringPerNonEmptySpecies[i]);
        }

        for (Species species : this.species) {
            if (!nonEmptySpecies.contains(species)) {
                output.put(species, 0);
            }
        }

        return output;
    }

    // input should be sorted in the order in which to add 1
    // for example, passing in [2.2, 1.2, 0.3, 0.3] with a total of 4 returns [3, 1, 0, 0]
    private int[] round(double[] input) {
        if (input.length == 1) {
            return Arrays.stream(input).mapToInt(x -> (int) Math.round(x)).toArray();
        }

        int[] output = new int[input.length];
        int left = runConfiguration.getGenerationSize() - DoubleStream.of(input).mapToInt(x -> (int) Math.floor(x)).sum();
        for (int i = 0; i < output.length; i++) {
            output[i] = (int) Math.floor(input[i]);
            if (i < left) {
                output[i]++;
            }
        }

        return output;
    }

    private void sortIntoSpecies() {
        this.species.forEach(Species::reset);

        for (SingleNetwork network : networksToRun) {
            for (Species species : this.species) {
                if (species.add(network)) {
                      break;
                }
            }

            Species species = new Species(network);
            this.species.add(species);
        }

        this.species = this.species.stream().filter(Species::notEmpty).collect(Collectors.toList());
    }
}