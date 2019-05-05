package nintaco.input;

import java.io.*;
import nintaco.*;
import nintaco.input.arkanoid.*;
import nintaco.input.bandaihypershot.*;
import nintaco.input.barcodebattler.*;
import nintaco.input.battlebox.*;
import nintaco.input.doremikkokeyboard.*;
import nintaco.input.excitingboxing.*;
import nintaco.input.familybasic.datarecorder.*;
import nintaco.input.familybasic.keyboard.*;
import nintaco.input.familybasic.transformer.*;
import nintaco.input.familytrainermat.*;
import nintaco.input.gamepad.*;
import nintaco.input.glasses.*;
import nintaco.input.konamihypershot.*;
import nintaco.input.horitrack.*;
import nintaco.input.mahjong.*;
import nintaco.input.miraclepiano.*;
import nintaco.input.multitap.*;
import nintaco.input.none.*;
import nintaco.input.oekakids.*;
import nintaco.input.pachinko.*;
import nintaco.input.partytap.*;
import nintaco.input.powerglove.*;
import nintaco.input.powerpad.*;
import nintaco.input.racermate.*;
import nintaco.input.snesmouse.*;
import nintaco.input.subor.*;
import nintaco.input.taptapmat.*;
import nintaco.input.topriderbike.*;
import nintaco.input.turbofile.*;
import nintaco.input.uforce.*;
import nintaco.input.zapper.*;
import static nintaco.input.InputDevices.*;

public abstract class DeviceMapper implements Serializable {
  
  private static final long serialVersionUID = 0;
  
  public abstract int getInputDevice();
  public abstract void update(final int buttons);
  public abstract void writePort(final int value);
  public abstract int readPort(final int portIndex);
  public abstract int peekPort(final int portIndex); 
  
  public void setMachine(final Machine machine) {    
  }
  
  public void render(final int[] screen) {    
  }
  
  public void close(final boolean saveNonVolatileData) {    
  }
  
  static DeviceMapper createDeviceMapper(final int port, 
      final int inputDevice) {
   
    switch(inputDevice) {
      case Gamepad1:
      case Gamepad2:
      case Gamepad3:
      case Gamepad4:
      case CrazyClimberLeft:
      case CrazyClimberRight:
        return new GamepadMapper(port);
      case Zapper: {        
        if (App.isVsUniSystem()) {
          return new VsZapperMapper(port);
        } else {
          return new ZapperMapper(port);
        }
      }
      case Arkanoid:
        return new ArkanoidMapper(port);
      case BandaiHyperShot:
        return new BandaiHyperShotMapper();
      case BarcodeBattler:
        return new BarcodeBattlerMapper();
      case BattleBox:
        return new BattleBoxMapper();
      case DataRecorder:
        return new DataRecorderMapper();
      case DoremikkoKeyboard:
        return new DoremikkoKeyboardMapper();
      case ExcitingBoxing:
        return new ExcitingBoxingMapper();
      case FamilyTrainerMat:
        return new FamilyTrainerMatMapper();
      case Glasses:
        return new GlassesMapper();
      case Keyboard:
        return new KeyboardMapper();
      case KonamiHyperShot:
        return new KonamiHyperShotMapper();
      case HoriTrack:
        return new HoriTrackMapper();
      case Mahjong:
        return new MahjongMapper();
      case MiraclePiano:
        return new MiraclePianoMapper();
      case OekaKids:
        return new OekaKidsMapper();
      case Pachinko:
        return new PachinkoMapper();
      case PartyTap:
        return new PartyTapMapper();
      case PowerGlove:
        return new PowerGloveMapper(port);
      case PowerPad:
        return new PowerPadMapper(port);
      case RacerMate1:
      case RacerMate2:
        return new RacerMateMapper(port);
      case SnesMouse:
        return new SnesMouseMapper(port);
      case Subor:
        return new SuborMapper();
      case TapTapMat:
        return new TapTapMatMapper();
      case TopRiderBike:
        return new TopRiderBikeMapper();
      case TransformerKeyboard:
        return new TransformerMapper();
      case TurboFile:
        return new TurboFileMapper();
      case UForce:
        return new UForceMapper();
      case NESFourScore1:
      case NESFourScore2:
        return new NESFourScoreMapper(port);
      case Famicom4PlayersAdapter1:
      case Famicom4PlayersAdapter2:
        return new Famicom4PlayersAdapterMapper(port);        
      default:
        return new NoneMapper();
    }
  }
}