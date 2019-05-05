package nintaco.input.uforce;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class UForceConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public UForceConfig() {
    super(UForce);
  }
  
  public UForceConfig(final List<ButtonMapping> buttonMappings) {
    super(UForce, buttonMappings);
  }
  
  public UForceConfig(final UForceConfig uForceConfig) {
    super(uForceConfig);
  }
  
  @Override
  public UForceConfig copy() {
    return new UForceConfig(this);
  }  
}