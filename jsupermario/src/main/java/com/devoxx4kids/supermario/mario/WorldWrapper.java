package com.devoxx4kids.supermario.mario;

public class WorldWrapper {

    int[][] world;

    public WorldWrapper(int[][] world) {
        this.world = world;
    }

    public int get(double x, double y){

        return world[(int) x][(int) y];
    }

    public int[][] getWorld() {
        return world;
    }
}
