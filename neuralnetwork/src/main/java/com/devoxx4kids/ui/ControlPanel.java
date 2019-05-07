package com.devoxx4kids.ui;

import com.devoxx4kids.GAMachine;
import com.devoxx4kids.RunConfiguration;
import com.devoxx4kids.species.GAEvent;
import com.devoxx4kids.species.GAMachineObserver;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ControlPanel extends JPanel implements GAMachineObserver {

    static Function<Integer,String> displayDouble = (val) ->  "" + val/100.0;
    static Function<Integer,String> displayInt = (val) ->  "" + val;
    private XYSeries seriesMean;
    private XYSeries seriesTop;
    private UIBasedRunConfigurationBuilder uiBasedRunConfigurationBuilder = new UIBasedRunConfigurationBuilder(10,RunConfiguration.RUN_TYPE.HEADLESS,4);
    private List<ConfigurationOption> configurables = new ArrayList<>();
    {
        configurables.add(new ConfigurationOption("Generations to run", (value) -> { uiBasedRunConfigurationBuilder.setGenerationsToRun(value.intValue()); generationsToRun= value.intValue(); },1,3000,10,displayInt));
        configurables.add(new ConfigurationOption("add Connection Chance", (value) -> uiBasedRunConfigurationBuilder.setAddConnectionChance(value/100.0),0,500,250,displayDouble));
        configurables.add(new ConfigurationOption("add Node Chance", (value) -> uiBasedRunConfigurationBuilder.setAddNodeChance(value/100.0),1,200,150,displayDouble));
        configurables.add(new ConfigurationOption("mutate weight Chance", (value) -> uiBasedRunConfigurationBuilder.setMutateWeightChance(value/100.0),1,100,45,displayDouble));
        configurables.add(new ConfigurationOption("Generation Size", (value) -> uiBasedRunConfigurationBuilder.setGenerationSize(value.intValue()),1,100,20,displayInt));
        configurables.add(new ConfigurationOption("Generation top Number", (value) -> uiBasedRunConfigurationBuilder.setGenerationTopNumber(value.intValue()),0,10,5,displayInt));
        configurables.add(new ConfigurationOption("Crossover chance", (value) -> uiBasedRunConfigurationBuilder.setCrossoverChance(value/100.0),1,100,75,displayDouble));
        configurables.add(new ConfigurationOption("Species top percent", (value) -> uiBasedRunConfigurationBuilder.setSpeciesTopPercent(value/100.0),1,100,10,displayDouble));
        configurables.add(new ConfigurationOption("Stale threshold", (value) -> uiBasedRunConfigurationBuilder.setStaleThreshold(value.intValue()),1,100,10,displayInt));
    }

    private volatile boolean   isRunning = false;
    private  int generationsToRun = 10;
    private int generationsRan = 0;
    private ControlPanel cp;
    private JProgressBar progressBar;
    JButton run = new JButton("TRAIN");
    public ControlPanel() {
        super();
        cp = this;
        this.setSize(new Dimension(800,1000));

        configurables.stream().forEach(e -> {
            JLabel label = new JLabel(e.name);
            JSlider slider = new JSlider(e.min, e.max, e.defaultValue);
            JLabel valueLabel = new JLabel("" +e.currentValueDisplay( e.defaultValue));
            add(label);
            add(slider);
            add(valueLabel);

            slider.addChangeListener((change) -> {
                JSlider source = (JSlider) change.getSource();
                valueLabel.setText(""+e.currentValueDisplay(source.getValue()));
                e.update(source.getValue());
            });
        });

        ButtonGroup bg =	new ButtonGroup();
        JRadioButton headless = new JRadioButton("Headless");
        headless.addActionListener(e -> uiBasedRunConfigurationBuilder.setDisplayer(RunConfiguration.RUN_TYPE.HEADLESS));
        headless.setSelected(true);
        JRadioButton nintanco = new JRadioButton("Nitanco");
        nintanco.addActionListener(e -> uiBasedRunConfigurationBuilder.setDisplayer(RunConfiguration.RUN_TYPE.NINTANCO));
        bg.add(headless);
        bg.add(nintanco);

        add(headless);
        add(nintanco);
        run.addActionListener(e -> {
            seriesMean.clear();
            seriesTop.clear();
            run.setEnabled(false);
            if(e.getSource() != run){
                return;
            }
            generationsRan = 0;
            if(!isRunning) {
                isRunning = true;
                new GAMachine(cp,uiBasedRunConfigurationBuilder.createUIBasedRunConfiguration());
        }
        });
        this.add(run);
        this.progressBar = new JProgressBar();
        add(progressBar);

       seriesMean =  new XYSeries("Fitness Data");
        seriesTop =  new XYSeries("Fitness Top");
        XYSeriesCollection dataset = new XYSeriesCollection(seriesMean);
        dataset.addSeries(seriesTop);
        JFreeChart lineChart =  ChartFactory.createXYLineChart(
                "Fitness",
                "Fitness",
                "Generation",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setSize(new Dimension(400,400));

        add(chartPanel);


    }

    @Override
    public void gaEventOccured(GAEvent gaEvent, EventCtx eventCtx) {

        if(gaEvent == GAEvent.GAME_COMPLETE ){
            run.setEnabled(true);
            progressBar.setValue(0);
            generationsRan= 0;
            isRunning = false;
            validate();
        } else {

            if(eventCtx.getGeneration() % 10 == 0){
                seriesMean.add(eventCtx.getGeneration(),eventCtx.getMeanFitness());
                seriesTop.add(eventCtx.getGeneration(),eventCtx.getTopFitness());
            }
            generationsRan++;
            progressBar.setValue((int) (((double) generationsRan / generationsToRun) * 100));
        }
    }

    class ConfigurationOption {

        private String name;
        private  Consumer<Double> updater;
        private int min;
        private int max;
        private int defaultValue;
        private Function<Integer,String>  currentValueDisp;

        public ConfigurationOption(String name, Consumer<Double> updater, int min, int max, int defaultValue,Function<Integer,String> currentValueDisp) {
            this.name = name;
            this.updater = updater;
            this.min = min;
            this.max = max;
            this.defaultValue = defaultValue;
            this.currentValueDisp = currentValueDisp;
        }

        void update(double value){
            updater.accept(value);
        }

        String currentValueDisplay(int val){
            return currentValueDisp.apply(val);
        }
    }
}
