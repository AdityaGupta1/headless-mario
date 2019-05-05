package nintaco.gui.historyeditor.tasks;

import java.awt.*;
import nintaco.gui.historyeditor.*;
import nintaco.movie.*;

public class NewProjectTask extends SaveStateTask {

  public NewProjectTask(final Movie movie, final int tailIndex, 
        final int endFrameIndex, final HistoryTableModel historyTableModel, 
            final HistoryEditorFrame historyEditorFrame) {
    
    super(movie, tailIndex, endFrameIndex, historyTableModel, 
        historyEditorFrame);    
  }  
  
  @Override
  public void processSaveState(final byte[] saveState) {
    EventQueue.invokeLater(() -> {      
      historyEditorFrame.createNewProject(saveState);
    });
  }  
}
