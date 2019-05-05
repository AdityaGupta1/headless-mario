package nintaco.input.doremikkokeyboard;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class DoremikkoKeyboardConfig 
    extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public DoremikkoKeyboardConfig() {
    super(DoremikkoKeyboard);
  }
  
  public DoremikkoKeyboardConfig(final List<ButtonMapping> buttonMappings) {
    super(DoremikkoKeyboard, buttonMappings);
  }
  
  public DoremikkoKeyboardConfig(
      final DoremikkoKeyboardConfig doremikkoKeyboardConfig) {
    super(doremikkoKeyboardConfig);
  }
  
  @Override
  public DoremikkoKeyboardConfig copy() {
    return new DoremikkoKeyboardConfig(this);
  }
}