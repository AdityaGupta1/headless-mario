package com.devoxx4kids.ui;

public class EventCtx {
    private double meanFitness;
    private double topFitness;
    private int generation;
    public EventCtx(int generation, double meanFitness, double topFitness) {
        this.meanFitness = meanFitness;
        this.generation = generation;
        this.topFitness = topFitness;
    }


    public EventCtx() {
    }



    public int getGeneration() {
        return generation;
    }

    public double getMeanFitness() {
        return meanFitness;
    }

    public double getTopFitness() {
        return topFitness;
    }
}
