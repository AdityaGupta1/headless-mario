package nintaco.gui.screenshots;

import java.awt.image.*;
import java.io.*;
import java.lang.ref.*;
import java.util.*;
import javax.imageio.ImageIO;
import nintaco.*;
import nintaco.preferences.*;
import nintaco.gui.exportmedia.*;
import nintaco.gui.exportmedia.preferences.*;
import nintaco.tv.*;
import static nintaco.files.FileUtil.*;
import static nintaco.gui.image.ImagePane.*;
import static nintaco.tv.TVSystem.*;
import static nintaco.util.GuiUtil.*;
import static nintaco.util.StringUtil.*;

public final class ScreenshotSaver {
  
  private static final class QueueElement {
    private final BufferedImage image;
    private final TVSystem tvSystem;

    public QueueElement(final BufferedImage image, final TVSystem tvSystem) {
      this.image = image;
      this.tvSystem = tvSystem == null ? NTSC : tvSystem;
    }

    public BufferedImage getImage() {
      return image;
    }

    public TVSystem getTvSystem() {
      return tvSystem;
    }    
  }
  
  private static final List<QueueElement> queue = new ArrayList<>();
  private static Thread thread;
  
  private static WeakReference<ImageConverter> weakConverter;
  
  private ScreenshotSaver() {    
  }
  
  public static void save(final int[] screen, final TVSystem tvSystem) {
    final BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, 
        BufferedImage.TYPE_INT_RGB);
    final int[] data = ((DataBufferInt)image.getRaster().getDataBuffer())
          .getData();
    System.arraycopy(screen, 0, data, 0, screen.length);
    synchronized(queue) {
      queue.add(new QueueElement(image, tvSystem));
      if (thread == null) {
        thread = new Thread(ScreenshotSaver::processQueue, 
            "Screenshot Saver Thread");
        thread.start();
      }
    }
  }
  
  private static void processQueue() {
    while(true) {
      final QueueElement element;
      synchronized(queue) {
        if (queue.isEmpty()) {
          thread = null;
          return;
        } else {
          element = queue.remove(0);
        }
      }
      try {
        processQueueElement(element);
      } catch(final Throwable t) {
//        t.printStackTrace();
      }
    }
  }
  
  private static void processQueueElement(final QueueElement element) 
      throws Throwable {
    final String dir = AppPrefs.getInstance().getPaths().getScreenshotsDir();
    mkdir(dir);    
    
    final String base = getFileNameWithoutExtension(App.getEntryFileName());
    final String fileBase = isBlank(base) ? "image" : base; 
    final ExportMediaFilePrefs prefs = AppPrefs.getInstance()
        .getScreenshotPrefs();    
    final String extension = getWritableImageFileFormats()[prefs.getFileType()];
    final File file = createUniqueFile(dir, fileBase, extension, true, 
        prefs.getSuffix());
    
    ImageConverter imageConverter = null;
    if (weakConverter != null) {
      imageConverter = weakConverter.get();
    }
    if (imageConverter != null && !(imageConverter.getPrefs().equals(prefs) 
        && imageConverter.getTvSystem() == element.getTvSystem())) {
      imageConverter.dispose();
      imageConverter = null;
    }
    if (imageConverter == null) {
      imageConverter = new ImageConverter(prefs, element.getTvSystem(), false);      
    } 
    imageConverter.setImage(element.getImage());
    final BufferedImage result = imageConverter.convert();    
    weakConverter = new WeakReference<>(imageConverter);
    
    ImageIO.write(result, extension, file);
  }
}