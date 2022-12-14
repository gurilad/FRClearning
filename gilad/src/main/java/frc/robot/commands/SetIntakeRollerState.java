// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeRollers;
import frc.robot.subsystems.IntakeRollers.rollerState;

public class SetIntakeRollerState extends CommandBase {
  private IntakeRollers _rollers;
  private rollerState _state;
  /** Creates a new SetIntakeRollerState. */
  public SetIntakeRollerState(IntakeRollers rollers, rollerState state) {
    // Use addRequirements() here to declare subsystem dependencies.
    _rollers = rollers;
    _state = state;
    addRequirements(_rollers);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    _rollers.setState(_state);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    _rollers.setState(_state.OFF);
    System.out.println("Finished!");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return _rollers.getState() == _state;
  }
}
