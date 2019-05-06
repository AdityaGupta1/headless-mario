package com.devoxx4kids.supermario.mario;

public class Enemy {
    public static final int WIDTH = 16;
    private static final int HEIGHT = 16;
    private double posX;
    private double posY;
    private boolean isActive;
    private int direction = -1;

    public Enemy(int posX, int posY, boolean b) {
        this.posX = posX;
        this.posY = posY;
        this.isActive = b;
    }

    private boolean pointAbove(double x) {
        return ((posX + 16 >= x && posX < x)
                || (posX + 16 >= x + 16 && posX < x + 16));
    }

    public boolean hasLandedOntop(double posX, double posY, double verticalAcceleration) {
        return (pointAbove(posX)) && posY < this.posY && posY + 16 - verticalAcceleration > this.posY;
    }

    public double posX() {
        return posX;
    }

    public double rightEdgeX() {
        return posX + WIDTH;
    }

    public double bottomEdgeY() {
        return posY + HEIGHT;
    }

    public double posY() {
        return posY;
    }

    public void kill() {
        isActive = true;
    }

    public double getPosX() {
        return posX;
    }

    public void fall(double amount) {
        posY += amount;
    }

    public void walk(double amount) {
        posX += amount;
    }

    public int direction() {
        return direction;
    }

    public void reverseDirection() {
        direction *= -1;
    }

    public boolean isActive() {
        return isActive;
    }
}
