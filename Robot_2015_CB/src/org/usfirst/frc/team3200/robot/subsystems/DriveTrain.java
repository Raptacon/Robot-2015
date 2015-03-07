package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.Robot;
import org.usfirst.frc.team3200.robot.RobotMap;
import org.usfirst.frc.team3200.robot.commands.DriveControlled;

//import parts.LinearLimitSC;
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
    
    //average number of meters per encoder pulse
    final double DIST_PER_PULSE_TEST = 0.001109789;
    final double DIST_PER_PULSE_COMP = 0.001680538;
    
    double distPerPulse;
    
    public DriveTrain() {
    	super("DriveTrain");
    	
    	//set the distance per pulse depending on the robot selected
    	if(Robot.robotType == RobotMap.TEST_BOT) {
    		distPerPulse = DIST_PER_PULSE_TEST;
    	} else {
    		distPerPulse = DIST_PER_PULSE_COMP;
    	}
    	
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
        frontRight.setDistancePerPulse(-distPerPulse);
        rearRight.setDistancePerPulse(-distPerPulse);
        frontLeft.setDistancePerPulse(distPerPulse);
        rearLeft.setDistancePerPulse(distPerPulse);
    }
    
    //sets DriveControlled as the default command for this subsystem
    public void initDefaultCommand() {
        setDefaultCommand(new DriveControlled());
    }
    
    //sets the direction and the rotation of the drive train
    public void mecanumDrive(float x, float y, float rot) {
    	drive.mecanumDrive_Cartesian(x, y, -rot, 0);
    }

    //sets the direction and the rotation of the drive train using values from a controller
    public void mecanumDrive(Joystick controller) {
        double x =  (controller.getRawAxis(RobotMap.LEFT_STICK_X));
        double y =  (controller.getRawAxis(RobotMap.LEFT_STICK_Y));
        double rot = (controller.getRawAxis(RobotMap.RIGHT_STICK_X));
        
        x *= Math.abs(x);
        y *= Math.abs(y);
        rot *= Math.abs(rot);
        
//        if(Robot.oi.buttonR.get()) {
//        	x *= 0.5;
//        	y *= 0.5;
//        	rot *= 0.5;
//        }

        drive.mecanumDrive_Cartesian(-x, -y, -rot , 0);
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
    
    //gets the average distance recorded by the encoders (forward and backwards)
    public double getYDistance() {
    	return (frontRight.getDistance() + rearRight.getDistance() +
    			frontLeft.getDistance() + rearLeft.getDistance()) / 4;
    }
    
    //gets the average distance recorded by the encoders (left and right)
    public double getXDistance() {
    	return(frontLeft.getDistance() + frontRight.getDistance() -
    		   rearLeft.getDistance() - rearRight.getDistance()) / 4 * 0.85;
    }
}