package nintaco.gui.overscan;

import java.io.*;
import nintaco.preferences.*;
import nintaco.tv.*;
import static nintaco.tv.TVSystem.*;

public class OverscanPrefs implements Serializable {

  private static final long serialVersionUID = 0;
  
  private ScreenBorders ntscBorders;
  private ScreenBorders palBorders;
  private ScreenBorders dendyBorders;

  public ScreenBorders getNtscBorders() {
    synchronized(AppPrefs.class) {
      if (ntscBorders == null) {
        ntscBorders = NTSC.getScreenBorders();
      }
      return ntscBorders;
    }
  }

  public void setNtscBorders(final ScreenBorders ntscBorders) {
    synchronized(AppPrefs.class) {
      this.ntscBorders = ntscBorders;
    }
  }

  public ScreenBorders getPalBorders() {
    synchronized(AppPrefs.class) {
      if (palBorders == null) {
        palBorders = PAL.getScreenBorders();
      }
      return palBorders;
    }
  }

  public void setPalBorders(final ScreenBorders palBorders) {
    synchronized(AppPrefs.class) {
      this.palBorders = palBorders;
    }
  }

  public ScreenBorders getDendyBorders() {
    synchronized(AppPrefs.class) {
      if (dendyBorders == null) {
        dendyBorders = Dendy.getScreenBorders();
      }
      return dendyBorders;
    }
  }

  public void setDendyBorders(final ScreenBorders dendyBorders) {
    synchronized(AppPrefs.class) {
      this.dendyBorders = dendyBorders;
    }
  }
}
