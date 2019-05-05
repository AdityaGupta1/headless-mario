package nintaco.gui.debugger;

import java.io.*;
import java.util.*;
import nintaco.*;
import nintaco.disassembler.*;
import nintaco.preferences.*;

public class DebuggerGamePrefs implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  private List<AddressLabel> addressLabels;
  private List<Breakpoint> breakpoints;
  
  public List<Breakpoint> getBreakpoints() {
    synchronized(GamePrefs.class) {
      if (breakpoints == null) {
        breakpoints = new ArrayList<>();
      }
      return breakpoints;
    }
  }

  public void setBreakpoints(List<Breakpoint> breakpoints) {
    synchronized(GamePrefs.class) {
      this.breakpoints = breakpoints;
    }
  }  

  public List<AddressLabel> getAddressLabels() {
    synchronized(GamePrefs.class) {
      if (addressLabels == null) {
        addressLabels = new ArrayList<>();
      }
      return addressLabels;
    }
  }

  public void setAddressLabels(List<AddressLabel> addressLabels) {
    synchronized(GamePrefs.class) {
      this.addressLabels = addressLabels;
    }
  }
}
