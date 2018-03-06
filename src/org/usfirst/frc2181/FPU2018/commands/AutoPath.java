// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2181.FPU2018.commands;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2181.FPU2018.Robot;

import com.ctre.phoenix.motion.SetValueMotionProfile;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class AutoPath extends Command {

	MotionProfileExample _example;
	WPI_TalonSRX _talon;
	WPI_TalonSRX _talon2;
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private String m_profile;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutoPath(String profile) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_profile = profile;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
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

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	if (m_profile == "left") {
    		_example = new MotionProfileExample(_talon, _talon2, GeneratedMotionProfile.PointsL1, GeneratedMotionProfile.PointsL2, GeneratedMotionProfile.kNumPointsL);
    	} else if (m_profile == "right") {
    		_example = new MotionProfileExample(_talon, _talon2, GeneratedMotionProfile.PointsR1, GeneratedMotionProfile.PointsR2, GeneratedMotionProfile.kNumPointsR);
    	} else if (m_profile == "middle") {
    		if (DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'L') {
    			_example = new MotionProfileExample(_talon, _talon2, GeneratedMotionProfile.PointsML1, GeneratedMotionProfile.PointsML2, GeneratedMotionProfile.kNumPointsML);
    		} else {
    			_example = new MotionProfileExample(_talon, _talon2, GeneratedMotionProfile.PointsMR1, GeneratedMotionProfile.PointsMR2, GeneratedMotionProfile.kNumPointsMR);
    		}
    	}
    	_example.startMotionProfile();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	_example.control();
    	SetValueMotionProfile setOutput = _example.getSetValue();

		_talon.set(ControlMode.MotionProfile, setOutput.value);
		_talon2.set(ControlMode.MotionProfile, setOutput.value);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if (_example.getSetValue().value == 0) {
        	System.out.println("done");
        	return true;
        } else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	_example.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	_example.reset();
    }
}
