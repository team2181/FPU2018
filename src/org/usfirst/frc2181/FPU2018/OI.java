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

import org.usfirst.frc2181.FPU2018.commands.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc2181.FPU2018.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton driveMode;
    public JoystickButton cubeFlip;
    public JoystickButton liftUpBtn;
    public JoystickButton liftDownBtn;
    public JoystickButton zuccInBtn;
    public JoystickButton zuccOutBtn;
    public JoystickButton noLeftBumper;
    public JoystickButton xButton;
    public JoystickButton noXButton;
    public Joystick joystick;
    public JoystickButton endLock;
    public Joystick lockingTrigger;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        lockingTrigger = new Joystick(1);
        
        endLock = new JoystickButton(lockingTrigger, 1);
        endLock.whenPressed(new LockIt());
        joystick = new Joystick(0);
        
        noXButton = new JoystickButton(joystick, 3);
        noXButton.whenReleased(new FlippyDoStop());
        xButton = new JoystickButton(joystick, 3);
        xButton.whileHeld(new FlippyDoUp());
        noLeftBumper = new JoystickButton(joystick, 5);
        noLeftBumper.whenReleased(new LiftDefault());
        zuccOutBtn = new JoystickButton(joystick, 4);
        zuccOutBtn.whileHeld(new ZuccOut());
        zuccInBtn = new JoystickButton(joystick, 3);
        zuccInBtn.whileHeld(new ZuccIn());
        liftDownBtn = new JoystickButton(joystick, 6);
        liftDownBtn.whileHeld(new LiftDown());
        liftUpBtn = new JoystickButton(joystick, 5);
        liftUpBtn.whileHeld(new LiftUp());
        cubeFlip = new JoystickButton(joystick, 1);
        cubeFlip.whenPressed(new FlipOff());
        driveMode = new JoystickButton(joystick, 2);
        driveMode.whileHeld(new DriveSwitch());


        // SmartDashboard Buttons
        SmartDashboard.putData("FlippyDoUp", new FlippyDoUp());
        SmartDashboard.putData("FlippyDoStop", new FlippyDoStop());
        //SmartDashboard.putData("AutoFlippyDoUp", new AutoFlippyDoUp());
        SmartDashboard.putData("ResetGyro", new ResetGyro());
        SmartDashboard.putData("Command 1", new Command1());
        //SmartDashboard.putData("AutoDriveBackwards", new AutoDriveBackwards());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick() {
        return joystick;
    }

    public Joystick getLockingTrigger() {
        return lockingTrigger;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

