package nintaco.input.excitingboxing;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class ExcitingBoxingConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public ExcitingBoxingConfig() {
    super(ExcitingBoxing);
  }
  
  public ExcitingBoxingConfig(final List<ButtonMapping> buttonMappings) {
    super(ExcitingBoxing, buttonMappings);
  }
  
  public ExcitingBoxingConfig(final ExcitingBoxingConfig excitingBoxingConfig) {
    super(excitingBoxingConfig);
  }
  
  @Override
  public ExcitingBoxingConfig copy() {
    return new ExcitingBoxingConfig(this);
  }
}
