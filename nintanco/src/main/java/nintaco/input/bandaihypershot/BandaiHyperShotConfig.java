package nintaco.input.bandaihypershot;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class BandaiHyperShotConfig 
    extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public BandaiHyperShotConfig() {
    super(BandaiHyperShot);
  }
  
  public BandaiHyperShotConfig(final List<ButtonMapping> buttonMappings) {
    super(BandaiHyperShot, buttonMappings);
  }
  
  public BandaiHyperShotConfig(
      final BandaiHyperShotConfig bandaiHyperShotConfig) {
    super(bandaiHyperShotConfig);
  }
  
  @Override
  public BandaiHyperShotConfig copy() {
    return new BandaiHyperShotConfig(this);
  }
}
