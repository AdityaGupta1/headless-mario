package nintaco.input.familytrainermat;

import java.io.*;
import java.util.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class FamilyTrainerMatConfig 
    extends DeviceConfig implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public FamilyTrainerMatConfig() {
    super(FamilyTrainerMat);
  }
  
  public FamilyTrainerMatConfig(final List<ButtonMapping> buttonMappings) {
    super(FamilyTrainerMat, buttonMappings);
  }
  
  public FamilyTrainerMatConfig(
      final FamilyTrainerMatConfig familyTrainerMatConfig) {
    super(familyTrainerMatConfig);
  }
  
  @Override
  public FamilyTrainerMatConfig copy() {
    return new FamilyTrainerMatConfig(this);
  }
}