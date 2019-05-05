package nintaco.input.other;

import java.awt.*;
import nintaco.*;
import nintaco.input.*;

public class SetSongPaused implements OtherInput {
  
  private static final long serialVersionUID = 0;
  
  private final boolean paused;
  
  public SetSongPaused(final boolean paused) {
    this.paused = paused;
  }

  @Override
  public void run(final Machine machine) {
    machine.getMapper().setSongPaused(paused);
    EventQueue.invokeLater(() -> App.getImageFrame().getNsfPanel()
        .updateClock());
  }
}
