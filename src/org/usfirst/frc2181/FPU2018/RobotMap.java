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
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Encoder driveTrainLeftEncoder;
    public static Encoder driveTrainRightEncoder;
    public static Ultrasonic driveTrainUltrasonic1;
    public static WPI_TalonSRX driveTrainLeftMotor;
    public static WPI_TalonSRX driveTrainRightMotor;
    public static DifferentialDrive driveTrainDiffDrive;
    public static Solenoid driveTrainGearShift;
    public static Solenoid flippyDooPusher;
    public static Ultrasonic flippyDooUltrasonic1;
    public static WPI_TalonSRX zuccLeftSpinner;
    public static WPI_TalonSRX zuccRightSpinner;
    public static SpeedControllerGroup zuccSpinControl;
    public static DigitalInput zuccSpinStop;
    public static Solenoid liftLocking;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftEncoder = new Encoder(1, 2, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "LeftEncoder", driveTrainLeftEncoder);
        driveTrainLeftEncoder.setDistancePerPulse(1.0);
        driveTrainLeftEncoder.setPIDSourceType(PIDSourceType.kRate);
        driveTrainRightEncoder = new Encoder(5, 4, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "RightEncoder", driveTrainRightEncoder);
        driveTrainRightEncoder.setDistancePerPulse(1.0);
        driveTrainRightEncoder.setPIDSourceType(PIDSourceType.kRate);
        driveTrainUltrasonic1 = new Ultrasonic(7, 6);
        LiveWindow.addSensor("DriveTrain", "Ultrasonic 1", driveTrainUltrasonic1);
        
        driveTrainLeftMotor = new WPI_TalonSRX(1);
        
        
        driveTrainRightMotor = new WPI_TalonSRX(2);
        
        
        driveTrainDiffDrive = new DifferentialDrive(driveTrainLeftMotor, driveTrainRightMotor);
        LiveWindow.addActuator("DriveTrain", "DiffDrive", driveTrainDiffDrive);
        driveTrainDiffDrive.setSafetyEnabled(true);
        driveTrainDiffDrive.setExpiration(0.1);
        driveTrainDiffDrive.setMaxOutput(1.0);

        driveTrainGearShift = new Solenoid(1, 0);
        LiveWindow.addActuator("DriveTrain", "GearShift", driveTrainGearShift);
        
        flippyDooPusher = new Solenoid(1, 1);
        LiveWindow.addActuator("FlippyDoo", "Pusher", flippyDooPusher);
        
        flippyDooUltrasonic1 = new Ultrasonic(11, 9);
        LiveWindow.addSensor("FlippyDoo", "Ultrasonic 1", flippyDooUltrasonic1);
        
        zuccLeftSpinner = new WPI_TalonSRX(3);
        
        
        zuccRightSpinner = new WPI_TalonSRX(4);
        
        
        zuccSpinControl = new SpeedControllerGroup(zuccLeftSpinner, zuccRightSpinner  );
        LiveWindow.addActuator("Zucc", "SpinControl", zuccSpinControl);
        
        zuccSpinStop = new DigitalInput(0);
        LiveWindow.addSensor("Zucc", "SpinStop", zuccSpinStop);
        
        liftLocking = new Solenoid(4, 0);
        LiveWindow.addActuator("Lift", "Locking", liftLocking);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
