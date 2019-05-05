package nintaco.input.gamepad;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class Gamepad2Config extends GamepadConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public Gamepad2Config() {
    super(Gamepad2);
  }
  
  public Gamepad2Config(final List<ButtonMapping> buttonMappings) {
    super(Gamepad2, buttonMappings);
  }
  
  public Gamepad2Config(final Gamepad2Config gamepad2Config) {
    super(gamepad2Config);
  }
  
  @Override
  public Gamepad2Config copy() {
    return new Gamepad2Config(this);
  }
}
