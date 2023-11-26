/* This file contains GUI code for the hash calculator
*
* Author: Josh McIntyre
*/
package com.jmcintyre;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/* This class defines the GUI components for a hash calculator */
public class CheckSumThingJPanel extends JPanel
{
	/* Define constants for hash calculation */
	final String DEFAULT_ALGORITHM = "SHA-256";

	/* This block defines constants for GUI generation */
	final String INPUT_CAPTION = "Input: ";
	final String HASH_CAPTION = "Hash: ";

	/* This block defines GUI components */
	GridLayout gridLayout;

	JLabel inputJLabel;
	JTextArea inputJTextArea;

	JLabel hashJLabel;
	JTextField hashJTextField;
	
	DocumentListener inputDocumentListener;
	
	HashCalculate hashCalculate;

	/* This constructor configures GUI components */
	public CheckSumThingJPanel()
	{
		initializeComponents();
		initializeEventHandlers();
		drawComponents();
	}

	/* This function initializes GUI components */
	public void initializeComponents()
	{
		gridLayout = new GridLayout(4,2);
		setLayout(gridLayout);

		inputJLabel = new JLabel(INPUT_CAPTION);
		inputJTextArea = new JTextArea();
		
		hashJLabel = new JLabel(HASH_CAPTION);
		hashJTextField = new JTextField();
		hashJTextField.setEnabled(false);
		
		hashCalculate = new HashCalculate();

	}
	
	public void initializeEventHandlers()
	{
		inputDocumentListener = new InputDocumentListener();
		inputJTextArea.getDocument().addDocumentListener(inputDocumentListener);
		
		// Trigger an initial calculation of the hash based on the empty string
		handleinputJTextArea();
	}

	/* This function initializes event handlers for the GUI */
	public class InputDocumentListener implements DocumentListener
	{
		public void removeUpdate(DocumentEvent arg0)
		{
			handleinputJTextArea();
		}

		public void insertUpdate(DocumentEvent arg0)
		{
			handleinputJTextArea();
		}
		
		public void changedUpdate(DocumentEvent arg0)
		{
			handleinputJTextArea();
		}
	}

	/* This function adds components to the GUI and draws */
	public void drawComponents()
	{
		removeAll();

		add(inputJLabel);
		add(inputJTextArea);
		
		add(hashJLabel);
		add(hashJTextField);

		validate();
	}

	/* This function handles the calculation of the hash based on user input */
	public void handleinputJTextArea()
	{

		String inputText = inputJTextArea.getText();
		
		String digest = hashCalculate.calculateHash(inputText, DEFAULT_ALGORITHM);
		
		hashJTextField.setText(digest);
	}
}
