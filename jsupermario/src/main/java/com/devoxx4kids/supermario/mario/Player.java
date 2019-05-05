package com.devoxx4kids.supermario.mario;

public class Player {

    private static int WIDTH = 16;
    private static int HEIGHT = 16;
    private double playerXPosition;
    private double playerYPosition;
    private boolean isDead = false;
    private double verticalAcc;
    private double horizontalAcc;
    private double jumpSpeed = 0;

    public Player(double playerXPosition, double playerYPosition) {
        this.playerXPosition = playerXPosition;
        this.playerYPosition = playerYPosition;
    }

    public void kill(){
        this.isDead = true;
    }

    public double getPlayerXPosition() {
        return playerXPosition;
    }

    public double getPlayerYPosition() {
        return playerYPosition;
    }

    public double getBottomY(){
        return playerYPosition  + HEIGHT;
    }

    public double getRightX(){
        return playerXPosition  + WIDTH;
    }

    public boolean isDead() {
        return isDead;
    }

    public double getVerticalAcc() {
        return verticalAcc;
    }

    public double getHorizontalAcc() {
        return horizontalAcc;
    }

    public void setVerticalAcc(double verticalAcc) {
        this.verticalAcc = verticalAcc;
    }

    public void setHorizontalAcc(double horizontalAcc) {
        this.horizontalAcc = horizontalAcc;
    }

    public void walk(int i) {
        playerXPosition += i;
    }

    public void updateHorzintalAcc(double v) {
        horizontalAcc += v;
    }

    public void updateVerticalAcc(double jumpAccel) {
        this.verticalAcc += jumpAccel;
    }

    public void verticalMove(int i) {
        playerYPosition += i;
    }

    public void setJumpSpeed() {
        jumpSpeed =verticalAcc;
    }

    public double getJumpSpeed() {
        return jumpSpeed;
    }
}
