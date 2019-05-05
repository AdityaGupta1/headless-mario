package nintaco.input.other;

import nintaco.*;
import nintaco.input.*;

public class EjectDisk implements OtherInput {
  
  private static final long serialVersionUID = 0;

  @Override
  public void run(final Machine machine) {
    machine.getMapper().ejectDisk();
  }
}
