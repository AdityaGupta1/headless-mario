package nintaco.gui.ramwatch;

import java.io.*;
import java.util.*;
import nintaco.gui.ramwatch.*;
import nintaco.preferences.*;

public class RamWatchGamePrefs implements Serializable {

  private static final long serialVersionUID = 0;

  private List<RamWatchRow> rows;

  public List<RamWatchRow> getRows() {
    synchronized(GamePrefs.class) {
      if (rows == null) {
        rows = new ArrayList<>();
      }
      return rows;
    }
  }

  public void setRows(List<RamWatchRow> rows) {
    synchronized(GamePrefs.class) {
      this.rows = rows;
    }
  }
}
