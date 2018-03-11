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
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2181.FPU2018.RobotMap;
import org.usfirst.frc2181.FPU2018.Robot;
import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 *
 */
public class DriveSwitch extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DriveSwitch() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	SmartDashboard.putNumber("pressure", (RobotMap.pressureGauge.getVoltage()-.5)*50+5);
    	if ((RobotMap.pressureGauge.getVoltage()-.5)*50+5 > 40) {
    		Robot.driveTrain.setDriveMode(true);
    	}
    	SmartDashboard.putString("drive mode change", "activated");
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	
    	Robot.driveTrain.setDriveMode(true);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	SmartDashboard.putString("drive mode change", "deactivated");
    	Robot.driveTrain.setDriveMode(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	SmartDashboard.putString("drive mode change", "deactivated");
    	Robot.driveTrain.setDriveMode(false);
    }
}
