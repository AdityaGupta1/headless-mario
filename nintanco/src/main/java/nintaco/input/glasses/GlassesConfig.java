package nintaco.input.glasses;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class GlassesConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public GlassesConfig() {
    super(Glasses);
  }
  
  public GlassesConfig(final List<ButtonMapping> buttonMappings) {
    super(Glasses, buttonMappings);
  }
  
  public GlassesConfig(final GlassesConfig glassesConfig) {
    super(glassesConfig);
  }
  
  @Override
  public GlassesConfig copy() {
    return new GlassesConfig(this);
  }
}
