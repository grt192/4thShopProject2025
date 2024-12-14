package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.SparkPIDController;

import edu.wpi.first.math.proto.System;
import edu.wpi.first.wpilibj.DigitalInput;

public class ElevatorSubsystem extends SubsystemBase{
    private CANSparkMax leftelevator;
    private SparkPIDController elevatorpid;
    private DigitalInput limitSwitch;
    private RelativeEncoder encoder;



    public ElevatorSubsystem (){
        leftelevator = new CANSparkMax (OperatorConstants.leftelevator, MotorType.kBrushless);       
        elevatorpid = leftelevator.getPIDController();
        limitSwitch = new DigitalInput (OperatorConstants.limitSwitch);
        encoder = leftelevator.getEncoder();
        encoder.setPosition(0);

        elevatorpid.setP(OperatorConstants.elevatorP);
        elevatorpid.setI(OperatorConstants.elevatorI);
        elevatorpid.setD(OperatorConstants.elevatorD);
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

    public void resetEncoder(){
        encoder.setPosition(0);
    }

    public void setPower(double speed) {
        leftelevator.set(speed);
    }

    @Override
    public void periodic() {
        if (atFloor()){
            resetEncoder();
        }
    }
}
