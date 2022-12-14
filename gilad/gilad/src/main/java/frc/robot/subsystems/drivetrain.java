// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class drivetrain extends SubsystemBase {
  VictorSP victor;
  Encoder encoder;
  /** Creates a new drivetrain. */
  public drivetrain() {
    victor = new VictorSP(0);
    encoder = new Encoder(0,1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setVictor(double speed){
    this.victor.set(speed);
  }
  public int getEncoder(){
    return this.encoder.get();
  }
}
