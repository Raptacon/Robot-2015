package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetElevator extends Command{

	public static double LOWER_DURATION = 1.2; //s
	
	public ResetElevator(){
		super("ResetElevator");
		requires(Robot.elevator);
		setTimeout(LOWER_DURATION);
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.elevator.moveElevator(-.5);
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		Robot.elevator.resetEncoder();
		Robot.elevator.moveElevator(0);
	}

	@Override
	protected void interrupted() {
		Robot.elevator.moveElevator(0);
	}

}
