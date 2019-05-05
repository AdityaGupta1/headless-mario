package  com.devoxx4kids.supermario;

import com.devoxx4kids.supermario.mario.Enemy;
import com.devoxx4kids.supermario.mario.Player;
import com.devoxx4kids.supermario.mario.WorldWrapper;
import com.devoxx4kids.supermario.ui.MarioWorldPanel;
import nintaco.api.GamepadButtons;

import java.util.ArrayList;
import java.util.List;

public class MarioGameRunner  implements MarioGameI{

    private int sleepPerFrameUpdate;
    long gameFramesRun = 0;
    public static void main(String args[]){
        MarioGameRunnerGUI marioGameRunner = new MarioGameRunnerGUI(60);
        marioGameRunner.run();
    }

    MarioWorldPanel comp;
    WorldWrapper wrapper;
    GameState gs;
    InputState is = new InputState();
    MarioGameListener gameListener;

    public void setListener(MarioGameListener gameListener){
        this.gameListener = gameListener;
    }

    public MarioGameRunner(int fps) {
        sleepPerFrameUpdate = fps == -1 ? -1 : 1000 / fps;
        wrapper = new WorldWrapper(new FileBasedBuilder().build());
        gs = new GameState(new Player(50, 192), generateDefaultEnemies(), new ArrayList<>());
        comp = new MarioWorldPanel(gs, wrapper);
    }


     protected List<Enemy> generateDefaultEnemies() {
        List<Enemy> enemiesInactive = new ArrayList<>();
        enemiesInactive.add(new Enemy(352, 192, true));
        enemiesInactive.add(new Enemy(640, 192, true));
        enemiesInactive.add(new Enemy(816, 192, true));
        enemiesInactive.add(new Enemy(840, 192, true));
        enemiesInactive.add(new Enemy(1288, 66, true));
        enemiesInactive.add(new Enemy(1312, 66, true));
        enemiesInactive.add(new Enemy(1576, 192, true));
        enemiesInactive.add(new Enemy(1552, 192, true));
        enemiesInactive.add(new Enemy(1712, 192, true));
        enemiesInactive.add(new Enemy(1847, 192, true));
        enemiesInactive.add(new Enemy(1847, 192, true));
        enemiesInactive.add(new Enemy(1824, 192, true));
        enemiesInactive.add(new Enemy(2007, 192, true));
        enemiesInactive.add(new Enemy(1984, 192, true));
        enemiesInactive.add(new Enemy(2049, 192, true));
        enemiesInactive.add(new Enemy(2071, 192, true));
        return enemiesInactive;
    }
    public void run() {

        while (true) {
           updateFrame();
        }
    }

    public void updateFrame() {
        if(sleepPerFrameUpdate > 0) {
            try {
                Thread.sleep(sleepPerFrameUpdate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gs = GameStateRunner.runGameStateSingleFrame(gs, is, wrapper);
        if(gameFramesRun >4000) {
            gs.getPlayer().kill();
        }

        if(gameListener != null) {
            gameListener.onFrameUpdateRender(this);
        }
        gameFramesRun++;

    }


    @Override
    public int getPlayerXPosition() {
        return (int) gs.getPlayer().getPlayerXPosition();
    }

    @Override
    public void setButton(int button, boolean buttonValue) {
        switch (button){
            case GamepadButtons.A:
                is.setJump(buttonValue);
                break;
            case GamepadButtons.Left:
                is.setLeftPressed(buttonValue);
                break;
            case GamepadButtons.Right:
                is.setRigthPressed(buttonValue);
                break;
        }
    }



    @Override
    public boolean getButton(int button) {
        switch (button){
            case GamepadButtons.A:
                return is.isJump();
            case GamepadButtons.Left:
                return is.isLeftPressed();
            case GamepadButtons.Right:
                return is.isRigthPressed();
            default:
                return false;
        }
    }

    @Override
    public boolean isSlidingDownFlagpole() {
        return gs.getPlayer().getPlayerXPosition() > 3160;
    }

    @Override
    public int getTime() {
        https://www.mariowiki.com/Time_Limit
        return (int) ((gameFramesRun/60) * 2.5);
    }

    @Override
    public void reloadLevel() {
        gameFramesRun = 0;
        wrapper = new WorldWrapper(new FileBasedBuilder().build());
        gs = new GameState(new Player(50, 192), generateDefaultEnemies(),new ArrayList<>());
    }

    @Override
    public boolean isDead() {
        return gs.getPlayer().isDead();
    }

    @Override
    public void setDead() {
        gs.getPlayer().kill();
    }

    @Override
    public void reregisterGameWrapper(MarioGameListener marioGameListener) {
        this.gameListener = marioGameListener;
    }

    @Override
    public int readBlock(int y, int x) {
        int playerXPosition = getPlayerXPosition();
        return wrapper.get(y*16 , playerXPosition + ( x* 16))  == 0 ? 0 :10;
    }

    public GameState getGs() {
        return gs;
    }
}
