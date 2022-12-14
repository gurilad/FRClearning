// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elivator;
import frc.robot.subsystems.Elivator.vicStates;

public class SetElivatorState extends CommandBase {

  private final Elivator _elivator;
  private vicStates st;

  /** Creates a new SetElivatorState. */
  
  public SetElivatorState(Elivator elv, vicStates state) {
    
    this._elivator = elv;
    st = state;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(_elivator);
  }

  // Called when the command is initially scheduled.
  
  


  @Override
  public void initialize() {
    System.out.println("SETTING ELIVATOR FROM " + _elivator.getState() + " TO "+ st);
    _elivator.setState(st);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
    _elivator.zeroMotor();
    System.out.println("Finished!");
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return _elivator.getState() == st;
  }
}
