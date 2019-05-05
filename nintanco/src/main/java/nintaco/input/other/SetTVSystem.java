package nintaco.input.other;

import nintaco.*;
import nintaco.input.*;
import nintaco.tv.*;

public class SetTVSystem implements OtherInput {
  
  private static final long serialVersionUID = 0;
  
  private TVSystem tvSystem;
  
  public SetTVSystem(final TVSystem tvSystem) {
    this.tvSystem = tvSystem;
  }

  @Override
  public void run(final Machine machine) {
    run(machine, tvSystem);
  }  
  
  public static void run(final Machine machine, final TVSystem tvSystem) {
    machine.getMapper().setTVSystem(tvSystem);
    machine.getPPU().setTVSystem(tvSystem);
    machine.getAPU().setTVSystem(tvSystem);
    if (App.getMachine() == machine) {
      App.getImageFrame().getImagePane().setTVSystem(tvSystem);
    }
  }
}
