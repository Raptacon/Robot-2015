package org.usfirst.frc.team3200.robot.commands.autonomous;

import org.usfirst.frc.team3200.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveGrabAuto extends CommandGroup {
    
    public  DriveGrabAuto() {
    	addSequential(new OpenClaw());
    	addSequential(new DriveStraight(.25, .5));
    	addSequential(new CloseClaw());
    	addSequential(new DriveStraight(-.25, -.25));
    }
}
