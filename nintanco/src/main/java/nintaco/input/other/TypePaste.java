package nintaco.input.other;

import nintaco.*;
import nintaco.gui.familybasic.*;
import nintaco.input.*;
import nintaco.preferences.*;

public class TypePaste implements OtherInput {
  
  private static final long serialVersionUID = 0;
  
  private final String program;
  private final int shortDelay;
  private final int longDelay;
  
  public TypePaste(final String program) {
    this.program = program;
    
    final FamilyBasicPrefs prefs = AppPrefs.getInstance().getFamilyBasicPrefs();
    this.shortDelay = prefs.getTypePasteShortDelay();
    this.longDelay = prefs.getTypePasteLongDelay();
  }

  @Override
  public void run(final Machine machine) {
    InputUtil.familyBasicTypePaste(program, shortDelay, longDelay);
  }
}
