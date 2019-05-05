package nintaco.gui.image.filters;

public final class LQ2x extends VideoFilter {
  
  public LQ2x() {
    super(2);
  }
  
  @Override
  public final void filter(final int[] in, final int yFirst, final int yLast) {
    scale(in, out, yFirst, yLast);
  }
  
  private static void scale(final int[] in, final int[] out, 
      final int yFirst, final int yLast) {
    
    for(int y = yLast - 1; y >= yFirst; y--) {
      final int ys = y << 8;      
      final int ym = y == 0 ? 0 : (y - 1) << 8;
      final int yp = y == 239 ? 61184 : (y + 1) << 8;
      final int Y0 = y << 10;
      final int Y1 = Y0 + 512;
      for(int x = 255; x >= 0; x--) {
        final int x2 = x << 1;
        final int y0 = Y0 | x2;
        final int y1 = Y1 | x2;
        final int xm = x == 0 ? 0 : x - 1;
        final int xp = x == 255 ? 255 : x + 1;
        final int a = in[ym | xm];
        final int b = in[ym | x];
        final int c = in[ym | xp];
        final int d = in[ys | xm];
        final int e = in[ys | x];
        final int f = in[ys | xp];
        final int g = in[yp | xm];
        final int h = in[yp | x];
        final int i = in[yp | xp];
        int v = a == e ? 1 : 0;
        if (b == e) {
          v |= 0x02;
        }
        if (c == e) {
          v |= 0x04;
        }
        if (d == e) {
          v |= 0x08;
        }
        if (f == e) {
          v |= 0x10;
        }
        if (g == e) {
          v |= 0x20;
        }
        if (h == e) {
          v |= 0x40;
        }
        if (i == e) {
          v |= 0x80;
        }
        switch(v) {
          case 173:
          case 172:
          case 141:
          case 33:
            out[y0] = e;
            out[y1] = e;
            if (b == f) {
              out[y0 | 1] = b;
            } else {
              out[y0 | 1] = e;
            }
            if (f == h) {
              out[y1 | 1] = h;
            } else {
              out[y1 | 1] = e;
            }
            break;
          case 175:
          case 174:
          case 171:
          case 170:
          case 168:
          case 143:
          case 142:
          case 139:
          case 138:
          case 137:
          case 134:
          case 131:
          case 46:
          case 45:
          case 43:
          case 42:
          case 40:
          case 39:
          case 34:
          case 15:
          case 14:
          case 12:
          case 6:
          case 1:
            out[y0] = e;
            out[y0 | 1] = e;
            out[y1] = e;
            if (f == h) {
              out[y1 | 1] = h;
            } else {
              out[y1 | 1] = e;
            }
            break;
          case 183:
          case 182:
          case 179:
          case 178:
          case 176:
          case 150:
          case 149:
          case 147:
          case 146:
          case 144:
          case 135:
          case 130:
          case 55:
          case 54:
          case 52:
          case 51:
          case 50:
          case 38:
          case 35:
          case 23:
          case 19:
          case 17:
          case 4:
          case 3:
            out[y0] = e;
            out[y0 | 1] = e;
            out[y1 | 1] = e;
            if (d == h) {
              out[y1] = h;
            } else {
              out[y1] = e;
            }
            break;
          case 237:
          case 236:
          case 232:
          case 225:
          case 205:
          case 204:
          case 201:
          case 200:
          case 196:
          case 192:
          case 169:
          case 136:
          case 109:
          case 108:
          case 105:
          case 100:
          case 77:
          case 76:
          case 73:
          case 65:
          case 44:
          case 32:
          case 13:
          case 9:
            out[y0] = e;
            out[y1] = e;
            out[y1 | 1] = e;
            if (b == f) {
              out[y0 | 1] = b;
            } else {
              out[y0 | 1] = e;
            }
            break;
          case 181:
          case 177:
          case 132:
          case 53:
            out[y0 | 1] = e;
            out[y1 | 1] = e;
            if (b == d) {
              out[y0] = b;
            } else {
              out[y0] = e;
            }
            if (d == h) {
              out[y1] = h;
            } else {
              out[y1] = e;
            }
            break;
          case 229:
          case 197:
          case 160:
          case 101:
            out[y1] = e;
            out[y1 | 1] = e;
            if (b == d) {
              out[y0] = b;
            } else {
              out[y0] = e;
            }
            if (b == f) {
              out[y0 | 1] = b;
            } else {
              out[y0 | 1] = e;
            }
            break;
          case 255:
          case 254:
          case 253:
          case 252:
          case 251:
          case 250:
          case 249:
          case 248:
          case 247:
          case 246:
          case 244:
          case 243:
          case 242:
          case 239:
          case 238:
          case 235:
          case 234:
          case 233:
          case 231:
          case 230:
          case 227:
          case 226:
          case 224:
          case 223:
          case 222:
          case 221:
          case 220:
          case 219:
          case 218:
          case 217:
          case 216:
          case 215:
          case 214:
          case 211:
          case 210:
          case 208:
          case 207:
          case 206:
          case 203:
          case 202:
          case 199:
          case 198:
          case 195:
          case 194:
          case 191:
          case 190:
          case 189:
          case 188:
          case 187:
          case 186:
          case 185:
          case 184:
          case 165:
          case 164:
          case 162:
          case 161:
          case 159:
          case 158:
          case 157:
          case 156:
          case 155:
          case 154:
          case 153:
          case 152:
          case 151:
          case 148:
          case 140:
          case 133:
          case 129:
          case 127:
          case 126:
          case 125:
          case 124:
          case 123:
          case 122:
          case 121:
          case 120:
          case 119:
          case 118:
          case 115:
          case 114:
          case 111:
          case 110:
          case 107:
          case 106:
          case 104:
          case 103:
          case 102:
          case 99:
          case 98:
          case 95:
          case 94:
          case 93:
          case 92:
          case 91:
          case 90:
          case 89:
          case 88:
          case 87:
          case 86:
          case 83:
          case 82:
          case 80:
          case 79:
          case 78:
          case 75:
          case 74:
          case 72:
          case 71:
          case 70:
          case 69:
          case 67:
          case 66:
          case 64:
          case 63:
          case 62:
          case 61:
          case 60:
          case 59:
          case 58:
          case 57:
          case 56:
          case 49:
          case 47:
          case 41:
          case 37:
          case 36:
          case 31:
          case 30:
          case 29:
          case 28:
          case 27:
          case 26:
          case 25:
          case 24:
          case 22:
          case 18:
          case 16:
          case 11:
          case 10:
          case 8:
          case 7:
          case 2:
          case 0:
            out[y0] = e;
            out[y0 | 1] = e;
            out[y1] = e;
            out[y1 | 1] = e;
            break;
          case 245:
          case 241:
          case 240:
          case 228:
          case 213:
          case 212:
          case 209:
          case 193:
          case 180:
          case 145:
          case 128:
          case 117:
          case 116:
          case 113:
          case 112:
          case 97:
          case 96:
          case 85:
          case 84:
          case 81:
          case 68:
          case 48:
          case 21:
          case 20:
            out[y0 | 1] = e;
            out[y1] = e;
            out[y1 | 1] = e;
            if (b == d) {
              out[y0] = b;
            } else {
              out[y0] = e;
            }
            break;
          case 167:
          case 166:
          case 163:
          case 5:
            out[y0] = e;
            out[y0 | 1] = e;
            if (d == h) {
              out[y1] = h;
            } else {
              out[y1] = e;
            }
            if (f == h) {
              out[y1 | 1] = h;
            } else {
              out[y1 | 1] = e;
            }
            break;
        }
      }
    }
  }
}