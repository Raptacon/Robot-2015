package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveElevatorBy extends Command {
	double speed;
	double goal;
	double startHeight;
	int direction;

    public MoveElevatorBy(double goal, double speed) {
    	super("MoveElevatorBy");
        requires(Robot.elevator);
        this.speed = speed;
        this.goal = goal;
        setTimeout(5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startHeight = Robot.elevator.getHeight();
    	direction = (int)Math.signum(goal);
    	speed *= direction;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.moveElevator(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return(direction ==  1 && Robot.elevator.getHeight() >= startHeight + goal) ||
        	  (direction == -1 && Robot.elevator.getHeight() <= startHeight + goal) || 
        	  (isTimedOut());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.moveElevator(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevator.moveElevator(0);
    }
}
