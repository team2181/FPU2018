/*----------------------------------------------------------------------------*/
/* Copyright (c) 2008-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc2181.FPU2018;

import edu.wpi.first.wpilibj.GenericHID;

/**
 * A {@link Button} that gets its state from a {@link GenericHID}.
 */
public class ReplayButton extends Button {
  private final int m_buttonNumber;

  /**
   * Create a replay controller for triggering commands.
   *
   * @param buttonNumber The button number (see {@link GenericHID#getRawButton(int) }
   */
  public ReplayButton(int buttonNumber) {
    m_buttonNumber = buttonNumber; //The button number on the controller, -1 if used for joystick input {constantly returns true}
  }

  /**
   * Gets the value of the joystick button.
   *
   * @return The value of the joystick button
   */
  public boolean get() {
	if (m_buttonNumber == -1) {
		return true;
	} else {
		return false; //This will be changed to return the saved state of a button at any given time stamp
	}
  }
}
