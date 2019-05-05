package nintaco.input.other;

import nintaco.*;
import nintaco.input.*;

public class Reset implements OtherInput {
  
  private static final long serialVersionUID = 0;

  @Override
  public void run(final Machine machine) {
    machine.getMapper().resetting();
    machine.getMapper().setVramMask(0x3FFF);
    machine.getCPU().reset();
  }  
}
