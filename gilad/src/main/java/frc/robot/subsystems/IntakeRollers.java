// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeRollers extends SubsystemBase {
  private VictorSP victor;
  public static enum rollerState{
    IN,
    OUT,
    OFF
  }
  /** Creates a new IntakeRollers. */
  public IntakeRollers() {
    victor = new VictorSP(2);
  }

  public void setState(rollerState state){

    if(state == getState()){
      return;
    }
    switch(state){
        case IN:
            victor.set(-1);
            break;
        case OUT:
            victor.set(1);
            break;
        default:
            break;
    }
  }
    
  

  public rollerState getState(){
    if(victor.get() == 1)
      return rollerState.OUT;
     else if(victor.get() == -1)
      return rollerState.IN;
    else 
      return rollerState.OFF;
    
    
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
