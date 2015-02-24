package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.Robot;
import org.usfirst.frc.team3200.robot.RobotMap;
import org.usfirst.frc.team3200.robot.commands.MoveElevator;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	private CANTalon winch1, winch2;
	private DigitalInput upperLimit, lowerLimit;
	private double ELEVATOR_SPEED = 1;
	
	//number of encoder pulses per full elevator height
	private final double HEIGHT_PER_PULSE_TEST = 0.000532765;
	
	private Encoder elevatorEncoder;
	
	public Elevator() {
		super("Elevator");
		
		winch1 = new CANTalon(RobotMap.ELEVATOR_WINCH_1);
		winch2 = new CANTalon(RobotMap.ELEVATOR_WINCH_2);
//		upperLimit = new DigitalInput(RobotMap.ELEVATOR_UPPER_LIMIT);
//		lowerLimit = new DigitalInput(RobotMap.ELEVATOR_LOWER_LIMIT);

		elevatorEncoder = new Encoder(RobotMap.ELEVATOR_ENCODER_A, RobotMap.ELEVATOR_ENCODER_B);
		elevatorEncoder.setDistancePerPulse(HEIGHT_PER_PULSE_TEST);
	}
    
    public void moveElevator(Joystick controller) {
    	double upVal = controller.getRawAxis(RobotMap.LEFT_TRIGGER)*ELEVATOR_SPEED;
    	double downVal = -controller.getRawAxis(RobotMap.RIGHT_TRIGGER)*ELEVATOR_SPEED;
    	
    	double speed = upVal + downVal;
    	
    	speed *= Math.abs(speed);
    	
    	if(Robot.oi.buttonY.get()) {
    		speed *= 0.5;
    	}
    	
    	//if (upVal != 0 || downVal != 0) System.out.println(String.format("%2f\t%2f\t%2f", upVal, downVal, speed));
    	
//    	if (upVal != 0 && downVal != 0){ // One shouldn't be able to push both at the same time.
//    		//While its easy to resolve the issues, no.
//    		System.out.println("ERROR: Cannot simultaneously move up and down. ");
//    		speed = 0;
//    	} else if (upVal != 0 && upperLimit.get()) { // No lifting beyond the upper limit.
//    		System.out.println("Upper limit reached.");
//    		speed = 0;
//    	} else if (downVal != 0 && lowerLimit.get()) { // No lifting beyond the lower limit either.
//    		System.out.println("Lower limit reached.");
//    		speed = 0;
//    	}
    	
    	winch1.set(speed);
    	winch2.set(speed);
    	System.out.println(elevatorEncoder.getDistance());
    }
    
    public void resetEncoder() {
    	elevatorEncoder.reset();
    }

    public void initDefaultCommand(){
    	setDefaultCommand(new MoveElevator());
    }
}

