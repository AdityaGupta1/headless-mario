package com.devoxx4kids.ui;

import com.devoxx4kids.Constants;
import com.devoxx4kids.RunConfiguration;

public class UIBasedRunConfigurationBuilder {
    private int generationsToRun;
    private RunConfiguration.RUN_TYPE displayer;
    private int parallelLevel;
    private double addConnectionChance = Constants.addConnectionChance;
    private double addNodeChance =  Constants.addNodeChance;
    private double mutateWeightChance = Constants.mutateWeightChance;
    private double enableChance = Constants.enableChance;
    private double disableChance = Constants.disableChance;
    private int generationSize = Constants.generationSize;
    private  int generationTopNumber = Constants.generationTopNumber;
    private double crossoverChance = Constants.crossoverChance;
    private double speciesTopPercent = Constants.speciesTopPercent;
    private int staleGenerationsBeforePurge = Constants.staleGenerationsBeforePurge; // number of stale generations before only the top two species are allowed to reproduce
    private int staleThreshold = Constants.staleThreshold;

    UIBasedRunConfigurationBuilder(int generationsToRun , RunConfiguration.RUN_TYPE displayer, int parallelLevel) {
        this.generationsToRun = generationsToRun;
        this.displayer = displayer;
        this.parallelLevel = parallelLevel;
    }


    public UIBasedRunConfigurationBuilder setStaleGenerationsBeforePurge(int staleGenerationsBeforePurge) {
        this.staleGenerationsBeforePurge = staleGenerationsBeforePurge;
        return this;
    }
    public UIBasedRunConfigurationBuilder setStaleThreshold(int staleThreshold) {
        this.staleThreshold = staleThreshold;
        return this;
    }

    public UIBasedRunConfigurationBuilder setGenerationSize(int generationSize) {
        this.generationSize = generationSize;
        return this;
    }
    public UIBasedRunConfigurationBuilder setGenerationTopNumber(int generationTopNumber) {
        this.generationTopNumber = generationTopNumber;
        return this;
    }
    public UIBasedRunConfigurationBuilder setCrossoverChance(double crossoverChance) {
        this.crossoverChance = crossoverChance;
        return this;
    }
    public UIBasedRunConfigurationBuilder setSpeciesTopPercent(double speciesTopPercent) {
        this.speciesTopPercent = speciesTopPercent;
        return this;
    }


    public UIBasedRunConfigurationBuilder setGenerationsToRun(int generationsToRun) {
        this.generationsToRun = generationsToRun;
        return this;
    }

    public UIBasedRunConfigurationBuilder setDisplayer(RunConfiguration.RUN_TYPE displayer) {
        this.displayer = displayer;
        return this;
    }

    public UIBasedRunConfigurationBuilder setParallelLevel(int parallelLevel) {
        this.parallelLevel = parallelLevel;
        return this;
    }

    public UIBasedRunConfigurationBuilder setAddConnectionChance(double addConnectionChance) {
        this.addConnectionChance = addConnectionChance;
        return this;
    }

    public UIBasedRunConfigurationBuilder setAddNodeChance(double addNodeChance) {
        this.addNodeChance = addNodeChance;
        return this;
    }

    public UIBasedRunConfigurationBuilder setMutateWeightChance(double mutateWeightChance) {
        this.mutateWeightChance = mutateWeightChance;
        return this;
    }

    public UIBasedRunConfigurationBuilder setEnableChance(double enableChance) {
        this.enableChance = enableChance;
        return this;
    }

    public UIBasedRunConfigurationBuilder setDisableChance(double disableChance) {
        this.disableChance = disableChance;
        return this;
    }

    public UIBasedRunConfiguration createUIBasedRunConfiguration() {
        return new UIBasedRunConfiguration(generationsToRun, displayer, parallelLevel, addConnectionChance, addNodeChance, mutateWeightChance, enableChance, disableChance,
                generationSize,generationTopNumber,crossoverChance,speciesTopPercent,staleGenerationsBeforePurge,staleThreshold);
    }
}