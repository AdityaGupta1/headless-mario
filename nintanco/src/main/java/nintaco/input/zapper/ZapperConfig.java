package nintaco.input.zapper;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class ZapperConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public ZapperConfig() {
    super(Zapper);
  }
  
  public ZapperConfig(final List<ButtonMapping> buttonMappings) {
    super(Zapper, buttonMappings);
  }
  
  public ZapperConfig(final ZapperConfig zapperConfig) {
    super(zapperConfig);
  }
  
  @Override
  public ZapperConfig copy() {
    return new ZapperConfig(this);
  }
}
