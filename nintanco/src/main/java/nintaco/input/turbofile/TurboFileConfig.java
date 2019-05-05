package nintaco.input.turbofile;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class TurboFileConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public TurboFileConfig() {
    super(TurboFile);
  }
  
  public TurboFileConfig(final List<ButtonMapping> buttonMappings) {
    super(TurboFile, buttonMappings);
  }
  
  public TurboFileConfig(final TurboFileConfig oekaKidsConfig) {
    super(oekaKidsConfig);
  }
  
  @Override
  public TurboFileConfig copy() {
    return new TurboFileConfig(this);
  }
}
