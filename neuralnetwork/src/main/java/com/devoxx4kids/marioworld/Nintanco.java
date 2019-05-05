package com.devoxx4kids.marioworld;


import com.devoxx4kids.supermario.Block;
import com.devoxx4kids.supermario.MarioGameListener;
import nintaco.api.API;

import static nintaco.api.GamepadButtons.*;

public class Nintanco {
    private  API api;
    private MarioGameListener gameListener;
    public   boolean isDead() {
        return read(0x00E) == 0x0B;
    }

    public   void setDead() {
        write(0x00E, 0x0B);
    }

    public void reregisterGameWrapper(MarioGameListener marioGameListener) {
        this.gameListener = marioGameListener;
    }

    public void updateFrame() {
        //@TODO this needs removing
    }


    public Nintanco(API api) {
        this.api = api;
    }


    /**
     * https://datacrystal.romhacking.net/wiki/Super_Mario_Bros.:RAM_map
     * @return
     */
    public   Block[][] readBlocks() {
        Block[][] blocks = new Block[16][14];

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 14; j++) {
                int tempX = getPlayerXPosition() + i * 16;
                int x = (tempX % 256) / 16;
                int y = (j - 1) * 16;

                int address = 0x0500 + (((tempX / 256) % 2 == 1) ? 208 : 0) + x + y;
                Block block = Block.NONE;
                if (read(address) != 0 && y < 14 * 16 && y >= 0) {
                    block = Block.BLOCK;
                }

                blocks[i][j] = block;
            }
        }


        //Only 5 enemies can be drawn at any given time
        //check if enemy is visible
        for (int i = 0; i < 5; i++) { // 0x00F flag if enemy exists
            if (read(0x00F + i) != 1) {
                continue;
            }

            int x = read(0x0087 + i) + 256 * read(0x006E + i) - getPlayerXPosition() + 16;
            if (x < 0  || x > 256) {
                continue;
            }

            x = (x % 256) / 16;
            int y = (read(0x00CF + i) - 8) / 16;

            if (y >= 14) {
                continue;
            }

            if (blocks[x][y] == Block.BLOCK) {
                continue;
            }

            blocks[x][y] = Block.ENEMY;
        }

        return blocks;
    }

    public int getPlayerXPosition() {
        return read(0x071C) + 256 * read(0x071A);
    }

    public static final int[] buttons = {A, B, Up, Down, Left, Right};


    public   void setButton(int button, boolean buttonValue) {
        api.writeGamepad(0, button, buttonValue);
    }

    public   boolean getButton(int button) {
        return api.readGamepad(0, button);
    }

    public   boolean isSlidingDownFlagpole() {
        return read(0x001D) == 0x03;
    }

    public   int getTime() {
        //noinspection PointlessArithmeticExpression
        return 100 * read(0x07F8) + 10 * read(0x07F9) + 1 * read(0x07FA);
    }

    private   int read(int address) {
        return api.readCPU(address);
    }

    private   void write(int address, int value) {
        api.writeCPU(address, value);
    }

    public void reloadLevel() {
        api.loadState("states/SMB.save");
    }
//
//    @Override
//    public void frameRendered() {
//        gameListener.onFrameUpdateRender(this);
//    }
}
