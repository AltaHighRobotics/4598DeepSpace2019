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

public class MotorClimb extends Command {
  public MotorClimb() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.habClimb);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double frontSpeed = Robot.oi.getControllerTwo().getRawAxis(RobotMap.MOTOR_FRONT_CLIMB_AXIS);
    double backSpeed = Robot.oi.getControllerTwo().getRawAxis(RobotMap.MOTOR_BACK_CLIMB_AXIS);
    Robot.habClimb.setFrontMotorClimbSpeed(frontSpeed);
    Robot.habClimb.setBackMotorClimbSpeed(backSpeed);

    // double wheelSpeed = Robot.oi.getController().getRawAxis(RobotMap.LEFT_TRIGGER_AXIS);
    // Robot.habClimb.setHabClimbWheelTalonPercentOutput(wheelSpeed);
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
