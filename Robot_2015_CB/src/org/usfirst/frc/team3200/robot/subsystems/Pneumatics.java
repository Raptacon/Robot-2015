package org.usfirst.frc.team3200.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
    //declare solenoids (controls sets of pistons)
    private DoubleSolenoid claw;
    private Solenoid clawLifter;
    private Solenoid dumpLifter;
    
    public Pneumatics(){
    	//initialize solenoids with specified PCM ports
        claw = new DoubleSolenoid(0, 1);
        clawLifter = new Solenoid(2);
        dumpLifter = new Solenoid(3);
    }
    
    //set both pistons to retracted state: \_/
    public void openClaw(){
        claw.set(DoubleSolenoid.Value.kReverse);
    }
    
    //set both pistons to extended state: /_\
    public void closeClaw(){
        claw.set(DoubleSolenoid.Value.kForward);
    }
    
    //extend dump pistons
    public void raiseDump(){
        dumpLifter.set(false);
    }
    
    //release dump pistons
    public void lowerDump(){
        dumpLifter.set(true);
    }
    
    //extend claw pistons
    public void raiseClaw(){
        clawLifter.set(true);
    }
    
    //release claw pistons
    public void lowerClaw(){
        clawLifter.set(false);
    }

    //no default command for pneumatics
    public void initDefaultCommand() {
    }
}

