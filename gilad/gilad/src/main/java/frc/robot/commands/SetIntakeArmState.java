// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intakeArm;
import frc.robot.subsystems.intakeArm.state;

public class SetIntakeArmState extends CommandBase {
  private final intakeArm _arm;
  private state _state;

  /** Creates a new SetIntakeArmState. */
  public SetIntakeArmState(intakeArm arm,state state) {
    // Use addRequirements() here to declare subsystem dependencies.
    this._arm = arm;
    this._state = state;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(_arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    _arm.setState(_state);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
    _arm.zeroMotor();
    System.out.println("Finished!");
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return _arm.getState() == _state;
  }
}
