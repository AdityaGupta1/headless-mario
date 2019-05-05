package nintaco.input.crazyclimber;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import nintaco.input.gamepad.*;
import static nintaco.input.InputDevices.*;

public class CrazyClimberLeftConfig 
    extends GamepadConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public CrazyClimberLeftConfig() {
    super(CrazyClimberLeft);
  }
  
  public CrazyClimberLeftConfig(final List<ButtonMapping> buttonMappings) {
    super(CrazyClimberLeft, buttonMappings);
  }
  
  public CrazyClimberLeftConfig(
      final CrazyClimberLeftConfig crazyClimberLeftConfig) {
    super(crazyClimberLeftConfig);
  } 
  
  @Override
  public CrazyClimberLeftConfig copy() {
    return new CrazyClimberLeftConfig(this);
  }
}
