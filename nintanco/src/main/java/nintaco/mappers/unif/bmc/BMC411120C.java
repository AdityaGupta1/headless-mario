package nintaco.mappers.unif.bmc;

import nintaco.files.*;
import nintaco.mappers.nintendo.*;

public class BMC411120C extends MMC3 {
  
  private static final long serialVersionUID = 0;
  
  private int resetFlag;
  private int reg;
  
  public BMC411120C(final CartFile cartFile) {
    super(cartFile);
  }

  @Override
  public void resetting() {
    reg = 0;
    resetFlag ^= 4;
    super.init();
  }

  @Override
  public void writeMemory(final int address, final int value) {
    if ((address & 0xE000) == 0x6000) {
      reg = address;
      updateBanks();
    } else {
      super.writeMemory(address, value);
    }    
  }
  
  @Override
  public void setChrBank(final int bank, final int value) {
    super.setChrBank(bank, ((reg & 3) << 7) | (value & 0x7F));
  }

  @Override
  public void setPrgBank(final int bank, final int value) {
    if ((reg & (8 | resetFlag)) != 0) {    
      final int b = (0x0C | ((reg >> 4) & 3)) << 2;      
      super.setPrgBank(4, b);
      super.setPrgBank(5, b | 1);
      super.setPrgBank(6, b | 2);
      super.setPrgBank(7, b | 3);
    } else {
      super.setPrgBank(bank, ((reg & 3) << 4) | (value & 0x0F));
    }
  }  
}