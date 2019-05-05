package nintaco.input.battlebox;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class BattleBoxConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public BattleBoxConfig() {
    super(BattleBox);
  }
  
  public BattleBoxConfig(final List<ButtonMapping> buttonMappings) {
    super(BattleBox, buttonMappings);
  }
  
  public BattleBoxConfig(final BattleBoxConfig battleBoxConfig) {
    super(battleBoxConfig);
  }
  
  @Override
  public BattleBoxConfig copy() {
    return new BattleBoxConfig(this);
  }
}