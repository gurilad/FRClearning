package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class intakeArm extends SubsystemBase {
    private DigitalInput openedMs;
    private DigitalInput closedMs;
    private VictorSP arm;

    public enum state {
        OPEN,
        CLOSED,
        INTERMEDIATE
    }

    public intakeArm() {
        openedMs = new DigitalInput(2);
        closedMs = new DigitalInput(3);
        arm = new VictorSP(1);
    }

    @Override
    public void periodic() {
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }

    public state getState() {
        if (openedMs.get()) {
            return state.OPEN;
        } else if (closedMs.get()) {
            return state.CLOSED;
        } else {
            return state.INTERMEDIATE;
        }

    }
    public void zeroMotor(){
        arm.set(0);
    }

    public void setState(state _state){
        if(_state == getState()){
            return;
        }
        switch(_state){
            case OPEN:
                arm.set(-1);
                break;
            case CLOSED:
                arm.set(1);
                break;
            default:
                break;
        }


    }
    

}
