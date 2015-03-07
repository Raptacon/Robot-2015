package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.Robot;
import org.usfirst.frc.team3200.robot.RobotMap;
import org.usfirst.frc.team3200.robot.commands.MoveElevatorControlled;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	//declare CANTalons to control elevator motors
	private CANTalon winch1;
	private CANTalon winch2;
	
	//Declare Encoder used to measure elevator height
	private Encoder elevatorEncoder;
	
	//number of encoder pulses per full elevator height
	private final double HEIGHT_PER_PULSE_TEST = 0.0071923; //m
	private final double HEIGHT_PER_PULSE_COMP = 0.0071923; //TODO change to actual value
	
	//variable to be set to value based on robot being driven
	private double heightPerPulse;
	
	public Elevator() {
		super("Elevator");
		
		//set height per pulse based on robot being driven
		if(Robot.robotType == RobotMap.TEST_BOT) {
			heightPerPulse = HEIGHT_PER_PULSE_TEST;
		} else {
			heightPerPulse = HEIGHT_PER_PULSE_COMP;
		}
		
		//
		winch1 = new CANTalon(RobotMap.ELEVATOR_WINCH_1);
		winch2 = new CANTalon(RobotMap.ELEVATOR_WINCH_2);

		elevatorEncoder = new Encoder(RobotMap.ELEVATOR_ENCODER_A, RobotMap.ELEVATOR_ENCODER_B);
		
		elevatorEncoder.setDistancePerPulse(heightPerPulse);
	}
    
	public void moveElevator(double speed) {
    	winch1.set(-speed);
    	winch2.set(-speed);
	}
	
    public void moveElevator(Joystick controller) {
    	double upVal = controller.getRawAxis(RobotMap.RIGHT_TRIGGER);
    	double downVal = -controller.getRawAxis(RobotMap.LEFT_TRIGGER);
    	
    	double speed = upVal + downVal;
    	
    	//makes speed change exponentially
    	speed *= Math.abs(speed);
    	
    	if(Robot.oi.buttonY.get()) {
    		speed *= 0.5;
    	}
    	
    	moveElevator(speed);
    }
    
    public void resetEncoder() {
    	elevatorEncoder.reset();
    }
    
    public double getHeight() {
    	return elevatorEncoder.getDistance();
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new MoveElevatorControlled());
    }
}

