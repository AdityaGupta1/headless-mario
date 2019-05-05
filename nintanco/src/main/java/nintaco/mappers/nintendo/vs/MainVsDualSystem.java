package nintaco.mappers.nintendo.vs;

import nintaco.*;
import nintaco.files.*;
import nintaco.input.*;
import nintaco.input.gamepad.*;
import nintaco.mappers.*;
import static nintaco.CPU.*;
import static nintaco.input.InputDevices.*;
import static nintaco.util.BitUtil.*;
import static nintaco.mappers.NametableMirroring.*;
import static nintaco.mappers.nintendo.vs.VsSystem.*;

public class MainVsDualSystem extends Mapper {
  
  private static final long serialVersionUID = 0;
  
  private SubVsDualSystem subVsDualSystem;
  
  public MainVsDualSystem(final CartFile cartFile) {
    super(new SplitCartFile(cartFile, true), 8, 1);
    setNametableMirroring(FOUR_SCREEN);
    setPrgBank(4, 0);
    setPrgBank(5, 1);
    setPrgBank(6, 2);
    setPrgBank(7, 3);
    
    subVsDualSystem = new SubVsDualSystem(cartFile);
    subVsDualSystem.setMainVsDualSystem(this);    
  }  
  
  @Override public boolean isVsDualSystem() {
    return true;
  }

  public SubVsDualSystem getSubVsDualSystem() {
    return subVsDualSystem;
  }

  public void setSubVsDualSystem(final SubVsDualSystem subVsDualSystem) {
    this.subVsDualSystem = subVsDualSystem;
  }
  
  @Override public void restore(final CartFile cartFile) {    
    if (cartFile instanceof SplitCartFile) {
      super.restore(cartFile);
    } else if (cartFile != null) {
      super.restore(new SplitCartFile(cartFile, true));
      subVsDualSystem.restore(new SplitCartFile(cartFile, false));
    }
  }

  @Override public int readCpuMemory(final int address) {
    if ((address & 0xE000) == 0x6000) {
      return memory[0x6000 | (address & 0x07FF)];
    } else {
      return super.readCpuMemory(address);
    }
  }

  @Override public void writeCpuMemory(final int address, final int value) {    
    if ((address & 0xE000) == 0x6000) {
      memory[0x6000 | (address & 0x07FF)] = value;
    } else {    
      if (address == REG_OUTPUT_PORT) {
        writeBankSelect(value);
      }
      super.writeCpuMemory(address, value);
    }
  }
  
  public void setMapperIrq(final boolean value) {
    cpu.setMapperIrq(value);
  }  

  private void writeBankSelect(final int value) { 
    
    final int bank = getBit(value, 2);
    setChrBank(bank);
    if (prgRomLength > 0x8000) {
      setPrgBank(4, bank << 2);
    }
    
    if (getBitBool(value, 1)) {
      subVsDualSystem.setMapperIrq(false);
    } else {
      subVsDualSystem.setMapperIrq(true);
    }    
  }

  @Override public void setMachine(final Machine machine) {
    super.setMachine(machine);      
    final MainCPU mainCPU = (MainCPU)machine.getCPU();      
    subVsDualSystem.setCPU(mainCPU.getSubCPU());
    subVsDualSystem.setPPU(mainCPU.getSubPPU());
    subVsDualSystem.setAPU(mainCPU.getSubAPU());
  }

  @Override public void setDipSwitchesValue(final int dipSwitchesValue) {
    super.setDipSwitchesValue(dipSwitchesValue & 0xFF);
    subVsDualSystem.setDipSwitchesValue((dipSwitchesValue >> 8) & 0xFF);
  }

  @Override public void init() {
    super.init();
    subVsDualSystem.init();
  }
  
  @Override public void setDeviceMappers(final DeviceMapper[] deviceMappers) {
    super.setDeviceMappers(deviceMappers);
    subVsDualSystem.setDeviceMappers(deviceMappers);      
  }

  @Override public void updateButtons(final int buttons) {
    super.updateButtons(buttons);
    subVsDualSystem.updateButtons(buttons);
  }

  @Override public void insertCoin(final int vsSystem, final int coinSlot) {
    if (vsSystem == Main) {
      super.insertCoin(vsSystem, coinSlot);
    } else {
      subVsDualSystem.insertCoin(vsSystem, coinSlot);
    }
  }
  
  @Override public void pressServiceButton(final int vsSystem) {
    if (vsSystem == Main) {
      super.pressServiceButton(vsSystem);
    } else {
      subVsDualSystem.pressServiceButton(vsSystem);
    }
  }
  
  @Override public void writeOutputPort(final int value) {
    final DeviceMapper[] mappers = deviceMappers;
    for(int i = mappers.length - 1; i >= 0; i--) {
      final DeviceMapper mapper = mappers[i];
      if (isGamepad(mapper.getInputDevice())
          && ((GamepadMapper)mapper).getPortIndex() <= 1) {
        mappers[i].writePort(value);
      }
    }
  }  

  @Override public int readInputPort(final int portIndex) {    
    final DeviceMapper[] mappers = deviceMappers;
    int value;
    if (portIndex == 0) {
      value = coinMask | ((dipSwitchesValue & 0x03) << 3) | serviceButtonMask;
    } else {
      value = dipSwitchesValue & 0xFC;        
    }    
    for(int i = mappers.length - 1; i >= 0; i--) {
      value |= mappers[i].readPort(portIndex);
    }       
    return value;
  }
  
  @Override public int peekInputPort(final int portIndex) {    
    final DeviceMapper[] mappers = deviceMappers;
    int value;
    if (portIndex == 0) {
      value = coinMask | ((dipSwitchesValue & 0x03) << 3) | serviceButtonMask;
    } else {
      value = dipSwitchesValue & 0xFC;
    }      
    for(int i = mappers.length - 1; i >= 0; i--) {
      value |= mappers[i].peekPort(portIndex);
    }
    return value;
  }

  @Override public void setVramMask(final int vramMask) {
    super.setVramMask(vramMask);
    subVsDualSystem.setVramMask(vramMask);
  }
}