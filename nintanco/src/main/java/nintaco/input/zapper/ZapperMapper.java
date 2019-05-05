package nintaco.input.zapper;

import java.io.*;
import nintaco.*;
import nintaco.input.*;
import nintaco.input.icons.*;
import nintaco.mappers.*;
import nintaco.tv.*;
import static nintaco.input.InputDevices.*;

public class ZapperMapper extends DeviceMapper implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  protected static final int PHOTO_SENSOR_SCANLINES = 26;
  
  protected final int shift;  
  protected final int portIndex;
  
  protected Mapper mapper;
  protected TVSystem tvSystem;
  protected int triggerScanlines;
  
  protected boolean triggerPulled;
  protected boolean triggerReleased = true;
  protected int coordinates;
  protected int photoSensor;
  protected int trigger;  
  protected int portValue;
  protected boolean expansionPort;
  
  public ZapperMapper(final int portIndex) {
    if (portIndex == Ports.ExpansionPort) {
      expansionPort = true;
    }
    if (portIndex == 0) {
      this.shift = 0;
      this.portIndex = 0;
    } else {
      this.shift = 8;
      this.portIndex = 1;
    }
  }
  
  @Override
  public void setMachine(final Machine machine) {
    mapper = machine.getMapper();
    machine.getPPU().setZapper(this);    
  }
  
  @Override
  public int getInputDevice() {
    return Zapper;
  }

  public int getShift() {
    return shift;
  }
  
  public void handleLightDetected() {
    photoSensor = PHOTO_SENSOR_SCANLINES;
    updatePortValue();
  }
  
  public void handleScanline() {
    if (photoSensor > 0) {
      photoSensor--;
    }    
    if (trigger > 0) {
      trigger--;
    }
    updatePortValue();
  }
  
  protected void updatePortValue() {
    portValue = 0;
    if (trigger != 0) {
      portValue |= 0x10;
    }
    if (photoSensor == 0) {
      portValue |= 0x08;
    }     
  }
  
  @Override
  public void update(final int buttons) {
    triggerPulled = ((buttons >> shift) & 0x04) != 0;
    if (triggerPulled) {
      if (triggerReleased) {
        triggerReleased = false;
        final TVSystem system = mapper.getTVSystem();
        if (tvSystem != system) {
          tvSystem = system;
          triggerScanlines = (int)Math.round(system.getScanlineCount() 
              / (10.0 * system.getSecondsPerFrame()));
        }
        trigger = triggerScanlines;
      }
    } else {
      triggerReleased = true;
    }
    coordinates = (buttons >> 16) & 0xFFFF;    
    updatePortValue();
  }

  public boolean isTrigger() {
    return trigger > 0;
  }

  public int getCoordinates() {
    return coordinates;
  }

  @Override
  public void writePort(final int value) {
  }

  @Override
  public int readPort(final int portIndex) {
    return this.portIndex == portIndex ? portValue : 0;
  }

  @Override
  public int peekPort(final int portIndex) {
    return readPort(portIndex);
  }  

  @Override
  public void render(final int[] screen) {
    final int x = expansionPort ? 169 : 8 + (portIndex << 6);
    final int y = 205;
    InputIcons.Zapper.render(screen, x, y);
    if (triggerPulled) {
      InputIcons.ZapperTrigger.render(screen, x + 14, y + 8);
    }
    final int X = coordinates & 0xFF;
    final int Y = (coordinates >> 8) & 0xFF;
    if (Y < 240) {
      InputIcons.ZapperTarget.renderSafe(screen, X - 7, Y - 7);
    }
  }
}