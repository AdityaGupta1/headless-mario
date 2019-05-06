package com.devoxx4kids.species;

import com.devoxx4kids.species.node.*;
import com.devoxx4kids.species.node.serializationmodel.Container;
import com.devoxx4kids.species.node.serializationmodel.SerializedConnection;
import com.devoxx4kids.species.node.serializationmodel.SerializedNode;
import com.devoxx4kids.supermario.MarioGameI;
import com.devoxx4kids.supermario.MarioGameListener;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Table;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.devoxx4kids.Constants.*;

public class SingleNetwork implements Comparable<SingleNetwork>, MarioGameListener {
    private static final Random random = new Random();

    private final List<Node> nodes;
    private final List<Connection> connections;
    private final Multimap<Node, Connection> nodeToConnectionsAsOutput;
    private final Table<Node,Node,Connection> nodesToConnect;
    private final Set<HiddenNode> hiddenNodes;
    private final Set<OutputNode> outputNodes;
    private int fitness = 0;
    private final String id;
    private int species;
    private int previousFitnessNoTime = 0;
    private int previousTotalFitness = 0;
    private int stationaryFrames = 0;
    private boolean wasSliding = false;
    private boolean isEnded = false;
    private boolean isAgressiveRestartMode = true;
    long framesRun;
    int previousPosition= 0 ;

    public SingleNetwork(List<Node> childNodes, List<Connection> connections, String id) {
        this.nodes = childNodes;
        this.connections = connections;
        this.id = id;
        nodeToConnectionsAsOutput = HashMultimap.create();
        nodesToConnect = HashBasedTable.create();
        connections.stream().forEach(connection -> {nodeToConnectionsAsOutput.put(connection.getOutput(),connection);
        nodesToConnect.put(connection.getInput(),connection.getOutput(),connection);});
        outputNodes = childNodes.stream().filter(e -> e instanceof  OutputNode)
                .map(node -> (OutputNode)node).collect(Collectors.toSet());
        hiddenNodes = childNodes.stream().filter(e -> e instanceof  HiddenNode)
                .map(node -> (HiddenNode)node).collect(Collectors.toSet());
    }

