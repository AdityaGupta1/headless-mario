package nintaco.gui.historyeditor.change;

import java.awt.*;
import java.io.*;
import java.util.*;
import nintaco.gui.*;
import nintaco.gui.historyeditor.*;

public class InitializationChange 
    extends HistoryChange implements Serializable {
  
  private static final long serialVersionUID = 0L;
  
  public InitializationChange() {
    setDescription("Initialization");
  }

  @Override
  public int apply(final HistoryTableModel model) {
    return 0;
  }

  @Override
  public int revert(final HistoryTableModel model) {
    return 0;
  }

  @Override
  public Map<IntPoint, Color> heat(final HistoryTableModel model, 
      final int[] columnIndices, final Map<IntPoint, Color> hotCells, 
          final Color color) {
    return hotCells;
  }  
}
