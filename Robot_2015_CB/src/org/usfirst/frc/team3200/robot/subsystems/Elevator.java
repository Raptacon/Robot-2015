package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.RobotMap;
import org.usfirst.frc.team3200.robot.commands.MoveElevator;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	private CANTalon winch1, winch2;
	private DigitalInput upperLimit, lowerLimit;
	private double EVELATOR_SPEED = .85;
	
	public Elevator() {
		super("Elevator");
		
		winch1 = new CANTalon(RobotMap.ELEVATOR_WINCH_1);
		winch2 = new CANTalon(RobotMap.ELEVATOR_WINCH_2);
		upperLimit = new DigitalInput(RobotMap.ELEVATOR_UPPER_LIMIT);
		lowerLimit = new DigitalInput(RobotMap.ELEVATOR_LOWER_LIMIT);
	}
    
    public void moveElevator(Joystick controller) {
    	double upVal = controller.getRawAxis(RobotMap.LEFT_TRIGGER)*EVELATOR_SPEED;
    	double downVal = -controller.getRawAxis(RobotMap.RIGHT_TRIGGER)*EVELATOR_SPEED;
    	
    	double speed = upVal + downVal;
    	
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
    	//System.out.println(speed);
    }

    public void initDefaultCommand(){
    	setDefaultCommand(new MoveElevator());
    }
}

