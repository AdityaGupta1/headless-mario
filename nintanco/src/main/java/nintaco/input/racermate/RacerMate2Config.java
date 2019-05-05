package nintaco.input.racermate;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class RacerMate2Config extends RacerMateConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public RacerMate2Config() {
    super(RacerMate2);
  }
  
  public RacerMate2Config(final List<ButtonMapping> buttonMappings) {
    super(RacerMate2, buttonMappings);
  }
  
  public RacerMate2Config(final RacerMate2Config racerMate2Config) {
    super(racerMate2Config);
  } 
  
  @Override
  public RacerMate2Config copy() {
    return new RacerMate2Config(this);
  }  
}