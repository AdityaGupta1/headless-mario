package nintaco.input.other;

import java.util.*;
import nintaco.*;
import nintaco.input.*;

public class Glitch implements OtherInput {
  
  private static final long serialVersionUID = 0;

  private final int vramMask;
  
  public Glitch() {
    int mask = 0x3FFF;
    final Random random = new Random();
    mask &= ~(0x100 << random.nextInt(6));
    if (random.nextInt(7) == 3) {
      mask &= ~(0x100 << random.nextInt(6));
    }
    if (random.nextInt(5) == 3) {
      mask &= ~(0x10 << random.nextInt(4));
    }
    vramMask = mask;
  }
  
  @Override
  public void run(final Machine machine) {
    machine.getMapper().setVramMask(vramMask);
  }  
}