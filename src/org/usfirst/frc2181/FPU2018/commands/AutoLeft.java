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

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc2181.FPU2018.subsystems.*;
import edu.wpi.first.wpilibj.DriverStation;

/**
 *
 */
public class AutoLeft extends CommandGroup {

	private String gameData;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    public AutoLeft() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
        
//        gameData = DriverStation.getInstance().getGameSpecificMessage();
//		//ADD IN CODE TO FIND VALUES TO BACK UP TO LEFT SWITCH SIDE
//    	addSequential(new DrivePID(-12)); // in inches // start backwards
//    	addSequential(new TurnPID(35.72)); // in degrees
//    	addSequential(new DrivePID(-95.15));
//    	addSequential(new TurnPID(-35.72));
//    	addSequential(new UltraSonicPID());
//		if(gameData.charAt(0) == 'L')
//		{
//			addSequential(new FlipOff());
//		} 
//		addSequential(new AutoLeftTurnAround());
//		
//		if(gameData.charAt(0) == 'R')
//		{
//			addSequential(new FlipOff());
//		}
//		
//		addSequential(new VISCubeGrab());
//		if(gameData.charAt(1) == 'L')
//		{
//			addSequential(new AutoSameSideScale());
//		} else {
//			addSequential(new AutoLToRScale());
//		}
		//SET LIFT TO BOTTOM
		//BACK UP


        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS
 
    } 
}
