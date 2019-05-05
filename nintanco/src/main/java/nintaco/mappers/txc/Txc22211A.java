package nintaco.mappers.txc;

import nintaco.files.*;
import nintaco.mappers.*;

public class Txc22211A extends Mapper {
  
  private static final long serialVersionUID = 0;
  
  protected final int[] regs = new int[4];
  
  public Txc22211A(final CartFile cartFile) {
    super(cartFile, 2, 1);
  }

  @Override
  public void init() {
    super.init();
    setPrgBank(1, 0);
    setChrBank(0, 0);
  }

  @Override
  public int readMemory(final int address) {
    if (address >= 0x4100 && address <= 0x4103) {
      return readRegister();
    } else {
      return super.readMemory(address);
    }
  }

  @Override
  public void writeMemory(final int address, final int value) {
    memory[address] = value;
    if (address >= 0x4100 && address <= 0x4103) {
      regs[address & 0x03] = value;
    } else if (address >= 0x8000) {
      updateBanks(value);
    }
  }
  
  protected int readRegister() {
    return (regs[1] ^ regs[2]) | 0x40;
  }
  
  protected void updateBanks(final int value) {
    setPrgBank(1, regs[2] >> 2);
    setChrBank(0, regs[2]);
  }
}