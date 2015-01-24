package org.usfirst.frc.team3200.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
    
    private DoubleSolenoid claw;
    private Solenoid clawLifter;
    private Solenoid dumpLifter;
    
    public Pneumatics(){
        claw = new DoubleSolenoid(0, 1);
        clawLifter = new Solenoid(2);
        dumpLifter = new Solenoid(3);
    }
    
    public void openClaw(){
        claw.set(DoubleSolenoid.Value.kReverse);
    }
    public void closeClaw(){
        claw.set(DoubleSolenoid.Value.kForward);
    }
    public void raiseDump(){
        dumpLifter.set(false);
    }
    public void lowerDump(){
        dumpLifter.set(true);
    }
    public void raiseClaw(){
        clawLifter.set(true);
    }
    public void lowerClaw(){
        clawLifter.set(false);
    }

    public void initDefaultCommand() {
    }
}

