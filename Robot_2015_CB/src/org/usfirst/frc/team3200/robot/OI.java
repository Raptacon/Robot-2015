package org.usfirst.frc.team3200.robot;

import org.usfirst.frc.team3200.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	
    public Joystick controller = new Joystick(RobotMap.XBOX1);
    
    public Button buttonA = new JoystickButton(controller, RobotMap.BUTTON_A);
    public Button buttonB = new JoystickButton(controller, RobotMap.BUTTON_B);
    public Button buttonX = new JoystickButton(controller, RobotMap.BUTTON_X);
    public Button buttonY = new JoystickButton(controller, RobotMap.BUTTON_Y);
    public Button bumperR = new JoystickButton(controller, RobotMap.RIGHT_BUMPER);
    public Button bumperL = new JoystickButton(controller, RobotMap.LEFT_BUMPER);
    
    public OI() {
        buttonA.whenPressed(new OpenClaw());
        buttonB.whenPressed(new CloseClaw());
        buttonX.whenPressed(new LowerClaw());
        buttonY.whenPressed(new RaiseClaw());
        bumperR.whenPressed(new RaiseDump());
        bumperL.whenPressed(new LowerDump());
        
    }
    
    public Joystick getController() {
        return controller;
    }
}

