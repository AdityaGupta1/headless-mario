package nintaco.mappers.bitcorp;

import nintaco.files.NesFile;
import nintaco.*;
import nintaco.mappers.nintendo.*;

public class CrimeBusters extends GxROM {
  
  private static final long serialVersionUID = 0;

  public CrimeBusters(NesFile nesFile) {
    super(nesFile);
  }
  
  @Override
  public void writeMemory(int address, int value) {
    if ((address & 0x7000) == 0x7000) {
      prgBanks[1] = (value & 0x03) << 15;
      chrBanks[0] = (value & 0xFC) << 11;
    } else {
      memory[address] = value;
    }
  }
}
