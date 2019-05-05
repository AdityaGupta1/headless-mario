package nintaco.input.familybasic.keyboard;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class KeyboardConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public KeyboardConfig() {
    super(Keyboard);
  }
  
  public KeyboardConfig(final List<ButtonMapping> buttonMappings) {
    super(Keyboard, buttonMappings);
  }
  
  public KeyboardConfig(final KeyboardConfig keyboardConfig) {
    super(keyboardConfig);
  }
  
  @Override
  public KeyboardConfig copy() {
    return new KeyboardConfig(this);
  }
}
