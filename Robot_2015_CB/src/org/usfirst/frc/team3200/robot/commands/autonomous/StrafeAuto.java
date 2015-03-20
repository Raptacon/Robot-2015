package org.usfirst.frc.team3200.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team3200.robot.commands.*;


public class StrafeAuto extends CommandGroup{
	public StrafeAuto()
	{
		addSequential(new DriveStrafe(1.55, 0.5));
	}
}
