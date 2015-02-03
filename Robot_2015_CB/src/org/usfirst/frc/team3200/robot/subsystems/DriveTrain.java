package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.Robot;
import org.usfirst.frc.team3200.robot.RobotMap;
import org.usfirst.frc.team3200.robot.commands.DriveControlled;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
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
    double distPerPulse = 0.001056942;
    
    public DriveTrain() {
    	super("DriveTrain");
    	//Initialize motors and invert left side motors
        drive = new RobotDrive(RobotMap.FRONT_LEFT, RobotMap.BACK_LEFT, 
                               RobotMap.FRONT_RIGHT, RobotMap.BACK_RIGHT);
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
    	drive.mecanumDrive_Cartesian(x, -y, -rot, 0);
    }

    //sets the direction and the rotation of the drive train using values from a controller
    public void mecanumDrive(Joystick controller) {
        double x =  controller.getRawAxis(RobotMap.LEFT_STICK_X);
        double y =  -controller.getRawAxis(RobotMap.LEFT_STICK_Y);
        double rot = -controller.getRawAxis(RobotMap.RIGHT_STICK_X);
        drive.mecanumDrive_Cartesian(x, y, rot , 0); //drive.mecanumDrive_Cartesian(x, y, rot , Robot.sensors.getGyroAngle());
//        System.out.print(frontLeft.getRate() + "    ");
//        System.out.println(frontRight.getRate());
//        System.out.print(rearLeft.getRate() + "    ");
//        System.out.println(rearRight.getRate());
//        System.out.println();
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