package nintaco.input.other;

import nintaco.*;
import nintaco.input.*;
import nintaco.input.familybasic.*;
import static nintaco.util.GuiUtil.*;

public class PasteProgram implements OtherInput {
  
  private static final long serialVersionUID = 0;
  
  private final String program;
  
  public PasteProgram(final String program) {
    this.program = program;
  }

  @Override
  public void run(final Machine machine) {
    App.setNoStepPause(true);
    try {
      FamilyBasicUtil.pasteProgram(program);
    } catch(final MessageException e) {
      displayError(App.getImageFrame(), e.getMessage());
    } finally {
      App.setNoStepPause(false);
    }
  }
}
