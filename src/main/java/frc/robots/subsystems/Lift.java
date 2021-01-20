// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robots.subsystems;

import frc.robots.Robot;
import frc.robots.RobotMap;
import frc.robots.commands.*;
import frc.robots.subsystems.TalonSubsystem.TalonConfiguration;
import frc.robots.talonpidconstants.LiftTalonMotionMagicConstants;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class Lift extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_TalonSRX liftTalon;
    // private DoubleSolenoid liftActuator;
    private Solenoid liftActuator;
    private TalonConfiguration liftArmConfig;
    
    private double nominalOutput = 0.0;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // Initialize your subsystem here
    public Lift() {

        liftTalon = new WPI_TalonSRX(RobotMap.LIFT_ARM_TALON_CAN_ID);
        liftTalon.configFactoryDefault();
        // Sensor Phase First Robot
        // liftTalon.setSensorPhase(true);

        // Sensor Phase Second Robot
        liftTalon.setSensorPhase(true);
        liftTalon.setInverted(false);
        // liftTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 30);
        liftTalon.setNeutralMode(NeutralMode.Brake);
        liftTalon.configReverseSoftLimitThreshold(-20, 30);
        liftTalon.configForwardSoftLimitThreshold(12500, 30);
        liftTalon.configForwardSoftLimitEnable(true);
        liftTalon.configReverseSoftLimitEnable(true);
        liftTalon.configOpenloopRamp(0.75, 30);
        liftTalon.configClosedloopRamp(2.0, 30);

        
  
        // liftTalon.setSelectedSensorPosition(0, 0, 30);

        liftArmConfig = new TalonConfiguration(LiftTalonMotionMagicConstants.getLiftmotionmagicgains());
        TalonSubsystem.configureTalon(liftTalon, liftArmConfig, FeedbackDevice.CTRE_MagEncoder_Relative);
        TalonSubsystem.configureNominalAndPeakOutputs(liftTalon, liftArmConfig, 0.0, 0, 1, -1);
        TalonSubsystem.configureMotionMagicValues(liftTalon, liftArmConfig, LiftTalonMotionMagicConstants.getMotionmagiccruisevelocity(), LiftTalonMotionMagicConstants.getMotionmagicacceleration());
        TalonSubsystem.zeroSensor(liftTalon, liftArmConfig);    
        
        // liftActuator = new DoubleSolenoid(RobotMap.PCM_MODULE_NUMER, 0, 1);
        // liftActuator.set(Value.kForward);
        // addChild("LiftActuator",liftActuator);
        
        liftActuator = new Solenoid(RobotMap.LIFT_ACTUATOR_CHANEL_NUMBER);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    
    @Override
    public void initDefaultCommand() {
        // this.setDefaultCommand(new LiftUpDown());
        // this.setDefaultCommand(new LiftToLowPos());
        // this.setDefaultCommand(new LiftToPosWithJoystick());
        this.setDefaultCommand(new LiftArmPercentOutput());
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS
    public void setLiftPercentOutput(double output) {
        liftTalon.set(ControlMode.PercentOutput, output);
    }

    // public void setLiftActuator(DoubleSolenoid.Value direction) {
    //     liftActuator.set(direction);
    // }

    public WPI_TalonSRX getLiftTalon() {
        return this.liftTalon;
    }

    // public boolean isLiftActuatorForward() {
    //     if(liftActuator.get() == Value.kForward) {
    //         return true;
    //     }
    //     return false;
    // }

    public void printLiftTalonOutputs() {
        TalonSubsystem.printTalonOutputs(this.liftTalon);
    }

    public void putLiftTalonOutputsSmartDash() {
        TalonSubsystem.putTalonOutputsSmartDash(liftTalon);
    }

    public void setHatchPanelPickupPos() {
        TalonSubsystem.setTalonMotionMagic(liftTalon, -LiftTalonMotionMagicConstants.getEncoderTargetValues()[4]);
    }

    public void setLiftPos1(int i) {
        if(i == 2) {
            TalonSubsystem.setTalonMotionMagic(liftTalon, -LiftTalonMotionMagicConstants.getEncoderTargetValues()[0]);
        }
        if(i == 30) {
            setLiftActuatorOut();
        }   
    }

    
    public void setLiftPos2(int i) {    
        System.out.println(i);
        if(i == 5) {
            TalonSubsystem.setTalonMotionMagic(liftTalon, -LiftTalonMotionMagicConstants.getEncoderTargetValues()[0]);
        }        
        if(i == 50) {
            setLiftActuatorOut();
        }
        if(i == 80) {
            TalonSubsystem.setTalonMotionMagic(liftTalon, -LiftTalonMotionMagicConstants.getEncoderTargetValues()[1]);
        }   
        
    }

    public void setLiftPos3(int i) {
        System.out.println(i);
        if(i == 5) {
            TalonSubsystem.setTalonMotionMagic(liftTalon, -LiftTalonMotionMagicConstants.getEncoderTargetValues()[0]);
        }  
        if(i == 50) {
            setLiftActuatorOut();
        }
        if(i == 80) {
            TalonSubsystem.setTalonMotionMagic(liftTalon, -LiftTalonMotionMagicConstants.getEncoderTargetValues()[2]);
        }
    }

    public void setLiftStowed(int i) {
        if(i == 5) {
            TalonSubsystem.setTalonMotionMagic(liftTalon, -LiftTalonMotionMagicConstants.getEncoderTargetValues()[0]);
        }
        if(i == 40) {
            setLiftActuatorIn();
        }
        if(i == 75) {
            TalonSubsystem.setTalonMotionMagic(liftTalon, -LiftTalonMotionMagicConstants.getEncoderTargetValues()[3]);
        }   
    }

    // public Value getLiftActuatorDirection() {
    //     return liftActuator.get();
    // }

    public boolean isLiftActuatorForward() {
        return liftActuator.get();
    }

    public int getLiftEncoderPosition() {
        return liftTalon.getSelectedSensorPosition();
    }

    public void setLiftPosWithJoystick(double targetValue) {
        TalonSubsystem.setTalonMotionMagic(liftTalon, targetValue);
    }

    public void configLiftNominalPercentOutput() {   
        nominalOutput += 0.008;
        if(nominalOutput >= 0) {
            nominalOutput = 0.0;
        }
        liftTalon.set(ControlMode.PercentOutput, nominalOutput);
    }
    
    public void resetNominalOutput() {
        nominalOutput = -0.075;
    }

    public double getNominalOutput() {
        return nominalOutput;
    }

    public void setLiftActuatorOut() {
        liftActuator.set(true);
    }

    public void setLiftActuatorIn() {
        liftActuator.set(false);
    }

    public void doLiftActuator() {
        if(!isLiftActuatorForward()) {
            setLiftActuatorOut();
          } else {
            setLiftActuatorIn();
          }
    }

    

}