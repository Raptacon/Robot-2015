package org.usfirst.frc.team3200.robot.commands.autonomous;

import org.usfirst.frc.team3200.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveForwardAuto extends CommandGroup {
    
    public  DriveForwardAuto() {
    	addSequential(new DriveStraight(2.5, 0.5));
    	addSequential(new Rotate(90, 0.5));
    }
}
