package com.devoxx4kids.supermario;

import nintaco.api.API;

public class NintancoGameInterface implements MarioGameI {

    int playerPositionTagForBlocks = -1;
    Block[][] blocks;
    private API api;

    public NintancoGameInterface(API api) {
        this.api = api;
    }

    @Override
    public boolean isDead() {
        return read(0x00E) == 0x0B;
    }


    @Override
    public void setDead() {
        write(0x00E, 0x0B);
    }

    @Override
    public void reregisterGameWrapper(MarioGameListener marioGameListener) {
        throw new RuntimeException("reregisterGameWrapper not supported ");
    }

    @Override
    public void updateFrame() {
        throw new RuntimeException("Frame update not supported");
    }


    public com.devoxx4kids.supermario.Block[][] readBlocks() {
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

        for (int i = 0; i < 5; i++) {
            if (read(0x00F + i) != 1) {
                continue;
            }

            int x = read(0x0087 + i) + 256 * read(0x006E + i) - getPlayerXPosition() + 16;
            if (x < 0 || x > 256) {
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

    @Override
    public int getPlayerXPosition() {
        return read(0x071C) + 256 * read(0x071A);
    }

    @Override
    public void setButton(int button, boolean buttonValue) {
        api.writeGamepad(0, button, buttonValue);
    }

    public boolean getButton(int button) {
        return api.readGamepad(0, button);
    }

    @Override
    public boolean isSlidingDownFlagpole() {
        return read(0x001D) == 0x03;
    }

    @Override
    public int getTime() {
        return 100 * read(0x07F8) + 10 * read(0x07F9) + read(0x07FA);
    }

    @Override
    public void reloadLevel() {
        api.loadState("states/SMB.save");
    }

    private int read(int address) {
        return api.readCPU(address);
    }

    private void write(int address, int value) {
        api.writeCPU(address, value);
    }

    @Override
    public int readBlock(int y, int x) {
        if (playerPositionTagForBlocks != getPlayerXPosition()) {
            blocks = readBlocks();
            playerPositionTagForBlocks = getPlayerXPosition();
        }
        return blocks[x][y - 2 < 0 ? 0 : y - 2] == Block.NONE ? 0 : 10;
    }
}