package org.usfirst.frc.team3200.robot.subsystems;

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
    
    private RobotDrive drive;
    private Encoder frontRight;
    private Encoder rearRight;
    private Encoder frontLeft;
    private Encoder rearLeft;
    
    public DriveTrain() {
        drive = new RobotDrive(RobotMap.FRONT_LEFT, RobotMap.BACK_LEFT, 
                               RobotMap.FRONT_RIGHT, RobotMap.BACK_RIGHT);
        drive.setInvertedMotor(MotorType.kFrontLeft, true);
        drive.setInvertedMotor(MotorType.kRearLeft, true);
        
        //Initialize the encoders
        frontRight = new Encoder(RobotMap.FR_ENCODER_A, RobotMap.FR_ENCODER_B);
        rearRight = new Encoder(RobotMap.BR_ENCODER_A, RobotMap.BR_ENCODER_B);
        frontLeft = new Encoder(RobotMap.FL_ENCODER_A, RobotMap.FL_ENCODER_B);
        rearLeft = new Encoder(RobotMap.BL_ENCODER_A, RobotMap.BL_ENCODER_B);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveControlled());
    }
    
    public void mecanumDrive(Joystick controller) {
        double x =  -controller.getRawAxis(RobotMap.LEFT_STICK_X);
        double y =   controller.getRawAxis(RobotMap.LEFT_STICK_Y);
        double rot = controller.getRawAxis(RobotMap.RIGHT_STICK_X);
        drive.mecanumDrive_Cartesian(x, y, rot , 0);
    }
}

