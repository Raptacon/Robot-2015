package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.RobotMap;
import org.usfirst.frc.team3200.robot.commands.MoveElevator;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	private CANTalon winch;
	
	public Elevator() {
		super("Elevator");
		
		winch = new CANTalon(10);
	}
    
    public void moveElevator(Joystick controller) {
    	double upVal = controller.getRawAxis(RobotMap.RIGHT_TRIGGER);
    	double downVal = -controller.getRawAxis(RobotMap.LEFT_TRIGGER);
    	winch.set(upVal + downVal);
    }

    public void initDefaultCommand(){
    	setDefaultCommand(new MoveElevator());
    }
}

