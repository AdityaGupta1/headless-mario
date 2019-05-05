package nintaco.input;

import nintaco.input.arkanoid.*;
import nintaco.input.bandaihypershot.*;
import nintaco.input.barcodebattler.*;
import nintaco.input.battlebox.*;
import nintaco.input.crazyclimber.*;
import nintaco.input.doremikkokeyboard.*;
import nintaco.input.excitingboxing.*;
import nintaco.input.familybasic.datarecorder.*;
import nintaco.input.familybasic.keyboard.*;
import nintaco.input.familybasic.transformer.*;
import nintaco.input.familytrainermat.*;
import nintaco.input.gamepad.*;
import nintaco.input.glasses.*;
import nintaco.input.horitrack.*;
import nintaco.input.konamihypershot.*;
import nintaco.input.mahjong.*;
import nintaco.input.miraclepiano.*;
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

public interface InputDevices {
  
  int None = -1;
  int NESFourScore1 = -2;
  int NESFourScore2 = -3;
  int Famicom4PlayersAdapter1 = -4;
  int Famicom4PlayersAdapter2 = -5;
  
  int Gamepad1 = 0;
  int Gamepad2 = 1;
  int Gamepad3 = 2;
  int Gamepad4 = 3;
  int Zapper = 4;
  int Arkanoid = 5;
  int BandaiHyperShot = 6;
  int BarcodeBattler = 7;
  int BattleBox = 8;
  int CrazyClimberLeft = 9;
  int CrazyClimberRight = 10;
  int DataRecorder = 11;
  int DoremikkoKeyboard = 12;
  int ExcitingBoxing = 13;
  int FamilyTrainerMat = 14;
  int Glasses = 15;
  int HoriTrack = 16;
  int Keyboard = 17;
  int KonamiHyperShot = 18;
  int Mahjong = 19;
  int MiraclePiano = 20;
  int OekaKids = 21;
  int Pachinko = 22;
  int PartyTap = 23;
  int PowerGlove = 24;
  int PowerPad = 25;
  int RacerMate1 = 26;
  int RacerMate2 = 27;
  int SnesMouse = 28;
  int Subor = 29;
  int TapTapMat = 30;
  int TopRiderBike = 31;
  int TransformerKeyboard = 32;
  int TurboFile = 33;
  int UForce = 34;
  
  int DevicesCount = 35;
  
  static boolean isGamepad(final int inputDevice) {
    return inputDevice == Gamepad1 || inputDevice == Gamepad2 
        || inputDevice == Gamepad3 || inputDevice == Gamepad4;
  }
  
  static DeviceConfig newDeviceConfig(final int inputDevice) {
    switch(inputDevice) {
      case Gamepad1:
        return new Gamepad1Config();
      case Gamepad2:
        return new Gamepad2Config();
      case Gamepad3:
        return new Gamepad3Config();
      case Gamepad4:
        return new Gamepad4Config();
      case Zapper:
        return new ZapperConfig();
      case Arkanoid:
        return new ArkanoidConfig();
      case BandaiHyperShot:
        return new BandaiHyperShotConfig();
      case BarcodeBattler:
        return new BarcodeBattlerConfig();
      case BattleBox:
        return new BattleBoxConfig();
      case CrazyClimberLeft:
        return new CrazyClimberLeftConfig();
      case CrazyClimberRight:
        return new CrazyClimberRightConfig();
      case DataRecorder:
        return new DataRecorderConfig();  
      case DoremikkoKeyboard:
        return new DoremikkoKeyboardConfig();
      case ExcitingBoxing:
        return new ExcitingBoxingConfig();
      case FamilyTrainerMat:
        return new FamilyTrainerMatConfig();
      case Glasses:
        return new GlassesConfig();
      case HoriTrack:
        return new HoriTrackConfig();
      case Keyboard:
        return new KeyboardConfig();
      case KonamiHyperShot:
        return new KonamiHyperShotConfig();
      case Mahjong:
        return new MahjongConfig();
      case MiraclePiano:
        return new MiraclePianoConfig();
      case OekaKids:
        return new OekaKidsConfig();
      case Pachinko:
        return new PachinkoConfig();
      case PartyTap:
        return new PartyTapConfig();
      case PowerGlove:
        return new PowerGloveConfig();
      case PowerPad:
        return new PowerPadConfig();
      case RacerMate1:
        return new RacerMate1Config();
      case RacerMate2:
        return new RacerMate2Config();
      case Subor:
        return new SuborConfig();
      case SnesMouse:
        return new SnesMouseConfig();
      case TapTapMat:
        return new TapTapMatConfig(); 
      case TopRiderBike:
        return new TopRiderBikeConfig();
      case TransformerKeyboard:
        return new TransformerConfig();
      case TurboFile:
        return new TurboFileConfig();
      case UForce:
        return new UForceConfig();
      default:
        return null;
    }
  }
}