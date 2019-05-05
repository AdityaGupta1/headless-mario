package nintaco.input.racermate;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class RacerMate1Config extends RacerMateConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public RacerMate1Config() {
    super(RacerMate1);
  }
  
  public RacerMate1Config(final List<ButtonMapping> buttonMappings) {
    super(RacerMate1, buttonMappings);
  }
  
  public RacerMate1Config(final RacerMate1Config racerMate1Config) {
    super(racerMate1Config);
  } 
  
  @Override
  public RacerMate1Config copy() {
    return new RacerMate1Config(this);
  }  
}