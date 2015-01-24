package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.RobotMap;
import org.usfirst.frc.team3200.robot.commands.DriveControlled;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    private RobotDrive drive;
    
    
    public DriveTrain() {
        drive = new RobotDrive(RobotMap.FRONT_LEFT, RobotMap.BACK_LEFT, 
                               RobotMap.FRONT_RIGHT, RobotMap.BACK_RIGHT);
        drive.setInvertedMotor(MotorType.kFrontLeft, true);
        drive.setInvertedMotor(MotorType.kRearLeft, true);
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

