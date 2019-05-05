package nintaco.input.none;

import java.io.*;
import nintaco.input.*;
import static nintaco.input.InputDevices.*;

public class NoneMapper extends DeviceMapper implements Serializable {
  
  private static final long serialVersionUID = 0;

  @Override
  public int getInputDevice() {
    return None;
  }

  @Override
  public void update(final int buttons) {
  }

  @Override
  public void writePort(final int value) {
  }

  @Override
  public int readPort(final int portIndex) {
    return 0;
  }

  @Override
  public int peekPort(final int portIndex) {
    return 0;
  }  
}
