package nintaco.gui.historyeditor.tasks;

import java.awt.*;
import nintaco.gui.historyeditor.*;
import nintaco.gui.historyeditor.change.*;
import nintaco.movie.*;

public class TrimTopTask extends SaveStateTask {

  public TrimTopTask(final Movie movie, final int tailIndex, 
        final int endFrameIndex, final HistoryTableModel historyTableModel, 
            final HistoryEditorFrame historyEditorFrame) {
    
    super(movie, tailIndex, endFrameIndex, historyTableModel, 
        historyEditorFrame);    
  }  
  
  @Override
  public void processSaveState(final byte[] saveState) {
    final DeleteChange change = new DeleteChange(0, endFrameIndex + 1);
    change.setSaveState(saveState);        
    change.setDescription(HistoryTableModel.createRange("Trim top", 0, 
        endFrameIndex));
    EventQueue.invokeLater(() -> {
      historyTableModel.addChange(change);
      historyEditorFrame.runToLastClickedRow(0);
    });
  }  
}
