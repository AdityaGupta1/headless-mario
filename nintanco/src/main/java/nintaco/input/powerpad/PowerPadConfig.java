package nintaco.input.powerpad;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class PowerPadConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public PowerPadConfig() {
    super(PowerPad);
  }
  
  public PowerPadConfig(final List<ButtonMapping> buttonMappings) {
    super(PowerPad, buttonMappings);
  }
  
  public PowerPadConfig(final PowerPadConfig powerPadConfig) {
    super(powerPadConfig);
  }
  
  @Override
  public PowerPadConfig copy() {
    return new PowerPadConfig(this);
  }
}
