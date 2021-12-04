// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveSubsystem extends SubsystemBase {

  private WPI_TalonSRX leftMotor;
  private WPI_TalonSRX rightMotor;
  private DifferentialDrive m_drive;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {

    leftMotor = new WPI_TalonSRX(Constants.LEFTMOTOR);
    rightMotor = new WPI_TalonSRX(Constants.RIGHTMOTOR);
    m_drive = new DifferentialDrive(leftMotor, rightMotor);

  }

  public void drive(double leftSpeed, double rightSpeed){

    m_drive.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
