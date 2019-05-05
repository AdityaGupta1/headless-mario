package com.devoxx4kids;

import com.devoxx4kids.species.MutationConfiguration;

public interface RunConfiguration extends MutationConfiguration {

    int getGenerationsToRun();

    RUN_TYPE getDisplayer();

    int getParallelLevel();

    int getGenerationSize();

    int getGenerationTopNumber();

    double getCrossoverChance();

    double getSpeciesTopPercent();

    int getStaleGenerationsBeforePurge();

    int getStaleThreshold();

    enum RUN_TYPE {
        HEADLESS,NINTANCO
    }
}
