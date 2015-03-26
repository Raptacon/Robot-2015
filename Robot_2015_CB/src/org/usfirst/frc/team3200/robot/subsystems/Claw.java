package org.usfirst.frc.team3200.robot.subsystems;


import org.usfirst.frc.team3200.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
    //declare claw solenoid (controls claw pistons)
    private Solenoid claw;
    
    public Claw(){
    	super("Pneumatics");
    	//initialize solenoid with specified PCM port
        claw = new Solenoid(RobotMap.CLAW_SOLE);
    }
    
    //set both pistons to retracted state: \_/
    public void openClaw(){

        claw.set(true);
    }
    
    //set both pistons to extended state: /_\
    public void closeClaw(){
        claw.set(false);
    }    
    
    //Returns whether or not the claw is open.
    public boolean isClawOpen(){
    	return claw.get();
    }

    //no default command for claw
    public void initDefaultCommand() {
    }
}

