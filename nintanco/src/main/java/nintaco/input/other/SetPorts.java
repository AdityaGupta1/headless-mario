package nintaco.input.other;

import nintaco.*;
import nintaco.input.*;
import nintaco.preferences.*;

public class SetPorts implements OtherInput {
  
  private static final long serialVersionUID = 0;

  private final Ports ports;
  
  public SetPorts(final Ports ports) {
    this.ports = ports;
  }
  
  @Override
  public void run(final Machine machine) {
    if (App.getNetplayClient().isRunning()) {
//      InputUtil.setOverrides(ports.getConsoleType(), ports.isMultitap());
    } else {
      AppPrefs.getInstance().getInputs().setPorts(ports);
      AppPrefs.save();      
    }
    InputUtil.handleSettingsChange();
  }
}
