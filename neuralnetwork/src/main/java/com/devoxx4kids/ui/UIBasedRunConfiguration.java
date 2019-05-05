package com.devoxx4kids.ui;

import com.devoxx4kids.RunConfiguration;

public class UIBasedRunConfiguration implements RunConfiguration {

    private int generationsToRun;
    private RUN_TYPE displayer;
    private int parallelLevel;
    private double addConnectionChance;
    private double addNodeChance;
    private double mutateWeightChance;
    private double enableChance;
    private double disableChance;
    private int generationSize;
    private  int generationTopNumber;
    private double crossoverChance;
    private double speciesTopPercent;
    private int staleGenerationsBeforePurge; // number of stale generations before only the top two species are allowed to reproduce
    private int staleThreshold;

    public UIBasedRunConfiguration(int generationsToRun, RUN_TYPE displayer, int parallelLevel,
                                   double addConnectionChance, double addNodeChance, double mutateWeightChance, double enableChance, double disableChance,int generationSize
    ,int generationTopNumber, double crossoverChance, double speciesTopPercent, int staleGenerationsBeforePurge, int  staleThreshold) {
        this.generationsToRun = generationsToRun;
        this.displayer = displayer;
        this.parallelLevel = parallelLevel;
        this.addConnectionChance = addConnectionChance;
        this.addNodeChance = addNodeChance;
        this.mutateWeightChance = mutateWeightChance;
        this.enableChance = enableChance;
        this.disableChance = disableChance;
        this.generationSize = generationSize;
        this.generationTopNumber = generationTopNumber;
        this.crossoverChance = crossoverChance;
        this.speciesTopPercent = speciesTopPercent;
        this.staleGenerationsBeforePurge = staleGenerationsBeforePurge;
        this.staleThreshold = staleThreshold;
    }

    @Override
    public int getGenerationsToRun() {
        return generationsToRun;
    }

    @Override
    public RUN_TYPE getDisplayer() {
        return displayer;
    }

    @Override
    public int getParallelLevel() {
        return parallelLevel;
    }

    @Override
    public int getGenerationSize() {
        return generationSize;
    }

    @Override
    public int getGenerationTopNumber() {
        return generationTopNumber;
    }

    @Override
    public double getCrossoverChance() {
        return crossoverChance;
    }

    @Override
    public double getSpeciesTopPercent() {
        return speciesTopPercent;
    }

    @Override
    public int getStaleGenerationsBeforePurge() {
        return staleGenerationsBeforePurge;
    }

    @Override
    public int getStaleThreshold() {
        return staleThreshold;
    }

    @Override
    public double getAddConnectionChance() {
        return addConnectionChance;
    }

    @Override
    public double getAddNodeChance() {
        return addNodeChance;
    }

    @Override
    public double getMutateWeightsChance() {
        return mutateWeightChance;
    }

    @Override
    public double getEnableChance() {
        return enableChance;
    }

    @Override
    public double getDisableChance() {
        return disableChance;
    }



}
