/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robots.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robots.Robot;
import frc.robots.RobotMap;

public class ReduceTurnSensitivity extends Command {
  public ReduceTurnSensitivity() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double speed = -0.75 * Robot.oi.getController().getRawAxis(RobotMap.DRIVE_STICK_Y_AXIS);
    double rotation = Robot.oi.getController().getRawAxis(RobotMap.DRIVE_STICK_X_AXIS);
        // boolean quickTurn = false;
        // if(speed > -0.05 && speed < 0.05) {
        //     quickTurn = true;
        // } else {
        //     quickTurn = false;
        // }
        // Robot.driveTrain.curveDrive(0.5*speed, rotation, quickTurn);
        Robot.driveTrain.setArcadeDrive(speed, 0.25 * rotation);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
