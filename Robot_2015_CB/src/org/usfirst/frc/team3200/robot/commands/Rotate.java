package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Rotate extends Command {
	private double speed;
	private double goal;
	private double gyroStart;
	
	int direction;

    public Rotate(double goal, double speed) {
    	super("Rotate");
        requires(Robot.drive);
        requires(Robot.sensors);
        this.goal = goal;
        this.speed = speed * Math.signum(goal);
        setTimeout(5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	gyroStart = Robot.sensors.getGyroAngle();
    	direction = (int)Math.signum(goal);
    	speed *= direction;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.mecanumDrive(0, 0, (float)speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return(direction ==  1 && Robot.sensors.getGyroAngle() >= gyroStart + goal) ||
  	          (direction == -1 && Robot.sensors.getGyroAngle() <= gyroStart + goal) || 
  	          (isTimedOut());
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