package nintaco.mappers.sachen;

import nintaco.files.*;
import nintaco.mappers.*;

public class Sachen136 extends Mapper {
  
  private static final long serialVersionUID = 0;
  
  private int chrReg;
  
  public Sachen136(final CartFile cartFile) {
    super(cartFile, 2, 1, 0x4100, 0x8000);
  }

  @Override
  public void init() {
    setPrgBank(0);
    setChrBank(0);
  }

  @Override
  public int readMemory(final int address) {
    if (address == 0x4100) {
      return chrReg & 0x3F;
    } else {
      return super.readMemory(address);
    }
  }

  @Override
  protected void writeRegister(final int address, final int value) {
    if ((address & 0x0103) == 0x0102) {
      chrReg = value + 3;
      setChrBank(chrReg & 3);
    }
  }  
}