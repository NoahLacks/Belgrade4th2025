// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {
  CommandXboxController driver;

  Arm arm;

  Drivetrain drivetrain;

  public RobotContainer() {
    driver = new CommandXboxController(0);

    arm = new Arm();

    drivetrain = new Drivetrain();

    configureBindings();
  }

  private void configureBindings() {
    drivetrain.setDefaultCommand(
      drivetrain.arcadeDrive(driver::getRightX, driver::getLeftY)
    );

    driver.a().whileTrue(
      arm.runArm(() -> -.25)
    );

    driver.y().whileTrue(
      arm.runArm(() -> .25)
    );
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
