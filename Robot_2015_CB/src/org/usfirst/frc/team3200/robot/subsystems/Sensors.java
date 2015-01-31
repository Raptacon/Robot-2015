package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.misc.LiDAR;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Sensors extends Subsystem{
	
	LiDAR lD = new LiDAR(0x62);
	Gyro gyro = new Gyro(0);
	
	private double rotation;
	
	//volts per degree per second
	private static double V_PER_DEG_S = .007;
	
	//10 ms per tick of the system
	private static double SYS_TICK = .01; //s
	
	//minimum rotation speed to be considered.
	private static double MIN_ROT_SPEED = 1; // deg/s
	
	public Sensors() {
		super("Sensors");
		
		gyro.initGyro();
		gyro.setSensitivity(V_PER_DEG_S);
		
	}
	
	public void resetGyro(){
		gyro.reset();
		rotation = 0;
	}
	public double getAnglePerSecond(){
		if(Math.abs(gyro.getRate()) < MIN_ROT_SPEED){
			return 0;
	}
		return gyro.getRate();
	}
	
	public double getGyroAngle(){
		
		rotation += getAnglePerSecond() * SYS_TICK;
		return rotation;
//		return gyro.getAngle();
	}

	@Override
	protected void initDefaultCommand() {}

}
