package nintaco.input;

import net.java.games.input.*;
import nintaco.*;
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

public abstract class DeviceDescriptor {
  
  public static final NoneDescriptor None = new NoneDescriptor();
  public static final Gamepad1Descriptor Gamepad1 = new Gamepad1Descriptor();
  public static final Gamepad2Descriptor Gamepad2 = new Gamepad2Descriptor();
  public static final Gamepad3Descriptor Gamepad3 = new Gamepad3Descriptor();
  public static final Gamepad4Descriptor Gamepad4 = new Gamepad4Descriptor();
  public static final ZapperDescriptor Zapper = new ZapperDescriptor();
  public static final ArkanoidDescriptor Arkanoid = new ArkanoidDescriptor();
  public static final BandaiHyperShotDescriptor BandaiHyperShot 
      = new BandaiHyperShotDescriptor();
  public static final BarcodeBattlerDescriptor BarcodeBattler 
      = new BarcodeBattlerDescriptor();
  public static final BattleBoxDescriptor BattleBox = new BattleBoxDescriptor();
  public static final CrazyClimberLeftDescriptor CrazyClimberLeft 
      = new CrazyClimberLeftDescriptor();
  public static final CrazyClimberRightDescriptor CrazyClimberRight
      = new CrazyClimberRightDescriptor();
  public static final DataRecorderDescriptor DataRecorder 
      = new DataRecorderDescriptor();  
  public static final DoremikkoKeyboardDescriptor DoremikkoKeyboard
      = new DoremikkoKeyboardDescriptor();
  public static final ExcitingBoxingDescriptor ExcitingBoxing 
      = new ExcitingBoxingDescriptor();
  public static final FamilyTrainerMatDescriptor FamilyTrainerMat
      = new FamilyTrainerMatDescriptor();
  public static final GlassesDescriptor Glasses = new GlassesDescriptor();
  public static final HoriTrackDescriptor HoriTrack = new HoriTrackDescriptor();
  public static final KeyboardDescriptor Keyboard 
      = new KeyboardDescriptor(); 
  public static final KonamiHyperShotDescriptor KonamiHyperShot 
      = new KonamiHyperShotDescriptor();
  public static final MahjongDescriptor Mahjong = new MahjongDescriptor();
  public static final MiraclePianoDescriptor MiraclePiano 
      = new MiraclePianoDescriptor();
  public static final OekaKidsDescriptor OekaKids = new OekaKidsDescriptor();
  public static final PachinkoDescriptor Pachinko = new PachinkoDescriptor();
  public static final PartyTapDescriptor PartyTap = new PartyTapDescriptor();
  public static final PowerGloveDescriptor PowerGlove 
      = new PowerGloveDescriptor();
  public static final PowerPadDescriptor PowerPad = new PowerPadDescriptor();
  public static final RacerMate1Descriptor RacerMate1 
      = new RacerMate1Descriptor();
  public static final RacerMate2Descriptor RacerMate2 
      = new RacerMate2Descriptor();
  public static final SnesMouseDescriptor SnesMouse = new SnesMouseDescriptor();
  public static final SuborDescriptor Subor = new SuborDescriptor();
  public static final TapTapMatDescriptor TapTapMat = new TapTapMatDescriptor();
  public static final TopRiderBikeDescriptor TopRiderBike 
      = new TopRiderBikeDescriptor();
  public static final TransformerDescriptor TransformerKeyboard
      = new TransformerDescriptor();
  public static final TurboFileDescriptor TurboFile = new TurboFileDescriptor();
  public static final UForceDescriptor UForce = new UForceDescriptor();
  
  public static DeviceDescriptor getDescriptor(final int inputDevice) {
    switch(inputDevice) {
      case InputDevices.Gamepad1:
        return Gamepad1;
      case InputDevices.Gamepad2:
        return Gamepad2;
      case InputDevices.Gamepad3:
        return Gamepad3;
      case InputDevices.Gamepad4:
        return Gamepad4;
      case InputDevices.Zapper:
        return Zapper;
      case InputDevices.Arkanoid:
        return Arkanoid;
      case InputDevices.BandaiHyperShot:
        return BandaiHyperShot;
      case InputDevices.BarcodeBattler:
        return BarcodeBattler;
      case InputDevices.BattleBox:
        return BattleBox;
      case InputDevices.CrazyClimberLeft:
        return CrazyClimberLeft;
      case InputDevices.CrazyClimberRight:
        return CrazyClimberRight;
      case InputDevices.DataRecorder:
        return DataRecorder;
      case InputDevices.DoremikkoKeyboard:
        return DoremikkoKeyboard;
      case InputDevices.ExcitingBoxing:
        return ExcitingBoxing;
      case InputDevices.FamilyTrainerMat:
        return FamilyTrainerMat;
      case InputDevices.Glasses:
        return Glasses;
      case InputDevices.Keyboard:
        return Keyboard;         
      case InputDevices.KonamiHyperShot:
        return KonamiHyperShot;
      case InputDevices.HoriTrack:
        return HoriTrack;
      case InputDevices.Mahjong:
        return Mahjong;
      case InputDevices.MiraclePiano:
        return MiraclePiano;
      case InputDevices.OekaKids:        
        return OekaKids;
      case InputDevices.Pachinko:
        return Pachinko;
      case InputDevices.PartyTap:
        return PartyTap;
      case InputDevices.PowerGlove:      
        return PowerGlove;
      case InputDevices.PowerPad:
        return PowerPad;
      case InputDevices.RacerMate1:
        return RacerMate1;
      case InputDevices.RacerMate2:
        return RacerMate2;        
      case InputDevices.SnesMouse:
        return SnesMouse;
      case InputDevices.Subor:
        return Subor;
      case InputDevices.TapTapMat:
        return TapTapMat; 
      case InputDevices.TopRiderBike:
        return TopRiderBike;
      case InputDevices.TransformerKeyboard:
        return TransformerKeyboard;
      case InputDevices.TurboFile:
        return TurboFile;
      case InputDevices.UForce:
        return UForce;
      default:
        return None;
    }
  }
  
