package nintaco.input.gamepad;

import java.io.*;
import nintaco.input.*;
import java.util.*;

public abstract class GamepadConfig extends DeviceConfig 
    implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public GamepadConfig(final int inputDevice) {
    super(inputDevice);
  }
  
  public GamepadConfig(final int inputDevice,
      final List<ButtonMapping> buttonMappings) {
    super(inputDevice, buttonMappings);
  }
  
  public GamepadConfig(final GamepadConfig gamepadConfig) {
    super(gamepadConfig);
  }
}
