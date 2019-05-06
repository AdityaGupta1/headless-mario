package com.devoxx4kids.species.node;

import com.devoxx4kids.species.BlockReader;
import com.devoxx4kids.species.SingleNetwork;

public abstract class Node {
    double level;

    public abstract Node copy();

    // modified sigmoid from NEAT paper
    static double sigmoid(double x) {
        return 2 / (1 + Math.exp(-1.9 * x)) - 1;
    }

    public double getLevel() {
        return level;
    }

    public abstract String getID();

    public abstract double calculateValue(SingleNetwork network, BlockReader blockReader);
}
