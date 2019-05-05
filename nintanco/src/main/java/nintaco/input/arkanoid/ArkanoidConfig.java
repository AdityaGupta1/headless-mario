package nintaco.input.arkanoid;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class ArkanoidConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public ArkanoidConfig() {
    super(Arkanoid);
  }
  
  public ArkanoidConfig(final List<ButtonMapping> buttonMappings) {
    super(Arkanoid, buttonMappings);
  }
  
  public ArkanoidConfig(final ArkanoidConfig arkanoidConfig) {
    super(arkanoidConfig);
  }
  
  @Override
  public ArkanoidConfig copy() {
    return new ArkanoidConfig(this);
  }
}
