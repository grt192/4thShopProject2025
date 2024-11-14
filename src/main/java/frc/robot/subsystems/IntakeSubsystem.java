package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{
    private final WPI_TalonSRX bagMotor;
    private double speed;

    public IntakeSubsystem() {
        bagMotor = new WPI_TalonSRX(0);
       
    }

    public void setmotorspeed(double speed){
        this.speed=speed;
    }
    
    @Override
    public void periodic() {
       bagMotor.set(speed);
    }
    

}