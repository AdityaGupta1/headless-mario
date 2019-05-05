package nintaco.input.pachinko;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class PachinkoConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public PachinkoConfig() {
    super(Pachinko);
  }
  
  public PachinkoConfig(final List<ButtonMapping> buttonMappings) {
    super(Pachinko, buttonMappings);
  }
  
  public PachinkoConfig(final PachinkoConfig pachinkoConfig) {
    super(pachinkoConfig);
  }
  
  @Override
  public PachinkoConfig copy() {
    return new PachinkoConfig(this);
  }
}
