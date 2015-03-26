package org.usfirst.frc.team3200.robot.commands.autonomous;

import org.usfirst.frc.team3200.robot.commands.*;
import org.usfirst.frc.team3200.robot.commands.Claw.CloseClaw;
import org.usfirst.frc.team3200.robot.commands.Claw.OpenClaw;
import org.usfirst.frc.team3200.robot.commands.DriveTrain.DriveStrafe;
import org.usfirst.frc.team3200.robot.commands.DriveTrain.DriveStraight;
import org.usfirst.frc.team3200.robot.commands.DriveTrain.Rotate;
import org.usfirst.frc.team3200.robot.commands.Elevator.MoveElevatorBy;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestAuto extends CommandGroup {
	
    public  TestAuto() {
    	addSequential(new OpenClaw());
    	addSequential(new Wait(2));
    	addSequential(new CloseClaw());
    	addSequential(new MoveElevatorBy(0.5, 0.5));
    	addSequential(new MoveElevatorBy(-0.5, 0.5));
    	addSequential(new DriveStraight(1, 0.5));
    	addSequential(new DriveStrafe(1, 0.5));
    	addSequential(new DriveStraight(-1, 0.5));
    	addSequential(new DriveStrafe(-1, 0.5));
    	addSequential(new Rotate(90, 0.5));
    	addSequential(new Rotate(-90, 0.5));
    }
}