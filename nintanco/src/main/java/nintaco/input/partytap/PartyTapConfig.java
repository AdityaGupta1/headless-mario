package nintaco.input.partytap;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class PartyTapConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public PartyTapConfig() {
    super(PartyTap);
  }
  
  public PartyTapConfig(final List<ButtonMapping> buttonMappings) {
    super(PartyTap, buttonMappings);
  }
  
  public PartyTapConfig(
      final PartyTapConfig partyTapConfig) {
    super(partyTapConfig);
  } 
  
  @Override
  public PartyTapConfig copy() {
    return new PartyTapConfig(this);
  }
}