// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TankDrive extends CommandBase {

  private DriveSubsystem driveSubsystem;
  private XboxController joystickOne;
  /** Creates a new TankDrive. */
  public TankDrive(DriveSubsystem driveSubsystem, XboxController joy) {
    this.driveSubsystem = driveSubsystem;
    joystickOne = joy;
    addRequirements(driveSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean leftDeadzone = joystickOne.getY(Hand.kLeft) > 0.2 || joystickOne.getY(Hand.kLeft) < -0.2;
    boolean rightDeadzone = joystickOne.getY(Hand.kRight) > 0.2 || joystickOne.getY(Hand.kRight) < -0.2;

    
    if(leftDeadzone || rightDeadzone){
      
      driveSubsystem.drive(joystickOne.getY(Hand.kLeft), joystickOne.getY(Hand.kRight));

    }else{
      driveSubsystem.drive(0, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSubsystem.drive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
