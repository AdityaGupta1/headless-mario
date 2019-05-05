package nintaco.input.gamepad;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class Gamepad1Config extends GamepadConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public Gamepad1Config() {
    super(Gamepad1);
  }
  
  public Gamepad1Config(final List<ButtonMapping> buttonMappings) {
    super(Gamepad1, buttonMappings);
  }
  
  public Gamepad1Config(final Gamepad1Config gamepad1Config) {
    super(gamepad1Config);
  } 
  
  @Override
  public Gamepad1Config copy() {
    return new Gamepad1Config(this);
  }
}
