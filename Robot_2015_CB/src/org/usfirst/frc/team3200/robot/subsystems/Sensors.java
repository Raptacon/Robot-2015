package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.misc.LiDAR;

import edu.wpi.first.wpilibj.DigitalModule;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Sensors extends Subsystem{
	LiDAR lD = new LiDAR(DigitalModule.kPwmChannels, 0x62);
	
	
	@Override
	protected void initDefaultCommand() {}

}