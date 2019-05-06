package com.devoxx4kids.species.node;


import com.devoxx4kids.species.BlockReader;
import com.devoxx4kids.species.SingleNetwork;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class BlockNode extends InputNode {
    public final int x;
    public final int y;

    static Table<Integer,Integer,String> idPool = HashBasedTable.create();
    static {
        IntStream.range(0, 20).boxed()
                .forEach(i -> IntStream.range(0,20)
                        .forEach(j ->  idPool.put(i,j,String.format("bx%dy%d",i,j))));
    }
    public BlockNode(int x, int y,double supplierValue) {
        super(() ->  supplierValue);
        this.x = x;
        this.y = y;
    }

    public BlockNode(int x, int y,Supplier<Double> supplier) {
        super(supplier);
        this.x = x;
        this.y = y;
    }
    public String getID(){
        return idPool.get(x,y);
    }

    @Override
    public double calculateValue(SingleNetwork network, BlockReader blockReader) {
        return blockReader.readBlock(y,x);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "BlockNode{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public InputNode copy() {
        return new BlockNode(x,y,super.supplier);
    }
}
