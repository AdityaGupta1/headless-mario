// THIS IS AN AUTOGENERATED FILE. DO NOT MODIFY.

package nintaco.api.remote;

public class RemoteAPI extends RemoteBase {

  public RemoteAPI(final String host, final int port) {
    super(host, port);
  }

  @Override
  public void setPaused(final boolean paused) {
    try {
      stream.writeByte(23);
      stream.writeBoolean(paused);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public boolean isPaused() {
    try {
      stream.writeByte(24);
      stream.flush();
      return stream.readBoolean();
    } catch(final Throwable e) {
    }
    return false;
  }

  @Override
  public int getFrameCount() {
    try {
      stream.writeByte(25);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public int getA() {
    try {
      stream.writeByte(26);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void setA(final int A) {
    try {
      stream.writeByte(27);
      stream.writeInt(A);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getS() {
    try {
      stream.writeByte(28);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void setS(final int S) {
    try {
      stream.writeByte(29);
      stream.writeInt(S);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getPC() {
    try {
      stream.writeByte(30);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void setPC(final int PC) {
    try {
      stream.writeByte(31);
      stream.writeInt(PC);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getX() {
    try {
      stream.writeByte(32);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void setX(final int X) {
    try {
      stream.writeByte(33);
      stream.writeInt(X);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getY() {
    try {
      stream.writeByte(34);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void setY(final int Y) {
    try {
      stream.writeByte(35);
      stream.writeInt(Y);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getP() {
    try {
      stream.writeByte(36);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void setP(final int P) {
    try {
      stream.writeByte(37);
      stream.writeInt(P);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public boolean isN() {
    try {
      stream.writeByte(38);
      stream.flush();
      return stream.readBoolean();
    } catch(final Throwable e) {
    }
    return false;
  }

  @Override
  public void setN(final boolean N) {
    try {
      stream.writeByte(39);
      stream.writeBoolean(N);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public boolean isV() {
    try {
      stream.writeByte(40);
      stream.flush();
      return stream.readBoolean();
    } catch(final Throwable e) {
    }
    return false;
  }

  @Override
  public void setV(final boolean V) {
    try {
      stream.writeByte(41);
      stream.writeBoolean(V);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public boolean isD() {
    try {
      stream.writeByte(42);
      stream.flush();
      return stream.readBoolean();
    } catch(final Throwable e) {
    }
    return false;
  }

  @Override
  public void setD(final boolean D) {
    try {
      stream.writeByte(43);
      stream.writeBoolean(D);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public boolean isI() {
    try {
      stream.writeByte(44);
      stream.flush();
      return stream.readBoolean();
    } catch(final Throwable e) {
    }
    return false;
  }

  @Override
  public void setI(final boolean I) {
    try {
      stream.writeByte(45);
      stream.writeBoolean(I);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public boolean isZ() {
    try {
      stream.writeByte(46);
      stream.flush();
      return stream.readBoolean();
    } catch(final Throwable e) {
    }
    return false;
  }

  @Override
  public void setZ(final boolean Z) {
    try {
      stream.writeByte(47);
      stream.writeBoolean(Z);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public boolean isC() {
    try {
      stream.writeByte(48);
      stream.flush();
      return stream.readBoolean();
    } catch(final Throwable e) {
    }
    return false;
  }

  @Override
  public void setC(final boolean C) {
    try {
      stream.writeByte(49);
      stream.writeBoolean(C);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getPPUv() {
    try {
      stream.writeByte(50);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void setPPUv(final int v) {
    try {
      stream.writeByte(51);
      stream.writeInt(v);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getPPUt() {
    try {
      stream.writeByte(52);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void setPPUt(final int t) {
    try {
      stream.writeByte(53);
      stream.writeInt(t);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getPPUx() {
    try {
      stream.writeByte(54);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void setPPUx(final int x) {
    try {
      stream.writeByte(55);
      stream.writeInt(x);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public boolean isPPUw() {
    try {
      stream.writeByte(56);
      stream.flush();
      return stream.readBoolean();
    } catch(final Throwable e) {
    }
    return false;
  }

  @Override
  public void setPPUw(final boolean w) {
    try {
      stream.writeByte(57);
      stream.writeBoolean(w);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getCameraX() {
    try {
      stream.writeByte(58);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void setCameraX(final int scrollX) {
    try {
      stream.writeByte(59);
      stream.writeInt(scrollX);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getCameraY() {
    try {
      stream.writeByte(60);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void setCameraY(final int scrollY) {
    try {
      stream.writeByte(61);
      stream.writeInt(scrollY);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getScanline() {
    try {
      stream.writeByte(62);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public int getDot() {
    try {
      stream.writeByte(63);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public boolean isSpriteZeroHit() {
    try {
      stream.writeByte(64);
      stream.flush();
      return stream.readBoolean();
    } catch(final Throwable e) {
    }
    return false;
  }

  @Override
  public void setSpriteZeroHit(final boolean sprite0Hit) {
    try {
      stream.writeByte(65);
      stream.writeBoolean(sprite0Hit);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getScanlineCount() {
    try {
      stream.writeByte(66);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void requestInterrupt() {
    try {
      stream.writeByte(67);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void acknowledgeInterrupt() {
    try {
      stream.writeByte(68);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int peekCPU(final int address) {
    try {
      stream.writeByte(69);
      stream.writeInt(address);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public int readCPU(final int address) {
    try {
      stream.writeByte(70);
      stream.writeInt(address);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void writeCPU(final int address, final int value) {
    try {
      stream.writeByte(71);
      stream.writeInt(address);
      stream.writeInt(value);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int peekCPU16(final int address) {
    try {
      stream.writeByte(72);
      stream.writeInt(address);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public int readCPU16(final int address) {
    try {
      stream.writeByte(73);
      stream.writeInt(address);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void writeCPU16(final int address, final int value) {
    try {
      stream.writeByte(74);
      stream.writeInt(address);
      stream.writeInt(value);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int peekCPU32(final int address) {
    try {
      stream.writeByte(75);
      stream.writeInt(address);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public int readCPU32(final int address) {
    try {
      stream.writeByte(76);
      stream.writeInt(address);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void writeCPU32(final int address, final int value) {
    try {
      stream.writeByte(77);
      stream.writeInt(address);
      stream.writeInt(value);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int readPPU(final int address) {
    try {
      stream.writeByte(78);
      stream.writeInt(address);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void writePPU(final int address, final int value) {
    try {
      stream.writeByte(79);
      stream.writeInt(address);
      stream.writeInt(value);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int readPaletteRAM(final int address) {
    try {
      stream.writeByte(80);
      stream.writeInt(address);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void writePaletteRAM(final int address, final int value) {
    try {
      stream.writeByte(81);
      stream.writeInt(address);
      stream.writeInt(value);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int readOAM(final int address) {
    try {
      stream.writeByte(82);
      stream.writeInt(address);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void writeOAM(final int address, final int value) {
    try {
      stream.writeByte(83);
      stream.writeInt(address);
      stream.writeInt(value);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public boolean readGamepad(final int gamepad, final int button) {
    try {
      stream.writeByte(84);
      stream.writeInt(gamepad);
      stream.writeInt(button);
      stream.flush();
      return stream.readBoolean();
    } catch(final Throwable e) {
    }
    return false;
  }

  @Override
  public void writeGamepad(final int gamepad, final int button, 
      final boolean value) {
    try {
      stream.writeByte(85);
      stream.writeInt(gamepad);
      stream.writeInt(button);
      stream.writeBoolean(value);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public boolean isZapperTrigger() {
    try {
      stream.writeByte(86);
      stream.flush();
      return stream.readBoolean();
    } catch(final Throwable e) {
    }
    return false;
  }

  @Override
  public void setZapperTrigger(final boolean zapperTrigger) {
    try {
      stream.writeByte(87);
      stream.writeBoolean(zapperTrigger);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getZapperX() {
    try {
      stream.writeByte(88);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void setZapperX(final int x) {
    try {
      stream.writeByte(89);
      stream.writeInt(x);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getZapperY() {
    try {
      stream.writeByte(90);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void setZapperY(final int y) {
    try {
      stream.writeByte(91);
      stream.writeInt(y);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void setColor(final int color) {
    try {
      stream.writeByte(92);
      stream.writeInt(color);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getColor() {
    try {
      stream.writeByte(93);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void setClip(final int x, final int y, final int width, 
      final int height) {
    try {
      stream.writeByte(94);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.writeInt(width);
      stream.writeInt(height);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void clipRect(final int x, final int y, final int width, 
      final int height) {
    try {
      stream.writeByte(95);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.writeInt(width);
      stream.writeInt(height);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void resetClip() {
    try {
      stream.writeByte(96);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void copyArea(final int x, final int y, final int width, 
      final int height, final int dx, final int dy) {
    try {
      stream.writeByte(97);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.writeInt(width);
      stream.writeInt(height);
      stream.writeInt(dx);
      stream.writeInt(dy);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void drawLine(final int x1, final int y1, final int x2, final int y2) {
    try {
      stream.writeByte(98);
      stream.writeInt(x1);
      stream.writeInt(y1);
      stream.writeInt(x2);
      stream.writeInt(y2);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void drawOval(final int x, final int y, final int width, 
      final int height) {
    try {
      stream.writeByte(99);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.writeInt(width);
      stream.writeInt(height);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void drawPolygon(final int[] xPoints, final int[] yPoints, 
      final int nPoints) {
    try {
      stream.writeByte(100);
      stream.writeIntArray(xPoints);
      stream.writeIntArray(yPoints);
      stream.writeInt(nPoints);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void drawPolyline(final int[] xPoints, final int[] yPoints, 
      final int nPoints) {
    try {
      stream.writeByte(101);
      stream.writeIntArray(xPoints);
      stream.writeIntArray(yPoints);
      stream.writeInt(nPoints);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void drawRect(final int x, final int y, final int width, 
      final int height) {
    try {
      stream.writeByte(102);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.writeInt(width);
      stream.writeInt(height);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void drawRoundRect(final int x, final int y, final int width, 
      final int height, final int arcWidth, final int arcHeight) {
    try {
      stream.writeByte(103);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.writeInt(width);
      stream.writeInt(height);
      stream.writeInt(arcWidth);
      stream.writeInt(arcHeight);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void draw3DRect(final int x, final int y, final int width, 
      final int height, final boolean raised) {
    try {
      stream.writeByte(104);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.writeInt(width);
      stream.writeInt(height);
      stream.writeBoolean(raised);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void drawArc(final int x, final int y, final int width, 
      final int height, final int startAngle, final int arcAngle) {
    try {
      stream.writeByte(105);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.writeInt(width);
      stream.writeInt(height);
      stream.writeInt(startAngle);
      stream.writeInt(arcAngle);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void fill3DRect(final int x, final int y, final int width, 
      final int height, final boolean raised) {
    try {
      stream.writeByte(106);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.writeInt(width);
      stream.writeInt(height);
      stream.writeBoolean(raised);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void fillArc(final int x, final int y, final int width, 
      final int height, final int startAngle, final int arcAngle) {
    try {
      stream.writeByte(107);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.writeInt(width);
      stream.writeInt(height);
      stream.writeInt(startAngle);
      stream.writeInt(arcAngle);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void fillOval(final int x, final int y, final int width, 
      final int height) {
    try {
      stream.writeByte(108);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.writeInt(width);
      stream.writeInt(height);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void fillPolygon(final int[] xPoints, final int[] yPoints, 
      final int nPoints) {
    try {
      stream.writeByte(109);
      stream.writeIntArray(xPoints);
      stream.writeIntArray(yPoints);
      stream.writeInt(nPoints);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void fillRect(final int x, final int y, final int width, 
      final int height) {
    try {
      stream.writeByte(110);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.writeInt(width);
      stream.writeInt(height);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void fillRoundRect(final int x, final int y, final int width, 
      final int height, final int arcWidth, final int arcHeight) {
    try {
      stream.writeByte(111);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.writeInt(width);
      stream.writeInt(height);
      stream.writeInt(arcWidth);
      stream.writeInt(arcHeight);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void drawChar(final char c, final int x, final int y) {
    try {
      stream.writeByte(112);
      stream.writeChar(c);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void drawChars(final char[] data, final int offset, final int length, 
      final int x, final int y, final boolean monospaced) {
    try {
      stream.writeByte(113);
      stream.writeCharArray(data);
      stream.writeInt(offset);
      stream.writeInt(length);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.writeBoolean(monospaced);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void drawString(final String str, final int x, final int y, 
      final boolean monospaced) {
    try {
      stream.writeByte(114);
      stream.writeString(str);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.writeBoolean(monospaced);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void createSprite(final int id, final int width, final int height, 
      final int[] pixels) {
    try {
      stream.writeByte(115);
      stream.writeInt(id);
      stream.writeInt(width);
      stream.writeInt(height);
      stream.writeIntArray(pixels);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void drawSprite(final int id, final int x, final int y) {
    try {
      stream.writeByte(116);
      stream.writeInt(id);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void setPixel(final int x, final int y, final int color) {
    try {
      stream.writeByte(117);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.writeInt(color);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getPixel(final int x, final int y) {
    try {
      stream.writeByte(118);
      stream.writeInt(x);
      stream.writeInt(y);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void powerCycle() {
    try {
      stream.writeByte(120);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void reset() {
    try {
      stream.writeByte(121);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void deleteSprite(final int id) {
    try {
      stream.writeByte(122);
      stream.writeInt(id);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void setSpeed(final int percent) {
    try {
      stream.writeByte(123);
      stream.writeInt(percent);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void stepToNextFrame() {
    try {
      stream.writeByte(124);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void showMessage(final String message) {
    try {
      stream.writeByte(125);
      stream.writeString(message);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public String getWorkingDirectory() {
    try {
      stream.writeByte(126);
      stream.flush();
      return stream.readString();
    } catch(final Throwable e) {
    }
    return null;
  }

  @Override
  public String getContentDirectory() {
    try {
      stream.writeByte(127);
      stream.flush();
      return stream.readString();
    } catch(final Throwable e) {
    }
    return null;
  }

  @Override
  public void open(final String fileName) {
    try {
      stream.writeByte(128);
      stream.writeString(fileName);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void openArchiveEntry(final String archiveFileName, 
      final String entryFileName) {
    try {
      stream.writeByte(129);
      stream.writeString(archiveFileName);
      stream.writeString(entryFileName);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public String[] getArchiveEntries(final String archiveFileName) {
    try {
      stream.writeByte(130);
      stream.writeString(archiveFileName);
      stream.flush();
      return stream.readDynamicStringArray();
    } catch(final Throwable e) {
    }
    return null;
  }

  @Override
  public String getDefaultArchiveEntry(final String archiveFileName) {
    try {
      stream.writeByte(131);
      stream.writeString(archiveFileName);
      stream.flush();
      return stream.readString();
    } catch(final Throwable e) {
    }
    return null;
  }

  @Override
  public void openDefaultArchiveEntry(final String archiveFileName) {
    try {
      stream.writeByte(132);
      stream.writeString(archiveFileName);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void close() {
    try {
      stream.writeByte(133);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void saveState(final String stateFileName) {
    try {
      stream.writeByte(134);
      stream.writeString(stateFileName);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void loadState(final String stateFileName) {
    try {
      stream.writeByte(135);
      stream.writeString(stateFileName);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void quickSaveState(final int slot) {
    try {
      stream.writeByte(136);
      stream.writeInt(slot);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void quickLoadState(final int slot) {
    try {
      stream.writeByte(137);
      stream.writeInt(slot);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void setTVSystem(final String tvSystem) {
    try {
      stream.writeByte(138);
      stream.writeString(tvSystem);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public String getTVSystem() {
    try {
      stream.writeByte(139);
      stream.flush();
      return stream.readString();
    } catch(final Throwable e) {
    }
    return null;
  }

  @Override
  public int getDiskSides() {
    try {
      stream.writeByte(140);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void insertDisk(final int disk, final int side) {
    try {
      stream.writeByte(141);
      stream.writeInt(disk);
      stream.writeInt(side);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void flipDiskSide() {
    try {
      stream.writeByte(142);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void ejectDisk() {
    try {
      stream.writeByte(143);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void insertCoin() {
    try {
      stream.writeByte(144);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void pressServiceButton() {
    try {
      stream.writeByte(145);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void screamIntoMicrophone() {
    try {
      stream.writeByte(146);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void glitch() {
    try {
      stream.writeByte(147);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public String getFileInfo() {
    try {
      stream.writeByte(148);
      stream.flush();
      return stream.readString();
    } catch(final Throwable e) {
    }
    return null;
  }

  @Override
  public void setFullscreenMode(final boolean fullscreenMode) {
    try {
      stream.writeByte(149);
      stream.writeBoolean(fullscreenMode);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void saveScreenshot() {
    try {
      stream.writeByte(150);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void addCheat(final int address, final int value, final int compare, 
      final String description, final boolean enabled) {
    try {
      stream.writeByte(151);
      stream.writeInt(address);
      stream.writeInt(value);
      stream.writeInt(compare);
      stream.writeString(description);
      stream.writeBoolean(enabled);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void removeCheat(final int address, final int value, 
      final int compare) {
    try {
      stream.writeByte(152);
      stream.writeInt(address);
      stream.writeInt(value);
      stream.writeInt(compare);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void addGameGenie(final String gameGenieCode, final String description, 
      final boolean enabled) {
    try {
      stream.writeByte(153);
      stream.writeString(gameGenieCode);
      stream.writeString(description);
      stream.writeBoolean(enabled);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void removeGameGenie(final String gameGenieCode) {
    try {
      stream.writeByte(154);
      stream.writeString(gameGenieCode);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void addProActionRocky(final String proActionRockyCode, 
      final String description, final boolean enabled) {
    try {
      stream.writeByte(155);
      stream.writeString(proActionRockyCode);
      stream.writeString(description);
      stream.writeBoolean(enabled);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public void removeProActionRocky(final String proActionRockyCode) {
    try {
      stream.writeByte(156);
      stream.writeString(proActionRockyCode);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getPrgRomSize() {
    try {
      stream.writeByte(157);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public int readPrgRom(final int index) {
    try {
      stream.writeByte(158);
      stream.writeInt(index);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void writePrgRom(final int index, final int value) {
    try {
      stream.writeByte(159);
      stream.writeInt(index);
      stream.writeInt(value);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getChrRomSize() {
    try {
      stream.writeByte(160);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public int readChrRom(final int index) {
    try {
      stream.writeByte(161);
      stream.writeInt(index);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public void writeChrRom(final int index, final int value) {
    try {
      stream.writeByte(162);
      stream.writeInt(index);
      stream.writeInt(value);
      stream.flush();
    } catch(final Throwable e) {
    }
  }

  @Override
  public int getStringWidth(final String str, final boolean monospaced) {
    try {
      stream.writeByte(163);
      stream.writeString(str);
      stream.writeBoolean(monospaced);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }

  @Override
  public int getCharsWidth(final char[] chars, final boolean monospaced) {
    try {
      stream.writeByte(164);
      stream.writeCharArray(chars);
      stream.writeBoolean(monospaced);
      stream.flush();
      return stream.readInt();
    } catch(final Throwable e) {
    }
    return -1;
  }
}