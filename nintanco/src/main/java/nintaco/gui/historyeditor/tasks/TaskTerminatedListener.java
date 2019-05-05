package nintaco.gui.historyeditor.tasks;

import nintaco.task.*;

@FunctionalInterface
public interface TaskTerminatedListener {
  void taskTerminated(Task task);
}
