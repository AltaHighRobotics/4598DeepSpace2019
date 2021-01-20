// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robots.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robots.Robot;
import frc.robots.talonpidconstants.LiftTalonMotionMagicConstants;

/**
 *
 */
public class LiftToMidPos extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_setpoint;
    private int i = 0;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public LiftToMidPos() {

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.lift);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        i = 0;
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=INITIALIZE
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() { 
        i++;
        System.out.println("Lift To Mid Pos Command");
        Robot.lift.setLiftPos2(i);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return (Robot.lift.getLiftEncoderPosition() >= LiftTalonMotionMagicConstants.getEncoderTargetValues()[1] - 20) &&
        Robot.lift.getLiftEncoderPosition() <= LiftTalonMotionMagicConstants.getEncoderTargetValues()[1] + 20;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ISFINISHED
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