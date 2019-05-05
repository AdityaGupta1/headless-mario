package nintaco.mappers.unif.unl;

import nintaco.files.*;
import nintaco.mappers.*;

public class SMB2J extends Mapper {
  
  private static final long serialVersionUID = 0;

  private final boolean reg4022;
  
	private int irqCounter;
	private boolean irqEnabled;
  
  public SMB2J(final CartFile cartFile) {
    super(cartFile, 16, 1, 0x8000, 0x5000);
    reg4022 = cartFile.getPrgRomLength() >= 0x10000;
  }
  
  @Override
  public void init() {
    setPrgBanks(5, 11, -3);
    setChrBank(0);
    irqCounter = 0;
    irqEnabled = false;
  }

  @Override
  public void update() {
    if (irqEnabled) {
      irqCounter = (irqCounter + 1) & 0x0FFF;
      if (irqCounter == 0) {
        irqEnabled = false;
        cpu.setMapperIrq(true);
      }
    }
  }
  
  @Override
  public void writeMemory(final int address, final int value) {
    memory[address] = value;
    if (address == 0x4022 && reg4022) {
      setPrgBanks(8, 8, (value & 1) << 3);
    } else if (address == 0x4122) {
      irqEnabled = (value & 3) != 0;
      irqCounter = 0;
      cpu.setMapperIrq(false);
    }
  }  
}