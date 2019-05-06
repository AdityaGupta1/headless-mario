package com.devoxx4kids.supermario;

import com.devoxx4kids.supermario.mario.Player;
import com.devoxx4kids.supermario.mario.WorldWrapper;
import com.devoxx4kids.supermario.ui.MarioWorldPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;

public class MarioGameRunnerGUI extends MarioGameRunner {


    public MarioGameRunnerGUI(int fps) {

        super(fps);

        JFrame frame = new JFrame("FrameDemo");
        frame.setSize(new Dimension(480, 480));
        comp = new MarioWorldPanel(super.gs, super.wrapper);
        frame.add(comp);
        frame.setVisible(true);
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        is.setRigthPressed(true);
                        break;
                    case KeyEvent.VK_LEFT:
                        is.setLeftPressed(true);
                        break;
                    case KeyEvent.VK_S:
                        is.setJump(true);
                        break;
                    case KeyEvent.VK_R:
                        wrapper = new WorldWrapper(new FileBasedBuilder().build());
                        gs = new GameState(new Player(50, 192),
                                generateDefaultEnemies(), generateDefaultEnemies());
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        is.setRigthPressed(false);
                        break;
                    case KeyEvent.VK_LEFT:
                        is.setLeftPressed(false);
                        break;
                    case KeyEvent.VK_S:
                        is.setJump(false);
                        break;
                }
            }
        });
        frame.requestFocus();
    }

    public static void main(String args[]) {
        MarioGameRunnerGUI marioGameRunner = new MarioGameRunnerGUI(60);
        while (true) {
            marioGameRunner.run();
        }
    }

    public void updateFrame() {
        super.updateFrame();
        try {
            SwingUtilities.invokeAndWait(() -> comp.update(gs, wrapper));
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    public void run() {

        super.updateFrame();
        try {
            SwingUtilities.invokeAndWait(() -> comp.update(gs, wrapper));
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

