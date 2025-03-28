package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;



import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class IntakeSubsystem extends SubsystemBase{
    
    // private final CANSparkMax intakeMotor;
    private final WPI_TalonSRX dustpanMotor; 
    private double speed;



    public IntakeSubsystem() {
        dustpanMotor = new WPI_TalonSRX(OperatorConstants.dustpanMotor);
        
    }

    public void SetIntakeSpeed(double speed){
        this.speed = speed;
    }
    
    @Override
    public void periodic() {
       dustpanMotor.set(speed);
    }
    

}