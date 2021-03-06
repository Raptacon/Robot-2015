package org.usfirst.frc.team3200.robot.commands.autonomous;

import org.usfirst.frc.team3200.robot.commands.*;
import org.usfirst.frc.team3200.robot.commands.Claw.CloseClaw;
import org.usfirst.frc.team3200.robot.commands.Claw.OpenClaw;
import org.usfirst.frc.team3200.robot.commands.DriveTrain.DriveStraight;
import org.usfirst.frc.team3200.robot.commands.DriveTrain.Rotate;
import org.usfirst.frc.team3200.robot.commands.Elevator.MoveElevatorBy;
import org.usfirst.frc.team3200.robot.commands.Elevator.MoveElevatorTo;
import org.usfirst.frc.team3200.robot.commands.Elevator.ResetElevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class OneBinAuto extends CommandGroup {
    
    public  OneBinAuto() {
    	addSequential(new DriveStraight(-0.1, 0.5));
    	addSequential(new ResetElevator());
    	addSequential(new OpenClaw());
    	addSequential(new MoveElevatorTo(0.1, 0.5));
    	addSequential(new DriveStraight(0.7, 0.5));
    	addSequential(new CloseClaw());
    	addParallel(new MoveElevatorBy(0.1, 0.5));
    	addSequential(new DriveStraight(-2.5, 0.5));
    	addSequential(new Rotate(90, 0.5));
    }
}
