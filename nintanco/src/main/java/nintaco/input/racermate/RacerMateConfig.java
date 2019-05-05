package nintaco.input.racermate;

import java.io.*;
import java.util.*;
import nintaco.input.*;

public abstract class RacerMateConfig extends DeviceConfig 
    implements Serializable {
  
  private static final long serialVersionUID = 0;
 
  public RacerMateConfig(final int inputDevice) {
    super(inputDevice);
  }
  
  public RacerMateConfig(final int inputDevice,
      final List<ButtonMapping> buttonMappings) {
    super(inputDevice, buttonMappings);
  }
  
  public RacerMateConfig(final RacerMateConfig racermateConfig) {
    super(racermateConfig);
  }  
}
