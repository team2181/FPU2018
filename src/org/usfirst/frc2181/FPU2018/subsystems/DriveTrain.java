// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2181.FPU2018.subsystems;

import org.usfirst.frc2181.FPU2018.RobotMap;
import org.usfirst.frc2181.FPU2018.commands.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Ultrasonic;

import java.lang.Math;


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final Encoder leftEncoder = RobotMap.driveTrainLeftEncoder;
    private final Encoder rightEncoder = RobotMap.driveTrainRightEncoder;
    private final WPI_TalonSRX leftMotor = RobotMap.driveTrainLeftMotor;
    private final WPI_TalonSRX rightMotor = RobotMap.driveTrainRightMotor;
    private final DifferentialDrive diffDrive = RobotMap.driveTrainDiffDrive;
    private final WPI_TalonSRX leftMotor2 = RobotMap.driveTrainLeftMotor2;
    private final WPI_TalonSRX rightMotor2 = RobotMap.driveTrainRightMotor2;
    private final DifferentialDrive diffDrive2 = RobotMap.driveTrainDiffDrive2;
    private final Solenoid gearShift = RobotMap.driveTrainGearShift;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DriveTrainDefault());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        leftEncoder.setDistancePerPulse(.5*Math.PI/360);
        rightEncoder.setDistancePerPulse(.5*Math.PI/360);
        SmartDashboard.putData("Right Encoder", rightEncoder);
        SmartDashboard.putNumber("Count", rightEncoder.getDistance());
        //ultrasonic1.setAutomaticMode(true);
    }
    
    public void drive(Joystick j) {
    	double spd = j.getRawAxis(1);
    	double rot = j.getRawAxis(4);
    	driveAuto(spd, rot);
    }
    
    public void driveAuto(double spd, double rot) {
    	diffDrive.arcadeDrive(spd, rot);
    	diffDrive2.arcadeDrive(spd, rot);
    }
    
    public double getLeft() {
    	return leftEncoder.getDistance();
    }
    
    public double getRight() {
    	return rightEncoder.getDistance();
    }
    
//    public double getDistance() {
//    	return ultrasonic1.getRangeInches();
//    }
    
    public void startSol() {
    	gearShift.set(true);
    }
    
    public void stopSol() {
    	gearShift.set(false);
    }
}

