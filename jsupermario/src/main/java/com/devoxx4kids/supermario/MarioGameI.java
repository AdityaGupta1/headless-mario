package com.devoxx4kids.supermario;
import com.devoxx4kids.species.BlockReader;

import static nintaco.api.GamepadButtons.*;
public interface MarioGameI extends BlockReader {

        int getPlayerXPosition();

        public static final int[] buttons = {A, B, Up, Down, Left, Right};


        public   void setButton(int button, boolean buttonValue);
        public   boolean getButton(int button);

        public   boolean isSlidingDownFlagpole();

        public   int getTime();


        public void reloadLevel();

        boolean isDead();

        void setDead();

        void reregisterGameWrapper(MarioGameListener marioGameListener);

        void updateFrame();
}
