package com.devoxx4kids.species;

import static com.devoxx4kids.Constants.*;

public class DefaultMutationConfiguration implements MutationConfiguration {

    static DefaultMutationConfiguration instance = new DefaultMutationConfiguration();
    public static DefaultMutationConfiguration getInstance() {
        return instance;
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
        return mutateWeightsChance;
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
