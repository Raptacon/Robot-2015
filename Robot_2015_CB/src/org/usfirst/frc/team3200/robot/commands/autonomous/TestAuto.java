package org.usfirst.frc.team3200.robot.commands.autonomous;

import org.usfirst.frc.team3200.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestAuto extends CommandGroup {
	
    public  TestAuto() {
    	addSequential(new Rotate(90, 0.5));
//    	addSequential(new OpenClaw());
//    	addSequential(new ResetElevator());
//    	addSequential(new MoveElevatorTo(0.2, 0.5));
//    	addSequential(new CloseClaw());
//    	addSequential(new MoveElevatorTo(.25, 0.5));
//    	addSequential(new DriveStraight(-1.5, 0.25));
//    	addSequential(new MoveElevatorTo(0, 0.5));
//    	addSequential(new OpenClaw());
    }
    
}
