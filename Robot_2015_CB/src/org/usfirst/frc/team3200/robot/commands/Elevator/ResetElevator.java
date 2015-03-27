package org.usfirst.frc.team3200.robot.commands.Elevator;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetElevator extends Command{
	
	public ResetElevator(){
		super("ResetElevator");
		requires(Robot.elevator);
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		//move the elevator at the specified speed
		Robot.elevator.moveElevator(-0.5);
	}

	@Override
	protected boolean isFinished() {
		return Robot.elevator.getLowerLimit();
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
