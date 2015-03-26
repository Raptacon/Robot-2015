package org.usfirst.frc.team3200.robot.commands.Claw;

import org.usfirst.frc.team3200.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OpenClaw extends Command {
	
    public OpenClaw() {
    	super("OpenClaw");
        requires(Robot.claw);
    }

 // Called just before this Command runs the first time
    protected void initialize() {
         Robot.claw.openClaw();
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
