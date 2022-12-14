package frc.robot.subsystems;



import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elivator extends SubsystemBase {
    
    VictorSP vic; 
    Encoder enc;
    public static enum vicStates {
        TOP,
        INTERMEDIATE,
        BOTTOM
    }
    
    
      

    public Elivator() {
        vic = new VictorSP(0);
        enc = new Encoder(0,1);
    }

    @Override
    public void periodic() {}
  
    @Override
    public void simulationPeriodic() {
      // This method will be called once per scheduler run during simulation
    }

    public void zeroMotor(){
        vic.set(0); //stops the motor completly
    }

    public void setState(vicStates state){
        if(state == getState()){
            return;
        }
        switch(state){
            case BOTTOM:
                vic.set(-1);
                break;
            case TOP:
                vic.set(1);
                break;
            default:
                break;
        }
        
        
    }

    public vicStates getState(){
        switch(enc.get()){
            case 0:
                return vicStates.BOTTOM;
            case 10:
                return vicStates.TOP;
            default:
                return vicStates.INTERMEDIATE;
                
        }
    }
      

}
