package org.usfirst.frc.team3200.robot.commands.autonomous;

import org.usfirst.frc.team3200.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveForwardAuto extends CommandGroup {
    
    public  DriveForwardAuto() {
    	addSequential(new DriveStraight(1, .25));
    }
}
