package nintaco.input.miraclepiano;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class MiraclePianoConfig extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public MiraclePianoConfig() {
    super(MiraclePiano);
  }
  
  public MiraclePianoConfig(final List<ButtonMapping> buttonMappings) {
    super(MiraclePiano, buttonMappings);
  }
  
  public MiraclePianoConfig(final MiraclePianoConfig miraclePianoConfig) {
    super(miraclePianoConfig);
  }
  
  @Override
  public MiraclePianoConfig copy() {
    return new MiraclePianoConfig(this);
  }  
}