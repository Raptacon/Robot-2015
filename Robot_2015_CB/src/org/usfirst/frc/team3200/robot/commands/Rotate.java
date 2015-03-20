package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class Rotate extends Command {
	private final double DEG_PER_SEC = 132;
	private double degPerSec;
	
	private double speed;
	private double goal;
	private double gyroStart;
	private double startTime;
	
	int direction;

    public Rotate(double goal, double speed) {
    	super("Rotate");
        requires(Robot.drive);
        requires(Robot.sensors);
        this.goal = goal;
        this.speed = speed;
//        degPerSec = DEG_PER_SEC * speed;
        direction = (int)Math.signum(goal);
    	this.speed *= direction;
        setTimeout(5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	gyroStart = Robot.sensors.getGyroAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.mecanumDrive(0, 0, (float)speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//    	return(direction ==  1 && Robot.sensors.getGyroAngle() >= gyroStart + goal) ||
//  	          (direction == -1 && Robot.sensors.getGyroAngle() <= gyroStart + goal) || 
//  	          (isTimedOut());
    	
    	return (Math.abs(Robot.sensors.getGyroAngle() - gyroStart) >= Math.abs(goal) || isTimedOut());
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
