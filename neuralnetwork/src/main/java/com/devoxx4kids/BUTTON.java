package com.devoxx4kids;

public enum BUTTON {

    A(0),B(1),LEFT(6),RIGHT(7);

    private int value;
    BUTTON(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
