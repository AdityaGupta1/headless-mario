package nintaco.gui;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;

public class ToolTipsTable extends JTable implements Serializable {
  
  private static final long serialVersionUID = 0;

  private String[] columnToolTips;

  public String[] getColumnToolTips() {
    return columnToolTips;
  }

  public void setColumnToolTips(String... columnToolTips) {
    this.columnToolTips = columnToolTips;
  }
  
  @Override
  protected JTableHeader createDefaultTableHeader() {
    return new JTableHeader(columnModel) {
      @Override
      public String getToolTipText(MouseEvent e) {
        int index = columnModel.getColumnIndexAtX(e.getPoint().x);
        if (index < 0 || index >= columnModel.getColumnCount()) {
          return "";
        }
        index = columnModel.getColumn(index).getModelIndex();        
        return index < 0 || index >= columnToolTips.length ? "" 
            : columnToolTips[index];
      }
    };
  }  
}
