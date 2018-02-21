// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2181.FPU2018;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogInput;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Solenoid flippyDooPusher;
    public static DigitalInput zuccSpinStop;
    public static SpeedController zuccLeftMotor;
    public static SpeedController zuccRightMotor;
    public static SpeedControllerGroup zuccSpinControl;
    public static WPI_TalonSRX driveTrainLeftMotor;
    public static WPI_TalonSRX driveTrainLeftMotor2;
    public static SpeedControllerGroup driveTrainLeftMotors;
    public static WPI_TalonSRX driveTrainRightMotor;
    public static WPI_TalonSRX driveTrainRightMotor2;
    public static SpeedControllerGroup driveTrainRightMotors;
    public static DifferentialDrive driveTrainDiffDrive;
    public static Encoder driveTrainLeftEncoder;
    public static Encoder driveTrainRightEncoder;
    public static Solenoid driveTrainGearShift;
    public static Ultrasonic driveTrainUltrasonic;
    public static Relay vISIONLights;
    public static Solenoid liftLocking;
    public static Encoder liftHeightEncoder;
    public static WPI_TalonSRX liftBottomMotor;
    public static WPI_TalonSRX liftTopMotor;
    public static SpeedControllerGroup liftMotors;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static AnalogInput pressureGauge;
    
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        flippyDooPusher = new Solenoid(1, 1);
        LiveWindow.addActuator("FlippyDoo", "Pusher", flippyDooPusher);
        
        zuccSpinStop = new DigitalInput(4);
        LiveWindow.addSensor("Zucc", "SpinStop", zuccSpinStop);
        
        zuccLeftMotor = new Talon(0);
        LiveWindow.addActuator("Zucc", "LeftMotor", (Talon) zuccLeftMotor);
        zuccLeftMotor.setInverted(false);
        zuccRightMotor = new Talon(1);
        LiveWindow.addActuator("Zucc", "RightMotor", (Talon) zuccRightMotor);
        zuccRightMotor.setInverted(false);
        zuccSpinControl = new SpeedControllerGroup(zuccLeftMotor, zuccRightMotor  );
        LiveWindow.addActuator("Zucc", "SpinControl", zuccSpinControl);
        
        driveTrainLeftMotor = new WPI_TalonSRX(3);
        
        
        driveTrainLeftMotor2 = new WPI_TalonSRX(4);
        
        
        driveTrainLeftMotors = new SpeedControllerGroup(driveTrainLeftMotor, driveTrainLeftMotor2  );
        LiveWindow.addActuator("DriveTrain", "LeftMotors", driveTrainLeftMotors);
        
        driveTrainRightMotor = new WPI_TalonSRX(1);
        
        
        driveTrainRightMotor2 = new WPI_TalonSRX(2);
        
        
        driveTrainRightMotors = new SpeedControllerGroup(driveTrainRightMotor, driveTrainRightMotor2  );
        LiveWindow.addActuator("DriveTrain", "RightMotors", driveTrainRightMotors);
        
        driveTrainDiffDrive = new DifferentialDrive(driveTrainLeftMotors, driveTrainRightMotors);
        LiveWindow.addActuator("DriveTrain", "DiffDrive", driveTrainDiffDrive);
        driveTrainDiffDrive.setSafetyEnabled(true);
        driveTrainDiffDrive.setExpiration(0.1);
        driveTrainDiffDrive.setMaxOutput(1.0);

        driveTrainLeftEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "LeftEncoder", driveTrainLeftEncoder);
        driveTrainLeftEncoder.setDistancePerPulse(0.05236);
        driveTrainLeftEncoder.setPIDSourceType(PIDSourceType.kRate);
        driveTrainRightEncoder = new Encoder(1, 0, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "RightEncoder", driveTrainRightEncoder);
        driveTrainRightEncoder.setDistancePerPulse(0.05236);
        driveTrainRightEncoder.setPIDSourceType(PIDSourceType.kRate);
        driveTrainGearShift = new Solenoid(2, 0);
        LiveWindow.addActuator("DriveTrain", "GearShift", driveTrainGearShift);
        
        driveTrainUltrasonic = new Ultrasonic(7, 6);
        LiveWindow.addSensor("DriveTrain", "Ultrasonic", driveTrainUltrasonic);
        
        vISIONLights = new Relay(0);
        LiveWindow.addActuator("VISION", "Lights", vISIONLights);
        
        liftLocking = new Solenoid(2, 1);
        LiveWindow.addActuator("Lift", "Locking", liftLocking);
        
        liftHeightEncoder = new Encoder(9, 8, false, EncodingType.k4X);
        LiveWindow.addSensor("Lift", "HeightEncoder", liftHeightEncoder);
        liftHeightEncoder.setDistancePerPulse(1.0);
        liftHeightEncoder.setPIDSourceType(PIDSourceType.kRate);
        liftBottomMotor = new WPI_TalonSRX(7);
        
        
        liftTopMotor = new WPI_TalonSRX(8);
        
        
        liftMotors = new SpeedControllerGroup(liftBottomMotor, liftTopMotor  );
        LiveWindow.addActuator("Lift", "Motors", liftMotors);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        pressureGauge = new AnalogInput(0);
        SmartDashboard.putData(pressureGauge);
    }
}
