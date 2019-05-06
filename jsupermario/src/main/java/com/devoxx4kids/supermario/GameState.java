package com.devoxx4kids.supermario;

import com.devoxx4kids.supermario.mario.Enemy;
import com.devoxx4kids.supermario.mario.Player;

import java.util.ArrayList;
import java.util.List;

public class GameState {


    private Player player;
    private List<Enemy> inactiveEnemy;
    private List<Enemy> activeEnemy;
    private List<Enemy> enemiesToRemove;
    private List<Enemy> enemiesToRemoveFromAdded;

    public GameState(Player player, List<Enemy> inactiveEnemy, List<Enemy> activeEnemy) {
        this.player = player;
        this.inactiveEnemy = inactiveEnemy;
        this.activeEnemy = activeEnemy;
        this.enemiesToRemove = new ArrayList<>();
        enemiesToRemoveFromAdded = new ArrayList<>();
    }

    public List<Enemy> getEnemiesToRemove() {
        return enemiesToRemove;
    }

    public void setEnemiesToRemove(List<Enemy> enemiesToRemove) {
        this.enemiesToRemove = enemiesToRemove;
    }

    public List<Enemy> getEnemiesToRemoveFromAdded() {
        return enemiesToRemoveFromAdded;
    }

    public void setEnemiesToRemoveFromAdded(List<Enemy> enemiesToRemoveFromAdded) {
        this.enemiesToRemoveFromAdded = enemiesToRemoveFromAdded;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Enemy> getInactiveEnemy() {
        return inactiveEnemy;
    }

    public List<Enemy> getActiveEnemy() {
        return activeEnemy;
    }


}
