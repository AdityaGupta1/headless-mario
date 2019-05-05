package nintaco.input.subor;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class SuborConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public SuborConfig() {
    super(Subor);
  }
  
  public SuborConfig(final List<ButtonMapping> buttonMappings) {
    super(Subor, buttonMappings);
  }
  
  public SuborConfig(final SuborConfig horiTrackConfig) {
    super(horiTrackConfig);
  }
  
  @Override
  public SuborConfig copy() {
    return new SuborConfig(this);
  }
}
