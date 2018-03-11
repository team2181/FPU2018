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
public class AutoSR extends CommandGroup {

	private String gameData;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    public AutoSR() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS

        gameData = DriverStation.getInstance().getGameSpecificMessage();
        //addSequential(new AutoPath("middle"));
        //addSequential(new AutoFlippyDoUp(.5, 'M'));
        addSequential(new TimeMove(-.5, .7, 1, 'L')); //First val is spd, Second is rot, Third is time, Last is which side it belongs to
        addSequential(new TimeMove(-.7, 0, 2, 'L'));  //These values have to be tested with the actual robot, but shouldn't be hard to find
        addSequential(new TimeMove(-.5, -.7, 1, 'L'));
        addSequential(new TimeMove(-.6, 0, 5, 'R'));
        addSequential(new AutoFlippyDoUp(.5, 'M'));
        //addSequential(new AutoPath("stage2"));
//    	NetworkTableInstance offSeasonNetworkTable = NetworkTableInstance.create();
//    	offSeasonNetworkTable.startClient("10.0.100.5");
//    	gameData = offSeasonNetworkTable.getTable("OffseasonFMSInfo").getEntry("GameData").getString("defaultValue");
//        
//		if(gameData.charAt(0) == 'L')
//		{
//    		addSequential(new DrivePID(-12)); // in inches // start backwards
//    		addSequential(new TurnPID(39.83)); // in degrees
//    		addSequential(new DrivePID(-100.6));
//    		addSequential(new TurnPID(-39.83));
//    		addSequential(new UltraSonicPID());
//			addSequential(new FlipOff());
//			addSequential(new AutoLeftTurnAround());
//			addSequential(new DrivePID(75));
//    		addSequential(new TurnPID(90));
//			addSequential(new VISCubeGrab());
//			if(gameData.charAt(1) == 'L') 
//			{
//			addSequential(new TurnPID(-90));
//		    addSequential(new DrivePID(14));
//			} else 
//			{
//				addSequential(new AutoLToRScale());
//			}
//		} else 
//		{
//			addSequential(new DrivePID(-12)); // in inches // start backwards
//			addSequential(new TurnPID(-34.8)); // in degrees
//			addSequential(new DrivePID(-94.08));
//			addSequential(new TurnPID(34.8));
//			addSequential(new UltraSonicPID());
//			addSequential(new FlipOff());
//			addSequential(new AutoRightTurnAround());
//		    addSequential(new DrivePID(75));
//    	    addSequential(new TurnPID(-90));
//			addSequential(new VISCubeGrab());
//			if(gameData.charAt(1) == 'R') 
//			{
//			addSequential(new TurnPID(90));
//		    addSequential(new DrivePID(14));
//			} else 
//			{
//				addSequential(new AutoRToLScale());
//			}
//		}
//    	addSequential(Robot.lift.goTo(0));

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS
 
    } 
}
