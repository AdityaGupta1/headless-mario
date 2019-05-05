package nintaco.input.konamihypershot;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class KonamiHyperShotConfig 
    extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public KonamiHyperShotConfig() {
    super(KonamiHyperShot);
  }
  
  public KonamiHyperShotConfig(final List<ButtonMapping> buttonMappings) {
    super(KonamiHyperShot, buttonMappings);
  }
  
  public KonamiHyperShotConfig(
      final KonamiHyperShotConfig konamiHyperShotConfig) {
    super(konamiHyperShotConfig);
  } 
  
  @Override
  public KonamiHyperShotConfig copy() {
    return new KonamiHyperShotConfig(this);
  }
}
