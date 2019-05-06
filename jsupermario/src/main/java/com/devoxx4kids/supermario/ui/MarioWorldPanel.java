package com.devoxx4kids.supermario.ui;

import com.devoxx4kids.supermario.GameState;
import com.devoxx4kids.supermario.mario.WorldWrapper;

import javax.swing.*;
import java.awt.*;

public class MarioWorldPanel extends JPanel {

    GameState gs;
    WorldWrapper wrapper;
    Color[] colors = {Color.yellow, Color.BLUE, Color.CYAN, Color.darkGray, Color.green, Color.MAGENTA, Color.orange, Color.white, Color.RED};

    public MarioWorldPanel(GameState gs, WorldWrapper wrapper) {
        super();
        this.gs = gs;
        this.wrapper = wrapper;

    }


    public void update(GameState gs, WorldWrapper wrapper) {
        this.gs = gs;
        this.wrapper = wrapper;
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int screenXOffset = (int) (gs.getPlayer().getPlayerXPosition() - 10);
        int[][] world = wrapper.getWorld();
        g.fillRect(0, 0, 480, 480);

        g.setColor(Color.red);
        if (gs.getPlayer().isDead()) {
            g.drawString("GameOver", 100, 100);
        }
        for (int y = 0; y < 240; y++) {
            for (int x = 0; x < 224; x++) {

                if (world[y][x + screenXOffset] != 0) {
                    g.setColor(colors[world[y][x + screenXOffset] - 1]);
                    g.fillRect(x * 2, y * 2, 2, 2);
                    g.setColor(Color.black);
                }

            }
        }
        g.setColor(Color.red);
        gs.getActiveEnemy().stream().filter(e -> (screenXOffset + 240 > e.posX() && screenXOffset < e.posX()))
                .forEach(e -> g.fillRect((int) (e.posX() - screenXOffset) * 2, (int) e.posY() * 2, 32, 32));
        g.setColor(Color.cyan);
        g.fillRect((int) (gs.getPlayer().getPlayerXPosition() - screenXOffset) * 2, (int) gs.getPlayer().getPlayerYPosition() * 2, 32, 32);


    }
}
