// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

  private final WPI_TalonSRX leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor;

  private double leftPower, rightPower;

  public DriveSubsystem() {
    leftFrontMotor = new WPI_TalonSRX(0);
    leftBackMotor = new WPI_TalonSRX(1);
    rightFrontMotor = new WPI_TalonSRX(2);
    rightBackMotor = new WPI_TalonSRX(3);

    leftPower = 0;
    rightPower = 0;

    leftBackMotor.follow(leftFrontMotor);
    rightBackMotor.follow(rightFrontMotor);

    leftBackMotor.setNeutralMode(NeutralMode.Brake);
    leftFrontMotor.setNeutralMode(NeutralMode.Brake);
    rightBackMotor.setNeutralMode(NeutralMode.Brake);
    rightFrontMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void setDrivePowers(double leftPower, double rightPower) {
    this.leftPower = -leftPower;
    this.rightPower = rightPower;
  }

  @Override
  public void periodic() {
    leftFrontMotor.set(leftPower);
    rightFrontMotor.set(rightPower);
    System.out.println(leftPower);
    System.out.println(rightPower);
  }

}
