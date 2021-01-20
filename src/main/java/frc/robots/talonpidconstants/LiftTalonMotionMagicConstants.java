package frc.robots.talonpidconstants;

import frc.robots.subsystems.TalonSubsystem.TalonPIDConfig;

public class LiftTalonMotionMagicConstants {


    // Whether this loop is driving backwards or forwards: -1 for backwards, 1 for forwards
    private static final double forward = 1.0;
    private static final double backward = -1.0;

    // private static final double maxSensorVelocityFirstRobot  = 2162;
    private static final double maxSensorVelocity = 1450;

    private static final double feedForwardGain = (1.0 * 1023) / maxSensorVelocity;

    private static final int kSensorUnitsPerRotation = 4096;

    // first robot second pos = 6905
    private static final double[] encoderTargetValues = {4060, 8400, 12544, 0, 5200};

    private static final int motionMagicCruiseVelocity = 1500;
    // first robot acceleration and cruise velocity = 700
    private static final int motionMagicAcceleration = 1500;

    // private double firstRobotGains = 0.035;
    private static double secondRobotPGain = 0.5;

    private static final TalonPIDConfig liftMotionMagicGains = new TalonPIDConfig(feedForwardGain, secondRobotPGain, 0.000000001, 0.1);

    

    public static double[] getEncoderTargetValues() {
        return encoderTargetValues;
    }

/**
     * @return the motionmagicacceleration
     */
    public static int getMotionmagicacceleration() {
        return motionMagicAcceleration;
    }

    /**
     * @return the motionmagiccruisevelocity
     */
    public static int getMotionmagiccruisevelocity() {
        return motionMagicCruiseVelocity;
    }

    /**
     * @return the liftmotionmagicgains
     */
	public static TalonPIDConfig getLiftmotionmagicgains() {
		return liftMotionMagicGains;
	}

	/**
     * @return the maxSensorVelocity
     */
    public double getMaxSensorVelocity() {
        return maxSensorVelocity;
    }

    /**
     * @return the kSensorUnitsPerRotation
     */
    public static int getkSensorUnitsPerRotation() {
        return kSensorUnitsPerRotation;
    }

    /**
     * @return the backward
     */
    public static double getBackward() {
        return backward;
    }

    /**
     * @return the forward
     */
    public static double getForward() {
        return forward;
    }
}