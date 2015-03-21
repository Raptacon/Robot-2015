package org.usfirst.frc.team3200.robot.commands.autonomous;

import org.usfirst.frc.team3200.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ThreeToteAuto extends CommandGroup {
    
    public  ThreeToteAuto() {
    	/*
    	 * STARTING POSITION: (start with leftmost tote)
    	 * 
    	 *       --TOP--                --SIDE--
    	 * 
    	 *          +-----+                    +-+       
    	 *          |     |                    | |       
    	 *    /|\   |TOTE |                   || |       
    	 *   // \\  |     |                   || |       
    	 *  //   \\ +-----+           ________|| |
    	 *  +-----+  .---.           |________|| |\  (bin behind)
    	 *  |     | | BIN |      ============  | |\\
    	 *  | BOT |  .___.       |          |  | | \\
    	 *  |     |              |  TOTE    |  |_|__\\________
    	 *  +-----+              |__________|  |_____BOT______|
    	 */
    	
    	
    	//CHANGE DISTANCES AND SPEEDS AS NEEDED. It is probably to slow to finish within 15 seconds right now
    	
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