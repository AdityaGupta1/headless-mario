package nintaco.input.barcodebattler;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class BarcodeBattlerConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public BarcodeBattlerConfig() {
    super(BarcodeBattler);
  }
  
  public BarcodeBattlerConfig(final List<ButtonMapping> buttonMappings) {
    super(BarcodeBattler, buttonMappings);
  }
  
  public BarcodeBattlerConfig(final BarcodeBattlerConfig barcodeBattlerConfig) {
    super(barcodeBattlerConfig);
  }
  
  @Override
  public BarcodeBattlerConfig copy() {
    return new BarcodeBattlerConfig(this);
  }
}
