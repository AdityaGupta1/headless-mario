package nintaco.input.oekakids;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class OekaKidsConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public OekaKidsConfig() {
    super(OekaKids);
  }
  
  public OekaKidsConfig(final List<ButtonMapping> buttonMappings) {
    super(OekaKids, buttonMappings);
  }
  
  public OekaKidsConfig(final OekaKidsConfig oekaKidsConfig) {
    super(oekaKidsConfig);
  }
  
  @Override
  public OekaKidsConfig copy() {
    return new OekaKidsConfig(this);
  }
}