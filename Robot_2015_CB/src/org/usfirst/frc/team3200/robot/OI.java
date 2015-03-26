package org.usfirst.frc.team3200.robot;

import org.usfirst.frc.team3200.robot.commands.Claw.ToggleClaw;
import org.usfirst.frc.team3200.robot.commands.Elevator.MoveElevatorBy;
import org.usfirst.frc.team3200.robot.commands.Hook.ToggleHook;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	
	//create a joystick to control the robot
	private Joystick controller1 = new Joystick(RobotMap.XBOX1);
	private Joystick controller2 = new Joystick(RobotMap.XBOX2); 
	
	//create buttons on the joystick
	private JoystickButton buttonA = new JoystickButton(controller1, RobotMap.BUTTON_A);
	private JoystickButton buttonY = new JoystickButton(controller1, RobotMap.BUTTON_Y);
	public JoystickButton buttonB = new JoystickButton(controller1, RobotMap.BUTTON_B);
	public JoystickButton bumperR = new JoystickButton(controller1, RobotMap.RIGHT_BUMPER);
	public JoystickButton bumperL = new JoystickButton(controller1, RobotMap.LEFT_BUMPER);
	
	
	public OI() {
		//assign buttons to commands
		buttonA.whenPressed(new ToggleClaw()); // When the A button is pressed on the XBox1, toggle the claw
		buttonY.whenPressed(new ToggleHook()); //When the Y button is pressed, toggle the hook
		bumperR.whenPressed(new MoveElevatorBy(-0.33, 0.75)); //Move the elevator up one tote
		bumperL.whenPressed(new MoveElevatorBy(0.33, 0.75)); //Move the elevator down one tote
    }

    //gets the controller; used to get joystick values
    public Joystick getController1() {
        return controller1;
    }
    
    public Joystick getController2() {
    	return controller2;
    }
}

