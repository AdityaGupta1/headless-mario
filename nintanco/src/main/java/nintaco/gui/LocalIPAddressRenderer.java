package nintaco.gui;

import java.awt.*;
import java.net.*;
import javax.swing.*;

public class LocalIPAddressRenderer extends DefaultListCellRenderer {

  @Override
  public Component getListCellRendererComponent(final JList<?> list, 
      final Object value, final int index, final boolean isSelected, 
        final boolean cellHasFocus) {
    
    return super.getListCellRendererComponent(list, 
        value == null ? "localhost" : ((InetAddress)value).getHostAddress(), 
            index, isSelected, cellHasFocus);
  }  
}
