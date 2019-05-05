package nintaco.mappers.unif.unl;

import nintaco.files.*;
import nintaco.mappers.*;
import static nintaco.mappers.NametableMirroring.*;
import static nintaco.util.BitUtil.*;

// TODO LEFT INCOMPLETE UNTIL MORE INFORMATION IS AVAILABLE

public class PEC586 extends Mapper {
  
  private static final long serialVersionUID = 0;
  
  private static final int[] bsTable = { 
    0x03, 0x13, 0x23, 0x33, 0x03, 0x13, 0x23, 0x33, 
    0x03, 0x13, 0x23, 0x33, 0x03, 0x13, 0x23, 0x33, // $00
    0x45, 0x67, 0x45, 0x67, 0x45, 0x67, 0x45, 0x67, 
    0x45, 0x67, 0x45, 0x67, 0x45, 0x67, 0x45, 0x67, // $10
    0x03, 0x13, 0x23, 0x33, 0x03, 0x13, 0x23, 0x33, 
    0x03, 0x13, 0x23, 0x33, 0x03, 0x13, 0x23, 0x33, // $20
    0x47, 0x67, 0x47, 0x67, 0x47, 0x67, 0x47, 0x67, 
    0x47, 0x67, 0x47, 0x67, 0x47, 0x67, 0x47, 0x67, // $30
    0x02, 0x12, 0x22, 0x32, 0x02, 0x12, 0x22, 0x32, 
    0x02, 0x12, 0x22, 0x32, 0x02, 0x12, 0x22, 0x32, // $40
    0x45, 0x67, 0x45, 0x67, 0x45, 0x67, 0x45, 0x67, 
    0x45, 0x67, 0x45, 0x67, 0x45, 0x67, 0x45, 0x67, // $50
    0x02, 0x12, 0x22, 0x32, 0x02, 0x12, 0x22, 0x32, 
    0x02, 0x12, 0x22, 0x32, 0x00, 0x10, 0x20, 0x30, // $60
    0x47, 0x67, 0x47, 0x67, 0x47, 0x67, 0x47, 0x67, 
    0x47, 0x67, 0x47, 0x67, 0x47, 0x67, 0x47, 0x67, // $70 
  };
  
  private static final int[] brTable = {
    0x00, 0x09, 0x00, 0x00, 0x00, 0x00, 0x00, 0x20, 
    0x04, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 
  };
  
  private final int[] regs = new int[8];
  private final boolean is512KPrgROM;
  
  public PEC586(final CartFile cartFile) {
    super(cartFile, 8, 0);
    is512KPrgROM = prgRomLength == 0x80000;
  }
  
  @Override
  public void init() {
    regs[0] = is512KPrgROM ? 0x00 : 0x0E;
    updateBanks();
  }

  @Override
  public int readMemory(final int address) {
    if ((address & 0xF000) == 0x5000) {
      return brTable[regs[4] >> 4];
    } else if (is512KPrgROM && address >= 0x8000) {
      if (getBitBool(regs[0], 4) 
          || (getBitBool(regs[0], 6) && address < 0xA000)) {
		    return super.readMemory(address);
      } else {
		    return prgROM[(((0x0107 | ((address >> 7) & 0x0F8)) << 10) 
            | (address & 0x03FF)) & prgRomSizeMask];
      }
    } else {
      return super.readMemory(address);
    }
  }

  @Override
  public void writeMemory(final int address, final int value) {
    if ((address & 0xF000) == 0x5000) {
      regs[(address >> 8) & 7] = value;
    	updateBanks();
    } else {
      super.writeMemory(address, value);
    }
  }
  
  private void updateBanks() {
    if (is512KPrgROM) {
      if (getBitBool(regs[0], 4)) {
        final int bank = (regs[0] & 7) << 2;
        setPrgBank(4, bank);
        setPrgBank(5, bank | 1);
        setPrgBank(6, bank | 2);
        setPrgBank(7, bank | 3);        
      } else if (getBitBool(regs[0], 6)) {
        setPrgBank(4, 0x20 | ((regs[0] & 0x20) >> 1) | (regs[0] & 0x0F));
      }
      if ((regs[0] & 0x18) == 0x18) {
        setNametableMirroring(HORIZONTAL);
      } else {
        setNametableMirroring(VERTICAL);
      }
    } else {
      int bank = (bsTable[regs[0] & 0x7F] >> 4) << 1;
      setPrgBank(4, bank);
      setPrgBank(5, bank | 1);
      bank = (bsTable[regs[0] & 0x7F] & 0x0F) << 1;
      setPrgBank(6, bank);
      setPrgBank(7, bank | 1);
      setNametableMirroring(VERTICAL);
    }
  }
}