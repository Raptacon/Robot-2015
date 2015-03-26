package org.usfirst.frc.team3200.robot.commands.autonomous;

import org.usfirst.frc.team3200.robot.commands.*;
import org.usfirst.frc.team3200.robot.commands.Claw.CloseClaw;
import org.usfirst.frc.team3200.robot.commands.Claw.OpenClaw;
import org.usfirst.frc.team3200.robot.commands.DriveTrain.DriveStrafe;
import org.usfirst.frc.team3200.robot.commands.DriveTrain.DriveStraight;
import org.usfirst.frc.team3200.robot.commands.Elevator.MoveElevatorBy;

import edu.wpi.first.wpilibj.command.CommandGroup;
public class ToteBinStackAuto extends CommandGroup{
	/*
	 * Start 1 inch away from touching the recycling bin.
	 * Start centered in front of the recycling bin.
	 */
	public ToteBinStackAuto()
	{
		/*
		 * This code stacks the recycling bin onto the tote and then
		 * 		drags them back to the autonomous zone.
		 * Steps to do this
		 * ---------------------------------------------------------
		 * 1. Reset code
		 * 2. Open the Claw
		 * 3. Move forward into the Bin
		 * 4. Close Claw.
		 * 5. Move Bin on top of Tote.
		 * 6. Move them back.
		 */
//		addSequential(new MoveElevatorTo(0.4572, 0.25));
//		addSequential(new OpenClaw());
//		addSequential(new DriveStraight(0.3302, 0.5));
//		addSequential(new CloseClaw());
//		addSequential(new MoveElevatorTo(0.9146, 0.25));
//		addSequential(new DriveStrafe(-0.57, 0.25));
//		addSequential(new OpenClaw());
//		addSequential(new DriveStraight(-0.4, 0.5));
//		addSequential(new ResetElevator());
//		addSequential(new DriveStraight(0.1524, 0.175));
//		addSequential(new CloseClaw());
//		addSequential(new MoveElevatorTo(0.5, 0.25));
//		addSequential(new DriveStraight(-2.75, 0.45));
//		addParallel(new Rotate(90, 0.25));
//		addSequential(new ResetElevator());
//		addSequential(new OpenClaw());
		
		addSequential(new OpenClaw());
		addSequential(new Wait(1));
		addSequential(new DriveStraight(0.6, 0.5));
		addSequential(new CloseClaw());
		addSequential(new Wait(1));
		addSequential(new MoveElevatorBy(0.4, 0.5));
		addSequential(new DriveStrafe(-0.9, 0.5));
		addSequential(new MoveElevatorBy(-0.1, 0.5));
		addSequential(new OpenClaw());
		addSequential(new DriveStraight(-0.7, 0.5));
		addSequential(new CloseClaw());
		addSequential(new MoveElevatorBy(-1, 0.5));
		addSequential(new DriveStraight(0.1, 0.5));
		addSequential(new MoveElevatorBy(0.1, 0.5));
		addSequential(new DriveStraight(-2.5, 0.5));
		
	}
}
