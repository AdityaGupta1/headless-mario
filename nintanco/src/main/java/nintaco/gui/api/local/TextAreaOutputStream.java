package nintaco.gui.api.local;

import java.awt.EventQueue;
import java.io.*;
import javax.swing.*;

public class TextAreaOutputStream extends OutputStream {

  private final JTextArea textArea;

  public TextAreaOutputStream(final JTextArea textArea) {
    this.textArea = textArea;
  }

  @Override
  public void write(final int b) throws IOException {
    if (EventQueue.isDispatchThread()) {
      textArea.append(String.valueOf((char)b));
    } else {
      EventQueue.invokeLater(() -> {
        try {
          write(b);
        } catch(final Throwable t) {          
        }
      });
    }
  }
}
