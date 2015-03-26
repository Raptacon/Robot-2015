package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Hook extends Subsystem {
    
    private Solenoid hook;
    
    public Hook() {
    	super("Hook");
    	
    	hook = new Solenoid(RobotMap.HOOK_SOLE);
    }
    
    public void extendHook() {
    	hook.set(true);
    }
    
    public void retractHook() {
    	hook.set(false);
    }
    
    public boolean isExtended() {
    	return hook.get();
    }

    public void initDefaultCommand() {
    }
}

