package frc.robots;

import edu.wpi.first.wpilibj.SPI;

public class RobotMap {
    public static final int 
        XBOX_PORT_0 = 0,
        XBOX_PORT_1 = 1,

        DRIVE_STICK_Y_AXIS = 1,
        DRIVE_STICK_X_AXIS = 0,

        LEFT_TRIGGER_AXIS = 2,
        LEFT_DRIVE_TALON_CAN_ID = 5,
        LEFT_DRIVE_VICTOR_CAN_ID = 3,

        RIGHT_DRIVE_TALON_CAN_ID = 4,
        RIGHT_DRIVE_VICTOR_CAN_ID = 2,

        LIFT_ARM_TALON_CAN_ID = 7,
        
        HAB_CLIMB_WHEEL_CAN_ID = 6,
        
        LIFT_STICK_Y_AXIS = 5,
        
        FRONT_MOTOR_CLIMB = 1,
        BACK_MOTOR_CLIMB = 0,
        
        MOTOR_FRONT_CLIMB_AXIS = 1,
        MOTOR_BACK_CLIMB_AXIS = 5,
        
        PCM_MODULE_NUMER = 0,

        CLAW_ACTUATOR_FORWARD_CHANNEL = 0,
        CLAW_ACTUATOR_REVERSE_CHANNEL = 1,


        CLAW_ACTUATOR_CHANNEL_NUMBER = 6,
        
        LIFT_ACTUATOR_CHANEL_NUMBER = 2,
        MOTION_MAGIC_DRIVETRAIN_AXIS = 5;
        


}