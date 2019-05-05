package nintaco.input.crazyclimber;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import nintaco.input.gamepad.*;
import static nintaco.input.InputDevices.*;

public class CrazyClimberRightConfig 
    extends GamepadConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public CrazyClimberRightConfig() {
    super(CrazyClimberRight);
  }
  
  public CrazyClimberRightConfig(final List<ButtonMapping> buttonMappings) {
    super(CrazyClimberRight, buttonMappings);
  }
  
  public CrazyClimberRightConfig(
      final CrazyClimberRightConfig crazyClimberRightConfig) {
    super(crazyClimberRightConfig);
  } 
  
  @Override
  public CrazyClimberRightConfig copy() {
    return new CrazyClimberRightConfig(this);
  }
}
