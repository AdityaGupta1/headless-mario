package nintaco.gui.ramwatch;

import java.awt.*;
import javax.swing.*;

public class Separator extends JPanel {
  
  public Separator() {
    setOpaque(true);
  }
  
  @Override
  protected void paintComponent(final Graphics g) {        
    final int width = getWidth();
    final int height = getHeight();
    final int y = height >> 1;
    g.setColor(getBackground());
    g.fillRect(0, 0, width, height);
    g.setColor(getForeground());
    g.drawLine(2, y, width - 2, y);
  }
}
