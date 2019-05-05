package nintaco.input.gamepad;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class Gamepad4Config extends GamepadConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public Gamepad4Config() {
    super(Gamepad4);
  }
  
  public Gamepad4Config(final List<ButtonMapping> buttonMappings) {
    super(Gamepad4, buttonMappings);
  }
  
  public Gamepad4Config(final Gamepad4Config gamepad4Config) {
    super(gamepad4Config);
  }  
  
  @Override
  public Gamepad4Config copy() {
    return new Gamepad4Config(this);
  }
}
