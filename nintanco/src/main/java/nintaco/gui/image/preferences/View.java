package nintaco.gui.image.preferences;

import java.awt.*;
import java.io.*;
import nintaco.gui.image.filters.*;
import nintaco.preferences.*;

public class View implements Serializable {

  private static final long serialVersionUID = 0;
  
  private String lookAndFeelClassName;
  private String themeClassName;  
  private Float fontScale;
  private Dimension fileChooserSize;
  private Boolean backgroundEnabled;
  private Boolean spritesEnabled;
  private Boolean spriteBoxesEnabled;
  private Boolean showFPS;
  private Boolean showInputDevices;
  private Boolean showStatusMessages;
  private Boolean noSpriteLimit;
  private VideoFilterDescriptor videoFilter;

  public String getLookAndFeelClassName() {
    synchronized(AppPrefs.class) {
      return lookAndFeelClassName;
    }
  }

  public void setLookAndFeelClassName(String lookAndFeelClassName) {
    synchronized(AppPrefs.class) {
      this.lookAndFeelClassName = lookAndFeelClassName;
    }
  }

  public String getThemeClassName() {
    synchronized(AppPrefs.class) {
      return themeClassName;
    }
  }

  public void setThemeClassName(String themeClassName) {
    synchronized(AppPrefs.class) {
      this.themeClassName = themeClassName;
    }
  }

  public float getFontScale() {
    synchronized(AppPrefs.class) {
      if (fontScale == null) {
        fontScale = 1f;
      }
      return fontScale;
    }
  }

  public void setFontScale(float fontScale) {
    synchronized(AppPrefs.class) {
      this.fontScale = fontScale;
      this.fileChooserSize = null; // Reset JFileChooser size on font scale
    }
  }

  public Dimension getFileChooserSize() {
    synchronized(AppPrefs.class) {
      return fileChooserSize;
    }
  }

  public void setFileChooserSize(final Dimension fileChooserSize) {
    synchronized(AppPrefs.class) {
      this.fileChooserSize = fileChooserSize;
    }
  }

  public boolean isBackgroundEnabled() {
    synchronized(AppPrefs.class) {
      if (backgroundEnabled == null) {
        backgroundEnabled = true;
      }
      return backgroundEnabled;
    }
  }

  public void setBackgroundEnabled(final boolean backgroundEnabled) {
    synchronized(AppPrefs.class) {
      this.backgroundEnabled = backgroundEnabled;
    }
  }
  
  public boolean isSpritesEnabled() {
    synchronized(AppPrefs.class) {
      if (spritesEnabled == null) {
        spritesEnabled = true;
      }
      return spritesEnabled;
    }
  }

  public void setSpritesEnabled(final boolean spritesEnabled) {
    synchronized(AppPrefs.class) {
      this.spritesEnabled = spritesEnabled;
    }
  }  

  public boolean isSpriteBoxesEnabled() {
    synchronized(AppPrefs.class) {
      if (spriteBoxesEnabled == null) {
        spriteBoxesEnabled = false;
      }
      return spriteBoxesEnabled;
    }
  }

  public void setSpriteBoxesEnabled(final boolean spriteBoxesEnabled) {
    synchronized(AppPrefs.class) {
      this.spriteBoxesEnabled = spriteBoxesEnabled;
    }
  }

  public boolean isShowFPS() {
    synchronized(AppPrefs.class) {
      if (showFPS == null) {
        showFPS = false;
      }
      return showFPS;
    }
  }

  public void setShowFPS(final boolean showFPS) {
    synchronized(AppPrefs.class) {      
      this.showFPS = showFPS;
    }
  }

  public boolean isShowInputDevices() {
    synchronized(AppPrefs.class) {
      if (showInputDevices == null) {
        showInputDevices = false;
      }
      return showInputDevices;
    }
  }

  public void setShowInputDevices(final boolean showInputDevices) {
    synchronized(AppPrefs.class) {
      this.showInputDevices = showInputDevices;
    }
  }

  public boolean isShowStatusMessages() {
    synchronized(AppPrefs.class) {
      if (showStatusMessages == null) {
        showStatusMessages = true;
      }
      return showStatusMessages;
    }
  }

  public void setShowStatusMessages(final boolean showStatusMessages) {
    synchronized(AppPrefs.class) {
      this.showStatusMessages = showStatusMessages;
    }
  }

  public boolean isNoSpriteLimit() {
    synchronized(AppPrefs.class) {
      if (noSpriteLimit == null) {
        noSpriteLimit = false;
      }
      return noSpriteLimit;
    }
  }

  public void setNoSpriteLimit(final boolean noSpriteLimit) {
    synchronized(AppPrefs.class) {
      this.noSpriteLimit = noSpriteLimit;
    }
  }

  public VideoFilterDescriptor getVideoFilter() {
    synchronized(AppPrefs.class) {
      if (videoFilter == null) {
        videoFilter = VideoFilterDescriptor.NoFilter;
      }
      return videoFilter;
    }
  }

  public void setVideoFilter(VideoFilterDescriptor videoFilter) {
    synchronized(AppPrefs.class) {
      this.videoFilter = videoFilter;
    }
  }
}
