/** This file contains code for a simple checksum/hash calculator
* And demonstrates how passwords or other data are hashed with crypto-secure algorithms
*
* Author: Josh McIntyre
*/

package com.jmcintyre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* This class defines the GUI and is the main entry point for the program */
public class CheckSumthing extends JFrame
{
	/* This block defines constants used in defining window components
	*
	*/
	final int DEFAULT_WINDOW_WIDTH = 600;
	final int DEFAULT_WINDOW_HEIGHT = 200;
	final String WINDOW_CAPTION = "CheckSumthing";

	/* This block defines GUI components */
	JPanel checkSumthingJPanel;

	/* This constructor configures GUI components */
	public CheckSumthing()
	{
		initializeComponents();
		drawComponents();
	}

	/* This function initializes GUI components */
	public void initializeComponents()
	{
		setTitle(WINDOW_CAPTION);
		setVisible(true);
		setSize(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		checkSumthingJPanel = new CheckSumThingJPanel();

	}

	/* This function adds components and draws the GUI */
	public void drawComponents()
	{
		add(checkSumthingJPanel);

		validate();
	}

	/* This function is the main entry point for the program
	* It sets the look and feel to the system look and feel and creates
	* a new instance of the GUI
	*/
	public static void main(String[] args)
	{
		try
		{
			String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
			UIManager.setLookAndFeel(lookAndFeel);
			CheckSumthing checkSumthing = new CheckSumthing();
		}
		catch (Exception e)
		{
			CheckSumthing checkSumthing = new CheckSumthing();
		}
	}

}
