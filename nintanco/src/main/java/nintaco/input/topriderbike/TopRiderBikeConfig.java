package nintaco.input.topriderbike;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class TopRiderBikeConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public TopRiderBikeConfig() {
    super(TopRiderBike);
  }
  
  public TopRiderBikeConfig(final List<ButtonMapping> buttonMappings) {
    super(TopRiderBike, buttonMappings);
  }
  
  public TopRiderBikeConfig(final TopRiderBikeConfig topRiderBikeConfig) {
    super(topRiderBikeConfig);
  }
  
  @Override
  public TopRiderBikeConfig copy() {
    return new TopRiderBikeConfig(this);
  }
}
