package nintaco.input.other;

import nintaco.*;
import nintaco.gui.rob.*;
import nintaco.input.*;

public class SetupROB implements OtherInput {
  
  private static final long serialVersionUID = 0;
  
  private final RobController rob;
  
  public SetupROB(final RobController rob) {
    this.rob = rob;
  }

  @Override
  public void run(final Machine machine) {
    InputUtil.setRob(rob);
    if (rob == null) {
      App.destroyRobFrame();
    } else {
      App.createRobFrame(rob.getState().game);
    }
  }  
}
