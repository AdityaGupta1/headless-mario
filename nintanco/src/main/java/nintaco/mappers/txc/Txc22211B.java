package nintaco.mappers.txc;

import nintaco.files.*;

public class Txc22211B extends Txc22211A {
  
  private static final long serialVersionUID = 0;
  
  public Txc22211B(final CartFile cartFile) {
    super(cartFile);
  }

  @Override
  protected void updateBanks(final int value) {
    setPrgBank(1, regs[2] >> 2);
		setChrBank(0, (((value ^ regs[2]) >> 3) & 0x02) | (((value ^ regs[2]) >> 5) 
        & 0x01));
  }  
}