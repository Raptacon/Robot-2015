package org.usfirst.frc.team3200.misc;

import edu.wpi.first.wpilibj.I2C;

public class LiDAR extends I2C{
public final int DEVICEADDR = 0x62;
public final int INITRANGEVAL = 0x04;
public final int INITRANGE = 0x00;
public final int READHIGHLOW = 0x8f;

byte[] distanceArray = new byte[2];
byte nackack;

	public LiDAR(int deviceAddress) {
		super(Port.kMXP, deviceAddress);
	}
	
	public double getDistance() throws InterruptedException
	{
		this.write(INITRANGE, DEVICEADDR);
		//I2c.read(LIDARLite_ADDRESS,RegisterHighLowB, 2, distanceArray);
		Thread.sleep(1);
		this.read(READHIGHLOW, 2, distanceArray);
		Thread.sleep(1);
		double distance = (distanceArray[0] << 8) + distanceArray[1];
		return distance;
	}

}
