package nintaco.mappers.txc;

import nintaco.files.*;
import nintaco.mappers.*;
import static nintaco.util.BitUtil.*;

public class Txc22000 extends Mapper {
  
  private static final long serialVersionUID = 0;

	private int RR;	
	private int PP;
  private boolean M;  
  
  public Txc22000(final CartFile cartFile) {
    super(cartFile, 2, 1);
  }

  @Override
  public void init() {
    super.init();
    RR = PP = 0;
    M = false;
    setPrgBank(0);
    setChrBank(0);
  }

  @Override
  public int readMemory(final int address) {
    if (address < 0x8000 && (address & 0xE100) == 0x4100) {
      return ((address >> 8) & 0xCF) | (RR << 4);
    } else {
      return super.readMemory(address);
    }
  }
  
  
  @Override
  public void writeMemory(final int address, final int value) {
    memory[address] = value;
    if (address < 0x8000) {
      switch(address & 0xE303) {
        case 0x4100:
          if (M) {
            RR++;
          } else {
            RR = PP;
          }
          break;
        case 0x4102:
          PP = (value >> 4) & 0x03;
          break;
        case 0x4103:
          M = getBitBool(value, 4);
          break;

        case 0x4200:
        case 0x4201:
        case 0x4202:
        case 0x4203:
          setChrBank(value & 0x0F);
          break;
      }
    } else {
      setPrgBank(RR);
    }
  }
}
