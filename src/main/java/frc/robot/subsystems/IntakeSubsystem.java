package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;



import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{
    
    private final CANSparkMax intakeMotor;
    private final WPI_TalonSRX dustpanMotor; 
    private double speed;



    public IntakeSubsystem() {
        intakeMotor = new CANSparkMax(0, MotorType.kBrushless);
        dustpanMotor = new WPI_TalonSRX(0);
        
    }

    public void SetIntakeSpeed(double speed){
        this.speed = speed;
    }
    
    @Override
    public void periodic() {
       intakeMotor.set(speed);
       dustpanMotor.set(speed);
    }
    

}