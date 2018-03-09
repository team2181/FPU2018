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
public class AutoRight extends CommandGroup {

	private String gameData;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    public AutoRight() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS

        gameData = DriverStation.getInstance().getGameSpecificMessage();
        addSequential(new AutoPath("right"));
        if (gameData.charAt(0) == 'R') {
        	addSequential(new AutoFlippyDoUp(.5));
        }
        addSequential(new AutoPath("stage2"));
//    	NetworkTableInstance offSeasonNetworkTable = NetworkTableInstance.create();
//    	offSeasonNetworkTable.startClient("10.0.100.5");
//    	gameData = offSeasonNetworkTable.getTable("OffseasonFMSInfo").getEntry("GameData").getString("defaultValue");
		//ADD IN CODE TO FIND VALUES TO BACK UP TO RIGHT SWITCH SIDE
//        addSequential(new ResetGyro());
//        addSequential(new DrivePID(-12)); // in inches // start backwards
//    	addSequential(new TurnPID(-37.22)); // in degrees
//    	addSequential(new DrivePID(-45.15));
//    	addSequential(new ResetGyro());
//    	addSequential(new TurnPID(35));
//    	addSequential(new AutoFlippyDoUp(.5));
//    	//addSequential(new UltraSonicPID());
//		if(gameData.charAt(0) == 'R')
//		{
//			addSequential(new FlipOff());
//		} 
//		addSequential(new AutoRightTurnAround());
//		
//		if(gameData.charAt(0) == 'L')
//		{
//			addSequential(new FlipOff());
//		}
//		addSequential(new DrivePID(75));
//    	addSequential(new TurnPID(-90));
//		addSequential(new VISCubeGrab());
//		
//		if(gameData.charAt(1) == 'R')
//		{
//		addSequential(new TurnPID(90));
//		addSequential(new DrivePID(14));
//		} else {
//			addSequential(new AutoRToLScale());
//		}
//		
//		addSequential(Robot.lift.goTo(0));



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
