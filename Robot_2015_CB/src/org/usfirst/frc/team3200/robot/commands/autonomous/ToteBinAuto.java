package org.usfirst.frc.team3200.robot.commands.autonomous;

import org.usfirst.frc.team3200.robot.commands.*;
import org.usfirst.frc.team3200.robot.commands.Claw.OpenClaw;
import org.usfirst.frc.team3200.robot.commands.DriveTrain.DriveStraight;
import org.usfirst.frc.team3200.robot.commands.DriveTrain.Rotate;
import org.usfirst.frc.team3200.robot.commands.Elevator.MoveElevatorBy;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ToteBinAuto extends CommandGroup {
    
    public  ToteBinAuto() {
    	addSequential(new OpenClaw());
    	addSequential(new Wait(1.5));
        addSequential(new DriveStraight(0.1, 0.25));
        addSequential(new MoveElevatorBy(1, 0.5));
        addSequential(new DriveStraight(-2.5, 0.5));
        addSequential(new Rotate(90, 0.25));
    }
}
