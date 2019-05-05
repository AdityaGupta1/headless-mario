package nintaco.input.other;

import java.awt.*;
import nintaco.*;
import nintaco.input.*;

public class RequestSong implements OtherInput {
  
  private static final long serialVersionUID = 0;
  
  private final int songNumber;
  
  public RequestSong(final int songNumber) {
    this.songNumber = songNumber;
  }

  @Override
  public void run(final Machine machine) {
    machine.getMapper().requestSong(songNumber);
    EventQueue.invokeLater(() -> App.getImageFrame().getNsfPanel()
        .fireTrackChanged(songNumber));
  }
}
