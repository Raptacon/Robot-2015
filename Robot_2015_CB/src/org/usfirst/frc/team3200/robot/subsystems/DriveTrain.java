package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.Robot;
import org.usfirst.frc.team3200.robot.RobotMap;
import org.usfirst.frc.team3200.robot.commands.DriveControlled;

import parts.LinearLimitSC;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    //declare drive train controller
    private RobotDrive drive;
    
    //declare motor encoders (counts motor revolutions)
    private Encoder frontRight;
    private Encoder rearRight;
    private Encoder frontLeft;
    private Encoder rearLeft;
    
    //max speed in m/s
    double MAX_SPEED = 2;
    
    double BACK_WHEEL_MULT = 0.5;
    
    //average number of meters per encoder pulse
    final double DIST_PER_PULSE = 0.001056942;
    
    public DriveTrain() {
    	super("DriveTrain");
    	
    	//Initialize motors and invert left side motors
        drive = new RobotDrive(
        		new Talon(RobotMap.FRONT_LEFT),
//        		RobotMap.FRONT_LEFT,
        		//new LinearLimitSC<CANTalon>(new CANTalon(RobotMap.BACK_LEFT), BACK_WHEEL_MULT),
        		new Talon(RobotMap.BACK_LEFT),
//        		RobotMap.BACK_LEFT,
                new Talon(RobotMap.FRONT_RIGHT),
                //new LinearLimitSC<CANTalon>(new CANTalon(RobotMap.BACK_RIGHT), BACK_WHEEL_MULT)
//        		RobotMap.FRONT_RIGHT,
                new Talon(RobotMap.BACK_RIGHT)
//        		RobotMap.BACK_RIGHT
        );
        drive.setInvertedMotor(MotorType.kFrontLeft, true);
        drive.setInvertedMotor(MotorType.kRearLeft, true);
        
        //initialize encoders and set pulse distance
        frontRight = new Encoder(RobotMap.FR_ENCODER_A, RobotMap.FR_ENCODER_B);
        rearRight = new Encoder(RobotMap.BR_ENCODER_A, RobotMap.BR_ENCODER_B);
        frontLeft = new Encoder(RobotMap.FL_ENCODER_A, RobotMap.FL_ENCODER_B);
        rearLeft = new Encoder(RobotMap.BL_ENCODER_A, RobotMap.BL_ENCODER_B);
        frontRight.setDistancePerPulse(-DIST_PER_PULSE);
        rearRight.setDistancePerPulse(-DIST_PER_PULSE);
        frontLeft.setDistancePerPulse(DIST_PER_PULSE);
        rearLeft.setDistancePerPulse(DIST_PER_PULSE);
    }
    
    //sets DriveControlled as the default command for this subsystem
    public void initDefaultCommand() {
        setDefaultCommand(new DriveControlled());
    }
    
    //sets the direction and the rotation of the drive train
    public void mecanumDrive(float x, float y, float rot) {
    	drive.mecanumDrive_Cartesian(x, -y, -rot, 0);
    }

    //sets the direction and the rotation of the drive train using values from a controller
    public void mecanumDrive(Joystick controller) {
        double x =  -(controller.getRawAxis(RobotMap.LEFT_STICK_X) * 0.6);
        double y =  -(controller.getRawAxis(RobotMap.LEFT_STICK_Y) * 0.6);
        double rot = -(controller.getRawAxis(RobotMap.RIGHT_STICK_X) * 0.6);
        x = mapDeadZone(x);
        y = mapDeadZone(y);
        rot = mapDeadZone(rot);
        drive.mecanumDrive_Cartesian(x, y, rot , 0);
//        System.out.print(frontLeft.getRate());
//        System.out.println(frontRight.getRate());
//        System.out.print(rearLeft.getRate());
//        System.out.println(rearRight.getRate());
//        System.out.println();
        //drive.mecanumDrive_Cartesian(x, y, rot , Robot.sensors.getGyroAngle());
        //System.out.println(Robot.sensors.getGyroAngle());
    }
    
    public double mapDeadZone(double n) {
    	if(Math.abs(n) < 0.1) {
    		return 0;
    	} else {
    		return n;
    	}
    }
    
    //stops all motors
    public void stop() {
    	drive.mecanumDrive_Cartesian(0, 0, 0, 0);
    }
    
    //resets all encoders to zero; used to begin a new measurement
    public void resetEncoders() {
    	frontRight.reset();
    	rearRight.reset();
    	frontLeft.reset();
    	rearLeft.reset();
    }
    
    //gets the average distance recorded by the encoders
    public double getDistance() {
    	return (frontRight.getDistance() + rearRight.getDistance() +
    			frontLeft.getDistance() + rearLeft.getDistance()) / 4;
    }
}