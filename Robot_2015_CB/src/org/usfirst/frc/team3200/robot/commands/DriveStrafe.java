package org.usfirst.frc.team3200.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3200.robot.Robot;

public class DriveStrafe extends Command {
	//motor speed (-1.0 to 1.0)
	double speed;
	
	//number of meters to drive
	double goal;
	
    public DriveStrafe(double goal, double speed) {
    	super("DriveStrafe");
        requires(Robot.drive);
        this.goal = goal;
        this.speed = speed * Math.signum(goal);
        setTimeout(10);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//reset encoders to begin distance measurement from 0
    	Robot.drive.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//drive forward at specified speed
    	Robot.drive.mecanumDrive((float)speed, 0, 0);
    }

    //finishes when time is up or the correct distance has been reached
    protected boolean isFinished() {
        return (Math.abs(Robot.drive.getXDistance()) >= Math.abs(goal) || isTimedOut());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
