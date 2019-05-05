package nintaco.input.taptapmat;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class TapTapMatConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public TapTapMatConfig() {
    super(TapTapMat);
  }
  
  public TapTapMatConfig(final List<ButtonMapping> buttonMappings) {
    super(TapTapMat, buttonMappings);
  }
  
  public TapTapMatConfig(final TapTapMatConfig tapTapMatConfig) {
    super(tapTapMatConfig);
  }
  
  @Override
  public TapTapMatConfig copy() {
    return new TapTapMatConfig(this);
  }
}
