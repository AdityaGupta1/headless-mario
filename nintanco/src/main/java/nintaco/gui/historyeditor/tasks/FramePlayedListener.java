package nintaco.gui.historyeditor.tasks;

import nintaco.*;
import nintaco.task.*;

@FunctionalInterface
public interface FramePlayedListener {
  void framePlayed(Task task, int frameIndex, MachineRunner machineRunner);
}
