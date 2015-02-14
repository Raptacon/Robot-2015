package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ToggleClaw extends Command {
	
    public ToggleClaw() {
    	super("CloseClaw");
        requires(Robot.pistons);
     //   requires(Robot.sensors);
    }

 // Called just before this Command runs the first time
    protected void initialize() {
//        try {
//			System.out.print("LiDAR ");
//			System.out.println(Robot.sensors.getDistanceLIDAR());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	if (Robot.pistons.isClawOpen()) Robot.pistons.closeClaw(); // If the claw is open, close it.
        else Robot.pistons.openClaw(); // Otherwise open it.
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

}
