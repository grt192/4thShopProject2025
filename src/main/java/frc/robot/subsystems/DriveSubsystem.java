// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

  private final TalonFX leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor;

  private double leftPower, rightPower;

  public DriveSubsystem() {
    leftFrontMotor = new TalonFX(0);
    leftBackMotor = new TalonFX(1);
    rightFrontMotor = new TalonFX(2);
    rightBackMotor = new TalonFX(3);

    leftPower = 0;
    rightPower = 0;

    leftBackMotor.setControl(new Follower(0, false));
    rightBackMotor.setControl(new Follower(2, false));
  }

  public void setDrivePowers(double leftPower, double rightPower) {
    this.leftPower = leftPower;
    this.rightPower = rightPower;
  }

  @Override
  public void periodic() {
    leftFrontMotor.set(leftPower);
    rightFrontMotor.set(rightPower);
  }

}
