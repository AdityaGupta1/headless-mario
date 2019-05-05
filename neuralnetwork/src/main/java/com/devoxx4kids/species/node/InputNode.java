package com.devoxx4kids.species.node;


import java.util.function.Supplier;

public abstract  class InputNode extends Node {
    protected final Supplier<Double> supplier;

    public InputNode(Supplier<Double> supplier) {
        this.supplier = supplier;
        this.level = 0;
    }

    public double get() {
        return supplier.get();
    }

}
