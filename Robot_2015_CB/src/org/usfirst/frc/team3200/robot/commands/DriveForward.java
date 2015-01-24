package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command {
	//number of meters to drive
	double goal;
	
    public DriveForward(double goal) {
    	super("DriveTo");
        requires(Robot.drive);
        setTimeout(5);
        this.goal = goal;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//reset encoders to begin distance measurement from 0
    	Robot.drive.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//drive forward at full speed
    	Robot.drive.mecanumDrive(0, 1, 0);
    }

    //finishes when time is up or the correct distance has been reached
    protected boolean isFinished() {
        return (Robot.drive.getDistance() >= goal || isTimedOut());
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
