package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveElevatorBy extends Command {
	//motor speed (-1.0 to 1.0)
	double velocity;
	
	//number of meters to move elevator
	double goal;
	
	//starting height of the elevator
	double startHeight;
	
	//direction that the elevator will move (1 = up, -1 = down)
	int direction;

    public MoveElevatorBy(double goal, double speed) {
    	super("MoveElevatorBy");
        requires(Robot.elevator);
        this.velocity = speed*Math.signum(goal);
        this.goal = goal;
        setTimeout(5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startHeight = Robot.elevator.getHeight();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//move the elevator at the specified speed
    	Robot.elevator.moveElevator(velocity);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//returns true if the elevator is at or past the goal
    	return (Math.abs(Robot.elevator.getHeight() - startHeight) >= Math.abs(goal) || isTimedOut());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.moveElevator(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
