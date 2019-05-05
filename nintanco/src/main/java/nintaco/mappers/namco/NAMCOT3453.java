package nintaco.mappers.namco;

import nintaco.files.*;
import static nintaco.util.BitUtil.*;
import static nintaco.mappers.NametableMirroring.*;

public class NAMCOT3453 extends Mapper088 {
  
  private static final long serialVersionUID = 0;

  public NAMCOT3453(final CartFile cartFile) {
    super(cartFile);
  }

  @Override
  protected void writeRegister(final int address, final int value) {
    super.writeRegister(address, value);
    setNametableMirroring(getBitBool(value, 6) ? ONE_SCREEN_A : ONE_SCREEN_B);
  }
}
