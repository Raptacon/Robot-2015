package org.usfirst.frc.team3200.robot.commands.autonomous;

import org.usfirst.frc.team3200.robot.commands.*;
import org.usfirst.frc.team3200.robot.commands.DriveTrain.DriveStraight;
import org.usfirst.frc.team3200.robot.commands.DriveTrain.Rotate;
import org.usfirst.frc.team3200.robot.commands.Elevator.MoveElevatorBy;
import org.usfirst.frc.team3200.robot.commands.Elevator.MoveElevatorTo;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OneToteAuto extends CommandGroup {
    
    public  OneToteAuto() {
    	addSequential(new DriveStraight(0.1, 0.25));
        addSequential(new MoveElevatorBy(0.5, 0.5));
        addSequential(new DriveStraight(-2.5, 0.5));
        addSequential(new Rotate(90, 0.25));
        addSequential(new MoveElevatorTo(-1, 1));
//        addSequential(new DriveStraight(-0.0625, 0.125));
    }
}
