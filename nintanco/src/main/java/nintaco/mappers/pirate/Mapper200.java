package nintaco.mappers.pirate;

import nintaco.files.NesFile;
import nintaco.*;
import nintaco.mappers.*;
import static nintaco.util.BitUtil.*;

public class Mapper200 extends Mapper {
  
  private static final long serialVersionUID = 0;
  
  public Mapper200(NesFile nesFile) {
    super(nesFile, 4, 1);
  }
  
  @Override
  protected void writeRegister(int address, int value) {
    int bank = address & 7;
    setChrBank(0, bank);
    setPrgBank(2, bank);
    setPrgBank(3, bank);
    setNametableMirroring(getBit(value, 3));
  }
}
