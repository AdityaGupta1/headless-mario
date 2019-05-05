package com.devoxx4kids.species;


public interface MutationConfiguration {

    double getAddConnectionChance();
    double getAddNodeChance();
    double getMutateWeightsChance();
    double getEnableChance();
    double getDisableChance();

}

