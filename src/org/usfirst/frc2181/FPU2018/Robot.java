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

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc2181.FPU2018.MyPipeline;
import org.usfirst.frc2181.FPU2018.commands.*;
import org.usfirst.frc2181.FPU2018.subsystems.*;
import org.usfirst.frc2181.FPU2018.Robot.*;
import org.usfirst.frc2181.FPU2018.RobotMap;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motion.*;
import com.ctre.phoenix.motorcontrol.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

	MotionProfileExample _example;
	WPI_TalonSRX _talon;
	WPI_TalonSRX _talon2;
	
	saveEncoder save = new saveEncoder();
	double timeloop = 0;
	double timenow = 0;
	
    Command autonomousCommand;
    SendableChooser<Number> chooser = new SendableChooser<>();
    
    public static SendableChooser<Boolean> chooser2 = new SendableChooser<>();

    public static OI oi;
    public String gameData;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static FlippyDoo flippyDoo;
    public static Zucc zucc;
    public static DriveTrain driveTrain;
    public static VISION vISION;
    public static Lift lift;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private int centerX = 320;
    private static final int IMG_WIDTH = 640;
    private static final int IMG_HEIGHT = 480;
    private VisionThread visionThread;
    private final Object imgLock = new Object();
    private double[] arr = new double[]{320,320,320,320,320};

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        flippyDoo = new FlippyDoo();
        zucc = new Zucc();
        driveTrain = new DriveTrain();
        vISION = new VISION();
        lift = new Lift();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        chooser.addObject("AutoLeft", new AutoLeft());
        chooser.addObject("AutoRight", new AutoRight());
        chooser.addObject("AutoMiddle", new AutoMiddle());
        chooser.addDefault("Autonomous Command", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        SmartDashboard.putData("Auto Position", chooser);
        
        chooser2.addDefault("No", false);
        chooser2.addObject("Yes", true);
        SmartDashboard.putData("Go for it", chooser2);
        
//        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
//        camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
//
//        visionThread = new VisionThread(camera, new MyPipeline(), pipeline -> {
//            if (!pipeline.filterContoursOutput().isEmpty()) {
//                Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
//                synchronized (imgLock) {
//                    centerX = r.x + (r.width / 2);
//                }
//            }
//        });
//
//        visionThread.start();
        _talon = RobotMap.driveTrainLeftMotor;
        _talon2 = RobotMap.driveTrainRightMotor;
        _example = new MotionProfileExample(_talon, _talon2, GeneratedMotionProfile.PointsL1, GeneratedMotionProfile.PointsL2, GeneratedMotionProfile.kNumPointsL);
        _talon.configMotionProfileTrajectoryPeriod(10, 10); 
        _talon2.configMotionProfileTrajectoryPeriod(10, 10); 
		/*
		 * status 10 provides the trajectory target for motion profile AND
		 * motion magic
		 */
		_talon.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 10);
		_talon2.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 10);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){
    	_example.reset();
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        //autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        //if (autonomousCommand != null) autonomousCommand.start();
    	//driveTrain.setSetpoint(320.0);
    	//driveTrain.enable();
    	if (chooser.getSelected().intValue() == 1) {
    		_example = new MotionProfileExample(_talon, _talon2, GeneratedMotionProfile.PointsL1, GeneratedMotionProfile.PointsL2, GeneratedMotionProfile.kNumPointsL);
    	} else if (chooser.getSelected().intValue() == 2) {
    		_example = new MotionProfileExample(_talon, _talon2, GeneratedMotionProfile.PointsR1, GeneratedMotionProfile.PointsR2, GeneratedMotionProfile.kNumPointsR);
    	} else if (chooser.getSelected().intValue() == 3) {
    		if (DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'L') {
    			_example = new MotionProfileExample(_talon, _talon2, GeneratedMotionProfile.PointsML1, GeneratedMotionProfile.PointsML2, GeneratedMotionProfile.kNumPointsML);
    		} else {
    			_example = new MotionProfileExample(_talon, _talon2, GeneratedMotionProfile.PointsMR1, GeneratedMotionProfile.PointsMR2, GeneratedMotionProfile.kNumPointsMR);
    		}
    	}
    	_example.startMotionProfile();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
    	_example.control();
    	SetValueMotionProfile setOutput = _example.getSetValue();

		_talon.set(ControlMode.MotionProfile, setOutput.value);
		_talon2.set(ControlMode.MotionProfile, setOutput.value);
//    	double centerX;
//        synchronized (imgLock) {
//            centerX = this.centerX;
//        }
//        arr[4] = arr[3]; arr[3] = arr[2]; arr[2] = arr[1]; arr[1] = arr[0]; arr[0] = centerX;
//        double avg = (arr[0]+arr[1]+arr[2]+arr[3]+arr[4])/5.0;
//        driveTrain.setSpot(avg);
//        //double turn = avg - (IMG_WIDTH / 2);
//        //driveTrain.driveAuto(0, -turn*0.1/10);
//        SmartDashboard.putNumber("Vision XPos", avg);
        //Scheduler.getInstance().run();
    	//double val = SmartDashboard.getNumber("pos", 0);
    	//SmartDashboard.putNumber("pos2", 2.0*val);
    }

    @Override
    public void teleopInit() {
    	driveTrain.disable();
//    	save.startWrite("C:\\Users\\jpiv1\\new\\FPU2018\\src\\org\\usfirst\\frc2181\\FPU2018\\recent.csv");
    	timenow = System.currentTimeMillis();
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
//        timeloop = System.currentTimeMillis();
//        save.writeInfo(RobotMap.driveTrainLeftMotor.getSelectedSensorPosition(0),
//        			   RobotMap.driveTrainLeftMotor.getSelectedSensorVelocity(0),
//        			   timeloop-timenow);
//        timenow = timeloop;
    }
    
}
