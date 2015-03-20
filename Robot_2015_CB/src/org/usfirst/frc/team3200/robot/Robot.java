package org.usfirst.frc.team3200.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	
	//the robot being driven
	public static int robotType;
	
	//Declare a SmartDashboard selector to specify which robot is being driven
	private SendableChooser robotChooser;
	
	//Declare a CommandGroup to contain the autonomous being run
	private CommandGroup autoMode;
	
	//Declare a SmartDashboard selector to choose which autonomous to run
	private SendableChooser autoChooser;
	
	//Create the subsystems for use by the robot
	public static DriveTrain drive = new DriveTrain();
	public static Claw claw = new Claw();
	public static Elevator elevator = new Elevator();
	public static Sensors sensors = new Sensors();
	
    public void robotInit() {
		oi = new OI();
		
		//create the robotChooser and add constants as choices
		robotChooser = new SendableChooser();
		robotChooser.addObject("Practice Robot", RobotMap.TEST_BOT);
		robotChooser.addDefault("Competition Robot", RobotMap.COMP_BOT);
		
		//put the robotChooser on the SmartDashboard
		SmartDashboard.putData("Robot Type", robotChooser);
		
		//Create the autoChooser and add CommandGroups as choices
		autoChooser = new SendableChooser();
		autoChooser.addObject("Test", new TestAuto());
		autoChooser.addDefault("Drive Forward", new DriveForwardAuto());
		autoChooser.addObject("Pull One Tote", new OneToteAuto());
		autoChooser.addObject("Pull One Bin (quick)", new QuickBinAuto());
		autoChooser.addObject("Pull One Bin and One Tote", new ToteBinAuto());
		autoChooser.addObject("Strafe Autonomous", new StrafeAuto());
		autoChooser.addObject("Stack Bin on Tote and Drag", new StackToteBinAutoOne());
		//put the autoChooser on the SmartDashboard
		SmartDashboard.putData("Auto Mode", autoChooser);
    }
	
    public void disabledInit(){
    }
    
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	robotType = (int) robotChooser.getSelected();
    	drive.setRobotType(robotType);
    	elevator.setRobotType(robotType);
    	//run the CommandGroup that was selected in the SmartDashboard
    	autoMode = (CommandGroup) autoChooser.getSelected();
    	autoMode.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	sensors.resetGyro();
    	robotType = (int) robotChooser.getSelected();
    	drive.setRobotType(robotType);
    	elevator.setRobotType(robotType);
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public void printAll() {
    	drive.printAll();
    	System.out.println("Elevator Height: " + elevator.getHeight());
    	System.out.println();
    }
}
