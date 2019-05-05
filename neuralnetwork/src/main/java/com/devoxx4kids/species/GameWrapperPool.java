package com.devoxx4kids.species;

import com.devoxx4kids.GAMachine;
import com.devoxx4kids.supermario.MarioGameI;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class GameWrapperPool {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(GAMachine.class);
    private final BlockingQueue<MarioGameI> pool;
    private int size;

    public GameWrapperPool(Collection<MarioGameI> gameList) {
        pool  = new ArrayBlockingQueue<>(gameList.size() + 1);
        size = gameList.size();
        pool.addAll(gameList);
    }

    public MarioGameI getGameWrapper()  {
        try {
             log.trace("Requesting game for thread {}",Thread.currentThread().getId());
            MarioGameI take = pool.take();
             log.trace("Obtained game for thread {}",Thread.currentThread().getId());
            return take;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(-1);
        return null;
    }

    void releaseGameWrapper(MarioGameI game){
        log.trace("Returning game for thread {}",Thread.currentThread().getId());
        pool.add(game);
    }

    public int numberOfWrappers() {
        return size;
    }
}
