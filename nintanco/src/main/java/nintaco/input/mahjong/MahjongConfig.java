package nintaco.input.mahjong;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class MahjongConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public MahjongConfig() {
    super(Mahjong);
  }
  
  public MahjongConfig(final List<ButtonMapping> buttonMappings) {
    super(Mahjong, buttonMappings);
  }
  
  public MahjongConfig(final MahjongConfig mahjongConfig) {
    super(mahjongConfig);
  }
  
  @Override
  public MahjongConfig copy() {
    return new MahjongConfig(this);
  }
}

