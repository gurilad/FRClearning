// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.SetElivatorState;
import frc.robot.commands.SetIntakeArmState;
import frc.robot.commands.SetIntakeRollerState;
import frc.robot.subsystems.Elivator;
import frc.robot.subsystems.IntakeRollers;
import frc.robot.subsystems.intakeArm;
import frc.robot.subsystems.Elivator.vicStates;
import frc.robot.subsystems.IntakeRollers.rollerState;
import frc.robot.subsystems.intakeArm.state;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Collects extends SequentialCommandGroup {
  /** Creates a new Collects. */
  public Collects(Elivator elivator, intakeArm arm, IntakeRollers rollers) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new SetElivatorState(elivator, vicStates.BOTTOM),
      new SetIntakeArmState(arm, state.OPEN),
      new SetIntakeRollerState(rollers, rollerState.IN)
    );
  }
}
