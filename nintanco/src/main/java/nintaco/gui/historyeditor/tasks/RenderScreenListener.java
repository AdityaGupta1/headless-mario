package nintaco.gui.historyeditor.tasks;

import nintaco.*;
import nintaco.movie.*;

public interface RenderScreenListener {
  void completedRendering(final MachineRunner machineRunner, 
      MovieFrame movieFrame);
}
