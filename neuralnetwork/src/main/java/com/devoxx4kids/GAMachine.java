package com.devoxx4kids;

import com.devoxx4kids.species.*;
import com.devoxx4kids.supermario.MarioGameI;
import com.devoxx4kids.supermario.MarioGameRunner;
import com.devoxx4kids.supermario.MarioGameRunnerGUI;
import com.devoxx4kids.supermario.NintancoGameInterface;
import com.devoxx4kids.ui.EventCtx;
import nintaco.App;
import nintaco.Main;
import nintaco.api.API;
import nintaco.api.ApiSource;
import nintaco.api.local.LocalAPI;
import nintaco.gui.image.ImageFrame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class GAMachine  implements GAMachineObserver {
    private static final Logger log = LogManager.getLogger(GAMachine.class);
    private  Generation generation;
    boolean isNintancoRunning = false;
    private NetworkGenerator seededGenerator = () -> NetworkBuilder.fromJSON("{\"hiddenNodes\":[{\"id\":\"1234\" ,\"inputNodes\":[{\"id\":\"bx1y14\", \"weight\":1.0}], \"outputNodes\":[{\"id\":\"O7\",\"weight\":1.0 }]}]}");
    private RunConfiguration runConfiguration;


    public GAMachine(GAMachineObserver oberserver,RunConfiguration runConfiguration) {
        this.runConfiguration =runConfiguration;
        Stack<MarioGameI> headlessRuns = new Stack<>();
        IntStream.range(0,runConfiguration.getParallelLevel()).mapToObj(e -> new MarioGameRunner(-1)).forEach(headlessRuns::push);
        generation = new Generation(new GameWrapperPool(headlessRuns),seededGenerator,
                Arrays.asList(this::gaEventOccured,oberserver),runConfiguration);
        generation.runNextGeneration();
    }

    void runSingleNetworkOnNintanco(SingleNetwork sn) throws Throwable {

        new Main().runGame();
        LocalAPI.setLocalAPI(new LocalAPI());
        API api = ApiSource.getAPI();
        ImageFrame imageFrame = App.getImageFrame();

        imageFrame.fileOpened(new File(
                GAMachine.class.getResource("/SuperMarioBros.nes").getFile()),null,false,null,null);

        Thread.sleep(4000);
        api.loadState(GAMachine.class.getResource("/SMB.save").getFile());
        NintancoGameInterface nintancoGameInterface = new NintancoGameInterface(api);
        Thread.sleep(4000);

        api.addFrameListener(() -> sn.onFrameUpdateRender(nintancoGameInterface));
        api.run();
    }

    @Override
    public void gaEventOccured(GAEvent gaEvent, EventCtx eventCtx) {

        if(gaEvent == GAEvent.GAME_COMPLETE  && !isNintancoRunning){
            try {
                isNintancoRunning = true;

                if(runConfiguration.getDisplayer() == RunConfiguration.RUN_TYPE.HEADLESS) {

                    new Thread(() -> {
                        MarioGameRunnerGUI marioGameRunnerGUI = new MarioGameRunnerGUI(50);
                        SingleNetwork highestValuedNetwork = generation.getHighestValuedNetwork();
                        highestValuedNetwork.setAgressiveRestartMode(false);
                        marioGameRunnerGUI.setListener(highestValuedNetwork);

                        while (!marioGameRunnerGUI.getGs().getPlayer().isDead()) {
                            marioGameRunnerGUI.updateFrame();
                        }
                    }).start();
                } else {
                    SingleNetwork highestValuedNetwork = generation.getHighestValuedNetwork();
                    highestValuedNetwork.setAgressiveRestartMode(false);
                    runSingleNetworkOnNintanco(highestValuedNetwork);
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}




