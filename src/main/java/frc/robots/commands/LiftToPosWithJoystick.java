/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robots.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robots.Robot;
import frc.robots.RobotMap;
import frc.robots.subsystems.TalonSubsystem;
import frc.robots.talonpidconstants.LiftTalonMotionMagicConstants;

public class LiftToPosWithJoystick extends Command {

  private double targetPos = 0;
  public LiftToPosWithJoystick() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.lift);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
        System.out.println(LiftTalonMotionMagicConstants.getEncoderTargetValues()[1]);
        double liftStickAxis = 1.0 * Robot.oi.getController().getRawAxis(RobotMap.LIFT_STICK_Y_AXIS);
        // double adjustedStickOutput = (liftStickAxis + 1.0) / 2.0;
        if ((liftStickAxis) > -0.05) { liftStickAxis = 0;}
        System.out.println("Lift Stick Axis value: " + liftStickAxis);
        SmartDashboard.putNumber("Lift Stick Axis value", liftStickAxis);
        SmartDashboard.putNumber("Arm nominal output", Robot.lift.getNominalOutput());
        Robot.lift.putLiftTalonOutputsSmartDash();
        if(liftStickAxis < -0.05) {
            Robot.lift.resetNominalOutput();
            targetPos =  liftStickAxis * LiftTalonMotionMagicConstants.getkSensorUnitsPerRotation() * 3.2;
            System.out.println("Target Pos Value: " + targetPos);
            SmartDashboard.putNumber("Target Pos Value", targetPos);
            Robot.lift.setLiftPosWithJoystick(targetPos);
            Robot.lift.printLiftTalonOutputs();
        } 
        else {
            Robot.lift.configLiftNominalPercentOutput();
            targetPos = 0;
        }
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
