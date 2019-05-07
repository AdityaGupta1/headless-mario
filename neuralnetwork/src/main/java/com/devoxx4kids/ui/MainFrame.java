package com.devoxx4kids.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    public static void main(String args[]) {
        new MainFrame();
    }


    public MainFrame() throws HeadlessException {
        super();
        this.setSize(new Dimension(1100,1000));
        this.add(new ControlPanel());
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
