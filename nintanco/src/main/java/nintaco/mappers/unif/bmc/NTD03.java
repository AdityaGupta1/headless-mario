package nintaco.mappers.unif.bmc;

import nintaco.files.*;
import nintaco.mappers.*;
import static nintaco.util.BitUtil.*;

public class NTD03 extends Mapper {
  
  private static final long serialVersionUID = 0;

  public NTD03(final CartFile cartFile) {
    super(cartFile, 4, 1);
  }

  @Override
  public void init() {
    writeRegister(0x8000, 0);
  }
  
  @Override
  public void resetting() {
    init();
  }

  @Override
	public void writeRegister(final int address, final int value) {
		final int bank = (address >> 10) & 0x1E;
		if (getBitBool(address, 7)) {
			setPrgBank(2, bank | ((address >> 6) & 1));
			setPrgBank(3, bank | ((address >> 6) & 1));
		} else {
      setPrgBanks(2, 2, bank & 0xFE);			
		}
    setChrBank(((address & 0x0300) >> 5) | (address & 0x07));		
    setNametableMirroring(getBit(address, 10));
	}  
}