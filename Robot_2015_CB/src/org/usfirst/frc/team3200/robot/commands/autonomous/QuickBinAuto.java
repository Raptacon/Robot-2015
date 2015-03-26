package org.usfirst.frc.team3200.robot.commands.autonomous;

import org.usfirst.frc.team3200.robot.commands.*;
import org.usfirst.frc.team3200.robot.commands.Claw.CloseClaw;
import org.usfirst.frc.team3200.robot.commands.Claw.OpenClaw;
import org.usfirst.frc.team3200.robot.commands.DriveTrain.DriveStraight;
import org.usfirst.frc.team3200.robot.commands.DriveTrain.Rotate;
import org.usfirst.frc.team3200.robot.commands.Elevator.MoveElevatorBy;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class QuickBinAuto extends CommandGroup {
    
    public  QuickBinAuto() {
        addSequential(new OpenClaw());
        addSequential(new Wait(1));
        addSequential(new MoveElevatorBy(-0.5, 0.5));
        addSequential(new CloseClaw());
        addSequential(new Wait(1));
        addParallel(new MoveElevatorBy(0.5, 0.5));
        addSequential(new DriveStraight(-2.5, 0.5));
        addSequential(new Rotate(90, 0.5));
    }
}
