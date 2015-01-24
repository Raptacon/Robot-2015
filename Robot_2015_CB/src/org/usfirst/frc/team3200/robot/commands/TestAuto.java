package org.usfirst.frc.team3200.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestAuto extends CommandGroup {
    
    public  TestAuto() {
    	addSequential(new DriveTo(2));
    }
}
