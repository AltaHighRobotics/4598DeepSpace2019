/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robots.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robots.Robot;

/**
 * Add your docs here.
 */
public class PlaceDiskWithButton  extends Command {
  /**
   * Add your docs here.
   */
  public PlaceDiskWithButton() {
    requires(Robot.claw);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // Robot.claw.setClawActuatorOut();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
    return false;
  }
  // Called once after timeout
  @Override
  protected void end() {
    // Robot.claw.setClawActuatorIn();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
