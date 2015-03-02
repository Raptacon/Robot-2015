package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.Robot;
import org.usfirst.frc.team3200.robot.RobotMap;
import org.usfirst.frc.team3200.robot.commands.MoveElevatorControlled;

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
	private double ELEVATOR_SPEED = 1;
	
	//number of encoder pulses per full elevator height
	private final double HEIGHT_PER_PULSE_TEST = 0.000532765;
	private final double HEIGHT_PER_PULSE_COMP = 0.000532765; //TODO change to actual distance
	
	private Encoder elevatorEncoder;
	
	public Elevator() {
		super("Elevator");
		
		winch1 = new CANTalon(RobotMap.ELEVATOR_WINCH_1);
		winch2 = new CANTalon(RobotMap.ELEVATOR_WINCH_2);

		elevatorEncoder = new Encoder(RobotMap.ELEVATOR_ENCODER_A, RobotMap.ELEVATOR_ENCODER_B);
		elevatorEncoder.setDistancePerPulse(HEIGHT_PER_PULSE_TEST);
	}
    
	public void moveElevator(double speed) {
    	winch1.set(-speed);
    	winch2.set(-speed);
	}
	
    public void moveElevator(Joystick controller) {
    	double upVal = controller.getRawAxis(RobotMap.RIGHT_TRIGGER)*ELEVATOR_SPEED;
    	double downVal = -controller.getRawAxis(RobotMap.LEFT_TRIGGER)*ELEVATOR_SPEED;
    	
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

    public void initDefaultCommand(){
    	setDefaultCommand(new MoveElevatorControlled());
    }
}

