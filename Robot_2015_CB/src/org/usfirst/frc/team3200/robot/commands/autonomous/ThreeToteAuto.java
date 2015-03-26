package org.usfirst.frc.team3200.robot.commands.autonomous;

import org.usfirst.frc.team3200.robot.commands.*;
import org.usfirst.frc.team3200.robot.commands.Claw.CloseClaw;
import org.usfirst.frc.team3200.robot.commands.Claw.OpenClaw;
import org.usfirst.frc.team3200.robot.commands.DriveTrain.DriveStrafe;
import org.usfirst.frc.team3200.robot.commands.DriveTrain.DriveStraight;
import org.usfirst.frc.team3200.robot.commands.Elevator.MoveElevatorBy;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ThreeToteAuto extends CommandGroup {
    
    public  ThreeToteAuto() {
    	
    	//strafe into bin, prepare to grab first tote
    	addSequential(new OpenClaw());
        addSequential(new DriveStrafe(0.5, 0.5));
        addSequential(new MoveElevatorBy(-0.2, 0.5));
        addSequential(new CloseClaw());
        addSequential(new Wait(1));
        
        //raise elevator and move to next tote
        addSequential(new MoveElevatorBy(0.4, 0.5));
        addSequential(new DriveStrafe(-0.5, 0.5));
        addSequential(new DriveStraight(1.32, 0.5));
        
        //repeat strafing into bin and grabbing tote
        addSequential(new DriveStrafe(0.5, 0.5));
        addSequential(new OpenClaw());
        addSequential(new Wait(1));
        addSequential(new MoveElevatorBy(-0.34, 0.5));
        addSequential(new CloseClaw());
        addSequential(new Wait(1));
        
        //move to next tote
        addSequential(new MoveElevatorBy(0.5, 0.5));
        addSequential(new DriveStrafe(-0.5, 0.5));
        addSequential(new DriveStraight(1.32, 0.5));
        
        //repeat
        addSequential(new DriveStrafe(0.5, 0.5));
        addSequential(new OpenClaw());
        addSequential(new Wait(1));
        addSequential(new MoveElevatorBy(-0.34, 0.5));
        addSequential(new CloseClaw());
        addSequential(new Wait(1));
        
        //raise elevator a little and move to auto zone
        addSequential(new MoveElevatorBy(0.2, 0.5));
        addSequential(new DriveStrafe(-3.2, 0.5));
    }
}