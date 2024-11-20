package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.SparkPIDController;
import edu.wpi.first.wpilibj.DigitalInput;

public class ElevatorSubsystem extends SubsystemBase{
    private CANSparkMax leftelevator;
    private CANSparkMax rightelevator;
    private SparkPIDController elevatorpid;
    private DigitalInput limitSwitch;
    private RelativeEncoder encoder;

    public ElevatorSubsystem (){
        leftelevator = new CANSparkMax (2, MotorType.kBrushless);
        rightelevator = new CANSparkMax(3, MotorType.kBrushless);
        elevatorpid = leftelevator.getPIDController();
        limitSwitch = new DigitalInput (0);
        encoder = leftelevator.getEncoder();

        elevatorpid.setP(0);
        elevatorpid.setI(0);
        elevatorpid.setD(0);

        encoder.setPosition(0);
        encoder.setPositionConversionFactor(0);
        encoder.setVelocityConversionFactor(0);


        rightelevator.follow(leftelevator);
    }

    public void setElevatorState(double state){
    
        elevatorpid.setReference(state, CANSparkBase.ControlType.kPosition);
    } 

    public boolean atFloor(){
        return limitSwitch.get();
    }

    public double position(){
        return encoder.getPosition();
    }
}
