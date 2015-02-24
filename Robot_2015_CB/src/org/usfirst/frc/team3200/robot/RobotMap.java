package org.usfirst.frc.team3200.robot;
/*
 * This is a "Map" for all the RoboRio ports, Controller buttons,
 * and other pieces of hardware
 */
public class RobotMap {
	//Robot being driven
	public static final int TEST_BOT = 0;
	public static final int COMP_BOT = 0;
	
	//Talons
	public static final int FRONT_LEFT = 0;
	public static final int BACK_LEFT = 1;
	public static final int FRONT_RIGHT = 3;
	public static final int BACK_RIGHT = 2;
	
	//Controllers
	public static final int XBOX1 = 0;
	public static final int XBOX2 = 1;
	
	//Controller Axes
	public static final int LEFT_STICK_X = 0;
	public static final int LEFT_STICK_Y = 1;
	public static final int LEFT_TRIGGER = 2;
	public static final int RIGHT_TRIGGER = 3;
	public static final int RIGHT_STICK_X = 4;
	public static final int RIGHT_STICK_Y = 5;
	
	
	//Controller Buttons
	public static final int BUTTON_A = 1;
	public static final int BUTTON_B = 2;
	public static final int BUTTON_X = 3;
	public static final int BUTTON_Y = 4;
	public static final int RIGHT_BUMPER = 5;
	public static final int LEFT_BUMPER = 6;
	public static final int BUTTON_SELECT = 7;
	public static final int BUTTON_START = 8;
	public static final int BUTTON_LEFT_JOYSTICK = 9;
	public static final int BUTTON_RIGHT_JOYSTICK = 10;
	
	//Encoders
	public static final int FL_ENCODER_A = 0;
	public static final int FL_ENCODER_B = 1;
	public static final int BL_ENCODER_A = 2;
	public static final int BL_ENCODER_B = 3;
	public static final int FR_ENCODER_A = 4;
	public static final int FR_ENCODER_B = 5;
	public static final int BR_ENCODER_A = 6;
	public static final int BR_ENCODER_B = 7;
	public static final int ELEVATOR_ENCODER_A = 8;
	public static final int ELEVATOR_ENCODER_B = 9;
	
	//Solenoids
	public static final int CLAW_SOLE_OPEN = 0;
	public static final int CLAW_SOLE_CLOSE = 1;
	public static final int CLAW_SOLE_LIFT = 2;
	public static final int DUMP_SOLE_LIFT = 3;
	
	//Elevator
	public static final int ELEVATOR_WINCH_1 = 10; // CAN Port for the 1st winch.
	public static final int ELEVATOR_WINCH_2 = 11; // CAN Port for the 2nd winch.
	public static final int ELEVATOR_UPPER_LIMIT = 9; // Digital IO slot for the upper limit switch.
	public static final int ELEVATOR_LOWER_LIMIT = 8; // Digital IO slot for the lower limit switch.
	
	
}
