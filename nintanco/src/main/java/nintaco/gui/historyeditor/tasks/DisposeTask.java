package nintaco.gui.historyeditor.tasks;

import java.awt.*;
import nintaco.*;
import nintaco.gui.historyeditor.*;
import nintaco.gui.image.*;
import nintaco.mappers.nintendo.vs.*;
import nintaco.movie.*;
import static nintaco.movie.Movie.*;

public class DisposeTask extends SaveStateTask {

  public DisposeTask(final Movie movie, final int tailIndex, 
        final int endFrameIndex, final HistoryTableModel historyTableModel, 
            final HistoryEditorFrame historyEditorFrame) {
    
    super(movie, tailIndex, endFrameIndex, historyTableModel, 
        historyEditorFrame, BLOCK_SIZE);    
  }  
  
  @Override
  protected void saveState(final MachineRunner machineRunner) {
    EventQueue.invokeLater(historyEditorFrame::closeFrame);
    movie.truncate();
    machineRunner.setMovie(movie);
    machineRunner.getPPU().setScreenRenderer(App.getImageFrame()
        .getImagePane());
    if (movie.isVsDualSystem()) {
      final SubMonitorFrame subMonitorFrame = App.getSubMonitorFrame();
      if (subMonitorFrame != null) {
        ((MainCPU)machineRunner.getCPU()).getSubPPU().setScreenRenderer(
            subMonitorFrame.getImagePane());
      }
    }
    machineRunner.getAPU().setAudioProcessor(App.getSystemAudioProcessor());    
    App.setMachineRunner(machineRunner);
    App.updateFrames(machineRunner);
    new Thread(machineRunner).start();
  }
  
  @Override
  public void processSaveState(byte[] saveState) {
  }
}
