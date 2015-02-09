package org.usfirst.frc.team3200.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3200.robot.commands.*;
import org.usfirst.frc.team3200.robot.commands.autonomous.*;
import org.usfirst.frc.team3200.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	//Declare the OI for use by the Scheduler
	public static OI oi;
	
	//Declare a CommandGroup for selecting which autonomous to run
	CommandGroup autoMode;
	
	//Declare a selector to be put on the SmartDashboard
	SendableChooser autoChooser;
	
	//Create the subsystems for use by the robot
	public static DriveTrain drive = new DriveTrain();
	public static Pneumatics pistons = new Pneumatics();
	public static Elevator elevator = new Elevator();
	public static Sensors sensors = new Sensors();
	
    public void robotInit() {
		oi = new OI();
		
		//Create the autoChooser and add CommandGroups as choices
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Test", new TestAuto());
		autoChooser.addObject("Drive Forward", new DriveForwardAuto());
		
		//put the autoChooser on the SmartDashboard
		SmartDashboard.putData("Auto Mode", autoChooser);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	//run the CommandGroup that was selected in the SmartDashboard
//    	TODO: UNCOMMENT
//        autoMode = (CommandGroup) autoChooser.getSelected();
//        autoMode.start();
    	System.out.println("blah2");
    }

    public void autonomousPeriodic() {
//    	TODO: UNCOMMENT
//        Scheduler.getInstance().run();
        System.out.println("blah.");
    }

    public void teleopInit() {
    	sensors.resetGyro();
    }

    public void disabledInit(){
        
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();

        
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
