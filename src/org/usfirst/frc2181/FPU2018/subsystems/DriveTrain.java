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
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import java.lang.Math;

/**
 *
 */
public class DriveTrain extends PIDSubsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	private double num = 320;
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX leftMotor = RobotMap.driveTrainLeftMotor;
    private final WPI_TalonSRX leftMotor2 = RobotMap.driveTrainLeftMotor2;
    private final SpeedControllerGroup leftMotors = RobotMap.driveTrainLeftMotors;
    private final WPI_TalonSRX rightMotor = RobotMap.driveTrainRightMotor;
    private final WPI_TalonSRX rightMotor2 = RobotMap.driveTrainRightMotor2;
    private final SpeedControllerGroup rightMotors = RobotMap.driveTrainRightMotors;
    private final DifferentialDrive diffDrive = RobotMap.driveTrainDiffDrive;
    private final Encoder leftEncoder = RobotMap.driveTrainLeftEncoder;
    private final Encoder rightEncoder = RobotMap.driveTrainRightEncoder;
    private final Solenoid gearShift = RobotMap.driveTrainGearShift;
    private final Ultrasonic ultrasonic = RobotMap.driveTrainUltrasonic;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    private String mode = "drive";
    private double lastGyro = 0.0;

    // Initialize your subsystem here
    public DriveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("DriveTrain", 0.002, 4.0E-5, 0.0);
        setAbsoluteTolerance(30.0);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("DriveTrain", "PIDSubsystem Controller", getPIDController());
        getPIDController().setOutputRange(-0.7, 0.7);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID

        SmartDashboard.putData("PID Values", getPIDController());
        gyro.calibrate();
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
        lastGyro = gyro.getAngle();
        
        setRamping(1.5);
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DriveTrainDefault());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    @Override
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;

    	if (mode == "drive") { // driving forward
    		return leftEncoder.getDistance(); // distance driven
    	} else if (mode == "turn") { // turning
    		return gyro.getAngle()-lastGyro; // angle turned since start of turn
    	} else if (mode == "ultrasonic") {
    		return ultrasonic.getRangeInches();
    	} else {
    		return 0;
    	}

        //return num;


    }

    @Override
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	if (mode == "drive") {
    		driveAuto(output, 0.0);
    	} else if (mode == "turn") {
    		driveAuto(0.0, output);
    	} else if (mode == "ultrasonic") {
    		driveAuto(-output, 0.0);
    	}
    	SmartDashboard.putNumber("PID Output", -output);
    	SmartDashboard.putNumber("Test Vision Val", num);


    }
    

    
    public void setSpot(double spot) {
    	num = spot;
    }
    
    public void drive(Joystick j) {
    	double spd = .7 * j.getRawAxis(1);
    	double rot = -1 * j.getRawAxis(4);
    	double ramp = 1.5;
    	if (rot == 0 && spd == 0) {
    		ramp = 1.5;
    	} else {
    		ramp = 0.5+Math.abs(spd)/(Math.abs(spd)+Math.abs(rot));
    	}
    	setRamping(ramp);
    	driveAuto(spd, rot);
    	}
    
    public void driveAuto(double spd, double rot) {
    	SmartDashboard.putNumber("Left Encoder", leftEncoder.getDistance());
    	SmartDashboard.putNumber("Right Encoder", rightEncoder.getDistance());
    	SmartDashboard.putNumber("Gyro", gyro.getAngle());
    	diffDrive.arcadeDrive(spd, rot);
    }
    
    public void setMode(String s) {
    	mode = s;
    	if (s == "drive") {
    		leftEncoder.reset();
    		rightEncoder.reset();
    	} else if (s == "angle") {
    		lastGyro = gyro.getAngle();
    	}
    }
    
    public double getGyro() {
    	return gyro.getAngle();
    }
    
    public void setDriveMode(boolean lowTorq) {
    	gearShift.set(lowTorq);
    	SmartDashboard.putBoolean("High V & Low T", gearShift.get());
    }
    
    public void setRamping(double time) {
    	leftMotor.configOpenloopRamp(time,10);
        leftMotor2.configOpenloopRamp(time,10);
        rightMotor.configOpenloopRamp(time,10);
        rightMotor2.configOpenloopRamp(time,10);
    }
}
