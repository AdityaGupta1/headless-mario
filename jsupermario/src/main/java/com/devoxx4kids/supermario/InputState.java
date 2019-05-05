package com.devoxx4kids.supermario;

public class InputState {
    private boolean isLeftPressed = false;
    private boolean isRigthPressed = false;
    private boolean isJump = false;
    private boolean isPreviousJumpReleaesed = true;


    public boolean isLeftPressed() {
        return isLeftPressed;
    }

    public void setLeftPressed(boolean leftPressed) {
        isLeftPressed = leftPressed;
    }

    public boolean isRigthPressed() {
        return isRigthPressed;
    }

    public void setRigthPressed(boolean rigthPressed) {
        isRigthPressed = rigthPressed;
    }

    public boolean isJump() {
        return isJump;
    }

    public void setJump(boolean jump) {
        isJump = jump;
    }

    void reset() {
        isLeftPressed = isRigthPressed = isJump = false;
    }

    @Override
    public String toString() {
        return "InputState{" +
                "isLeftPressed=" + isLeftPressed +
                ", isRigthPressed=" + isRigthPressed +
                ", isJump=" + isJump +
                '}';
    }

    public boolean isPreviousJumpReleaesed() {
        return isPreviousJumpReleaesed;
    }
    public  void setPreviousJumpReleaesed(boolean isPreviousJumpReleaesed) {
        this.isPreviousJumpReleaesed = isPreviousJumpReleaesed;
    }
}
