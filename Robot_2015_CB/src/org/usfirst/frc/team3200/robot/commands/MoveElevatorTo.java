package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveElevatorTo extends Command {
	double speed;
	double goal;
	
	int direction;

    public MoveElevatorTo(double goal, double speed) {
    	super("MoveElevatorTo");
        requires(Robot.elevator);
        this.speed = speed;
        this.goal = goal;
        setTimeout(5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(goal >= Robot.elevator.getHeight()) {
    		direction = 1;
    	} else {
    		direction = -1;
    	}
    	
    	speed *= direction;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.moveElevator(speed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((direction == -1 && Robot.elevator.getHeight() <= goal)  ||
                (direction ==  1 && Robot.elevator.getHeight() >= goal)) ||
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
