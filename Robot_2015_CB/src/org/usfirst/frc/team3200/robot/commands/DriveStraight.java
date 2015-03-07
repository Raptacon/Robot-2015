package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {
	//motor speed (-1.0 to 1.0)
	double speed;
	
	//number of meters to drive
	double goal;
	
    public DriveStraight(double goal, double speed) {
    	super("DriveForward");
        requires(Robot.drive);
        this.goal = goal;
        
        //speed is given the sign of the goal
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
    	Robot.drive.mecanumDrive(0, (float)speed, 0);
    }

    //finishes when time is up or the correct distance has been reached
    protected boolean isFinished() {
    	//returns true if robot is at or past the goal
        return (Math.abs(Robot.drive.getYDistance()) >= Math.abs(goal) || isTimedOut());
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
