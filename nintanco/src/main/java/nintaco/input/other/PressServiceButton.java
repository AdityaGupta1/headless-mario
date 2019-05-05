package nintaco.input.other;

import nintaco.*;
import nintaco.input.*;

public class PressServiceButton implements OtherInput {
  
  private static final long serialVersionUID = 0;
  
  private final int vsSystem;
  
  public PressServiceButton(final int vsSystem) {
    this.vsSystem = vsSystem;
  }

  @Override
  public void run(final Machine machine) {
    machine.getMapper().pressServiceButton(vsSystem);
  }  
}