    public SingleNetwork(List<Node> childNodes, List<Connection> connections) {
        this(childNodes,connections,UUID.randomUUID().toString());
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Connection> getConnections() {
        return connections;
    }


    public void setAgressiveRestartMode(boolean agressiveRestartMode) {
        isAgressiveRestartMode = agressiveRestartMode;
    }

    private void addConnection(Connection connection) {
        nodeToConnectionsAsOutput.put(connection.getOutput(),connection);
        nodesToConnect.put(connection.getInput(),connection.getOutput(),connection);
        connections.add(connection);
    }

    private void addNode(HiddenNode node){
        hiddenNodes.add(node);
        nodes.add(node);
    }

    public void mutate(MutationConfiguration mutationConfiguration) {
        // for example, chance = 1.4 means one guaranteed mutation and a 0.4 chance of a second mutation
        BiConsumer<Double, Runnable> mutator = (chance, mutation) -> {
            do {
                if (Math.random() < chance) {
                    mutation.run();
                }

                chance--;
            } while (chance > 0);
        };

        mutator.accept(mutationConfiguration.getAddConnectionChance(), this::mutateAddConnection);
        mutator.accept(mutationConfiguration.getAddNodeChance(), this::mutateAddNode);
        mutator.accept(mutationConfiguration.getMutateWeightsChance(), this::mutateWeights);
        mutator.accept(mutationConfiguration.getEnableChance(), () -> this.mutateEnable(true));
        mutator.accept(mutationConfiguration.getDisableChance(), () -> this.mutateEnable(false));
    }

    private void mutateAddConnection() {
        BiPredicate<Node, Node> findNew = (input, output) ->
             input == output || input.getLevel() >= output.getLevel() || nodesToConnect.contains(input, output);

        Node input, output;
        Supplier<Node> randomNode = () -> nodes.get(random.nextInt(nodes.size()));

        do {
            input = randomNode.get();
            output = randomNode.get();
        } while (findNew.test(input, output));
        addConnection(new Connection(input, output, Math.random() * 4 - 2));
    }

    private void mutateAddNode() {
        List<Connection> candidates = connections.stream().filter(Connection::isEnabled).collect(Collectors.toList());
        if (candidates.isEmpty()) {
            return;
        }

        Connection connection = candidates.get(random.nextInt(candidates.size()));
        Node input = connection.getInput();
        Node output = connection.getOutput();

        connection.setEnabled(false);
        HiddenNode node = new HiddenNode((input.getLevel() + output.getLevel()) / 2);
        addNode(node);
        addConnection(new Connection(input, output, Math.random() * 4 - 2));
        addConnection(new Connection(node, output, connection.getWeight()));
    }

    private void mutateWeights() {
        for (Connection connection : connections) {
            if (Math.random() < mutateWeightChance) {
                connection.mutateWeight();
            } else {
                connection.randomWeight();
            }
        }
    }

    // mutates to either enable or disable a random connection of the opposite state, depending on the value passed in for the parameter
    private void mutateEnable(boolean enable) {
        List<Connection> candidates = connections.stream().filter(x -> x.isEnabled() != enable).collect(Collectors.toList());
        if (candidates.isEmpty()) {
            return;
        }

        candidates.get(random.nextInt(candidates.size())).toggleEnabled();
    }

    public <T> T calculate(NonInputNode<T> node, BlockReader blockReader) {
        return node.apply(nodeToConnectionsAsOutput.get(node).stream()
                .mapToDouble(connection ->
                               connection.getInput().calculateValue(this, blockReader) * connection.getWeight()
           ).sum());
    }



    public void onFrameUpdateRender(MarioGameI wrapper) {
        if (wrapper.isDead()) {
            isEnded = true;
            return;
        }

        framesRun++;


        if(framesRun % 120 == 0 && isAgressiveRestartMode ) {

           if (Math.abs(previousPosition - wrapper.getPlayerXPosition()) < 20){
               wrapper.setDead();
            }
           previousPosition =  wrapper.getPlayerXPosition();
        }

        outputNodes.stream().forEach(outputNode -> wrapper.setButton(outputNode.button,calculate(outputNode,wrapper)));

        boolean isSliding = wrapper.isSlidingDownFlagpole();

        if (isSliding && !wasSliding) { // level end check (doesn't include warp zone pipes or defeating Bowser)
            previousTotalFitness = fitness + fitnessOnLevelComplete;
            stationaryFrames = -60 * 60;
        }

        wasSliding = isSliding;

        int fitnessNoTime = wrapper.getPlayerXPosition() + previousTotalFitness;
        fitness = fitnessNoTime + fitnessTimeMultiplier * wrapper.getTime();

        if (fitnessNoTime == previousFitnessNoTime) {
            stationaryFrames++;
        } else {
            if (stationaryFrames > 0) { // this check is necessary to not reset right after completing a level
                stationaryFrames = 0;
            }
        }

        if (wrapper.getTime() == 400) {
            stationaryFrames = 0;
        }

        if (stationaryFrames > framesBeforeReset) {
            isEnded = true;
        }
        previousFitnessNoTime = fitnessNoTime;

    }

    public String toJSONString() {

        Multimap<Node,Connection> hiddenToConnectionBlock =  HashMultimap.create();
        Multimap<Node, Connection> hiddenToConnectionOutput  =  HashMultimap.create();
        connections.stream().filter(e -> hiddenNodes.contains(e.getInput())).forEach(e -> hiddenToConnectionOutput.get(e.getInput()).add(e));
        connections.stream().filter(e -> hiddenNodes.contains(e.getOutput())).forEach(e -> hiddenToConnectionBlock.get(e.getOutput()).add(e));

        Container container = new Container();
        container.setHiddenNodes(hiddenNodes.stream().map(node -> {
            SerializedNode serializedNode = new SerializedNode();
            serializedNode.setId(node.getID());
            Collection<Connection> connections = hiddenToConnectionBlock.get(node);
            if (connections != null) {
                connections.stream()
                        .map(connection -> new SerializedConnection(connection.getInput().getID(), connection.getWeight()))
                        .forEach(serializedNode::addInputConnection);
            }

            connections = hiddenToConnectionOutput.get(node);
            if (connections != null) {
                connections.stream()
                        .map(connection -> new SerializedConnection(connection.getOutput().getID(), connection.getWeight()))
                        .forEach(serializedCollection -> serializedNode.addOutputConnection(serializedCollection));
            }

            return serializedNode;

        }).collect(Collectors.toList()));
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(container);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
}

    public int getFitness() {
        return fitness;
    }

    void reset() {

        framesRun = 0 ;
        fitness = 0;
        previousFitnessNoTime = 0;
        stationaryFrames = 0;
        previousTotalFitness = 0;
        isEnded = false;
    }

    void setSpecies(int species) {
        this.species = species;
    }

    @Override
    public int compareTo(SingleNetwork other) {
        return Integer.compare(this.fitness, other.fitness);
    }

    @Override
    public String toString() {
        return id + ", " + String.format("%5s", fitness).replace(" ", "0") + "; species " + species;
    }

    public String getId() {
        return id;
    }

    public boolean isDead() {
        return isEnded;
    }
}