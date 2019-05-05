package nintaco.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import nintaco.*;
import nintaco.preferences.AppPrefs;

public final class PauseMenuListener implements MenuListener {

  private static final PauseMenuListener INSTANCE = new PauseMenuListener();
  
  private int selectedMenus;  
  private boolean paused;
  
  public static void addPauseMenuListener(final JMenuBar menuBar) {
    for(final Component c : menuBar.getComponents()) {
      ((JMenu)c).addMenuListener(INSTANCE);
    }
  }
  
  @Override
  public void menuSelected(MenuEvent e) {
    menuSelectionChanged(1);
  }

  @Override
  public void menuDeselected(MenuEvent e) {
    EventQueue.invokeLater(() -> menuSelectionChanged(-1));
  }

  @Override
  public void menuCanceled(MenuEvent e) {
  }
  
  private void menuSelectionChanged(final int delta) {    
    if (selectedMenus == 0 && delta > 0) {
      if (AppPrefs.getInstance().getUserInterfacePrefs().isPauseMenu()) {
        paused = true;
        App.setNoStepPause(true);
      }
    } else if (selectedMenus + delta == 0) {
      if (paused) {
        paused = false;
        App.setNoStepPause(false);
      }
    }
    selectedMenus += delta;
  }  
  
  private PauseMenuListener() {    
  }
}
