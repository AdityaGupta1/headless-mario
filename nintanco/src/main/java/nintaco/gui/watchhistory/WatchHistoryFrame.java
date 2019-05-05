package nintaco.gui.watchhistory;

import java.awt.event.*;
import javax.swing.*;
import static nintaco.util.GuiUtil.*;

public class WatchHistoryFrame extends JFrame {
  
  private WatchHistoryPanel watchHistoryPanel;
  
  public WatchHistoryFrame() {
    initComponents();
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    scaleFonts(this);
    pack();
    moveToImageFrameMonitor(this);
  }
  
  public WatchHistoryPanel getWatchHistoryPanel() {
    return watchHistoryPanel;
  }
  
  private void closeFrame() {
    dispose();
  }
  
  private void initComponents() {
    setTitle("Watch History");
    watchHistoryPanel = new WatchHistoryPanel(this);
    setContentPane(watchHistoryPanel);
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        watchHistoryPanel.resume(false);
      }
    });
  }
  
  public void destroy() {
    watchHistoryPanel.close();
    closeFrame();
  }
}
