package com.devoxx4kids.species.node;


import com.devoxx4kids.species.BlockReader;
import com.devoxx4kids.species.SingleNetwork;
import com.devoxx4kids.supermario.Block;

import java.util.UUID;
import java.util.function.Function;

public class HiddenNode extends NonInputNode<Double> {
    private String name;
    public HiddenNode(Function<Double, Double> function, double level) {
          this(function,level,UUID.randomUUID().toString());
    }

    public HiddenNode(Function<Double, Double> function, double level,String name) {
        super(function);
        this.level = level;
        this.name = name;
    }

    public HiddenNode(double level) {
        this(Node::sigmoid, level);
    }

    public HiddenNode(double level,String id) {
        this(Node::sigmoid, level,id);
    }

    @Override
    public HiddenNode copy() {
        return new HiddenNode(function, level);
    }

    @Override
    public String getID() {
        return name;
    }



    @Override
    public double calculateValue(SingleNetwork network, BlockReader blockReader) {
        return network.calculate(this,blockReader);
    }
}
