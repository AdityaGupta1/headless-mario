package com.devoxx4kids.supermario;

public enum Block {
    BLOCK(10), ENEMY(-10), NONE(0);

    private int value;

    Block(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