  protected final int inputDevice;
    
  protected volatile boolean holdDownRewindTime;
  protected volatile boolean holdDownHighSpeed;
  
  protected boolean rewindTimePressed;
  protected boolean highSpeedPressed;
  
  protected DeviceDescriptor(final int inputDevice) {
    this.inputDevice = inputDevice;
  }
  
  public abstract String getDeviceName();
  public abstract int getButtonCount();
  public abstract String getButtonName(int buttonIndex);
  public abstract ButtonMapping getDefaultButtonMapping(int buttonIndex);
  public abstract int setButtonBits(int bits, int consoleType, int portIndex, 
      int[] pressedValues);
  
  public int getRewindTimeButton() {
    return -1;
  }
  
  public int getHighSpeedButton() {
    return -1;
  }
  
  private boolean isHoldDownOrToggle(final Inputs inputs, 
      final int buttonIndex) {
    if (buttonIndex >= 0) {
      final HoldDownOrToggleButtonMapping buttonMapping 
          = (HoldDownOrToggleButtonMapping)inputs.getButtonMapping(inputDevice, 
              buttonIndex);
      if (buttonMapping != null) {
        return buttonMapping.isHoldDown();
      }
    }
    return false;
  }

  public void handleSettingsChange(final Inputs inputs) {
    holdDownRewindTime = isHoldDownOrToggle(inputs, getRewindTimeButton());
    holdDownHighSpeed = isHoldDownOrToggle(inputs, getHighSpeedButton());
  }

  public int getInputDevice() {
    return inputDevice;
  }
  
  public ButtonMapping getButtonMapping(final int button, 
      final ButtonID[] buttonIds) {
    if (button == getRewindTimeButton() || button == getHighSpeedButton()) {
      return new HoldDownOrToggleButtonMapping(inputDevice, button, buttonIds, 
          false);
    } else {
      return new ButtonMapping(inputDevice, button, buttonIds);
    }
  }
  
  public ButtonMapping getNoButtonMapping(final int button) {
    if (button == getRewindTimeButton() || button == getHighSpeedButton()) {
      return new HoldDownOrToggleButtonMapping(inputDevice, button);
    } else {
      return new ButtonMapping(inputDevice, button);
    }
  }
  
  protected ButtonMapping getDefaultButtonMapping(final InputDeviceID device,
      final int buttonIndex, final Component.Identifier[] defaults) {  
    if (device != null && defaults != null && buttonIndex < defaults.length) {
      return getButtonMapping(buttonIndex, new ButtonID[] { 
          new ButtonID(device, defaults[buttonIndex].getName(), 1) });
    } else {
      return getNoButtonMapping(buttonIndex);
    }
  } 
  
  protected void updateRewindTime(boolean rewindTime, final int portIndex) {
    if (InputUtil.isInputDisabled()) {
      rewindTime = false;
    }
    if (rewindTime) {
      if (!rewindTimePressed) {
        rewindTimePressed = true;
        if (holdDownRewindTime) {
          App.requestRewindTime(portIndex, true);          
        } else {
          App.requestRewindTime(portIndex);      
        }
      }
    } else {
      if (rewindTimePressed) {
        rewindTimePressed = false;
        if (holdDownRewindTime) {
          App.requestRewindTime(portIndex, false);
        } 
      }
    }
  }
  
  protected void updateHighSpeed(boolean highSpeed, final int portIndex) {
    if (InputUtil.isInputDisabled()) {
      highSpeed = false;
    }
    if (highSpeed) {
      if (!highSpeedPressed) {
        highSpeedPressed = true;
        if (holdDownHighSpeed) {
          App.requestHighSpeed(portIndex, true);          
        } else {
          App.requestHighSpeed(portIndex);      
        }
      }
    } else {
      if (highSpeedPressed) {
        highSpeedPressed = false;
        if (holdDownHighSpeed) {
          App.requestHighSpeed(portIndex, false);
        } 
      }
    }
  }  

  @Override
  public int hashCode() {
    return inputDevice;
  }

  @Override
  public boolean equals(final Object obj) {        
    return obj != null && inputDevice == ((DeviceDescriptor)obj).inputDevice;
  }

  @Override
  public String toString() {
    return getDeviceName();
  }
}