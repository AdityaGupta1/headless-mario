package com.devoxx4kids.supermario;

import com.devoxx4kids.species.BlockReader;

public interface MarioGameI extends BlockReader {

    int getPlayerXPosition();

    void setButton(int button, boolean buttonValue);

    boolean isSlidingDownFlagpole();

    int getTime();


    void reloadLevel();

    boolean isDead();

    void setDead();

    void reregisterGameWrapper(MarioGameListener marioGameListener);

    void updateFrame();
}
