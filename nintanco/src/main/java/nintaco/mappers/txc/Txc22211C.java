package nintaco.mappers.txc;

import nintaco.files.*;

public class Txc22211C extends Txc22211A {
  
  private static final long serialVersionUID = 0;
  
  public Txc22211C(final CartFile cartFile) {
    super(cartFile);
  }
  
  @Override
  protected int readRegister() {    
    return (regs[1] ^ regs[2]) | 0x41;
  }
}
