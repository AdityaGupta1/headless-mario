package nintaco.input.zapper;

import net.java.games.input.*;
import nintaco.input.*;
import static net.java.games.input.Component.Identifier.Button.*;

public class ZapperDescriptor extends DeviceDescriptor {

  public static final int Trigger = 0;
  
  public static final int RewindTime = 1;
  
  private static final Component.Identifier.Button[] DEFAULTS = { LEFT, RIGHT }; 
  
  public ZapperDescriptor() {
    super(InputDevices.Zapper);
  }
  
  @Override
  public String getDeviceName() {
    return "Zapper"; 
  }
  
  @Override
  public int getButtonCount() {
    return 2;
  }  
  
  @Override
  public int getRewindTimeButton() {
    return RewindTime;
  }  

  @Override
  public String getButtonName(int buttonIndex) {
    switch(buttonIndex) {
      case Trigger:
        return "Trigger";
      case RewindTime:
        return "Rewind Time";
      default:
        return "Unknown";
    }
  }

  @Override
  public ButtonMapping getDefaultButtonMapping(final int buttonIndex) {
    return getDefaultButtonMapping(InputUtil.getDefaultMouse(), buttonIndex, 
        DEFAULTS);
  }  
  
  @Override
  public int setButtonBits(final int bits, final int consoleType,
      final int portIndex, final int[] pressedValues) {
    
    updateRewindTime(pressedValues[RewindTime] != 0, portIndex);
    
    final int mouseCoordinates = InputUtil.getMouseCoordinates();
    
    int buttons = 0;    
    if (mouseCoordinates != 0xFFFF && pressedValues[Trigger] != 0) {
      buttons |= 0x04;
    }
    
    return bits 
        | (mouseCoordinates << 16) 
        | (portIndex == 0 ? buttons : (buttons << 8));
  }
}
