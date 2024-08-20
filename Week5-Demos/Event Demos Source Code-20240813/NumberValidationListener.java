package Demo.Event;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * NumberValidationListener class - an ActionListener to validate numeric data in a text field
 */

public class NumberValidationListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		JTextField field = (JTextField) e.getSource();
		if (isValidAge(field.getText()))
		{
			field.setBackground(Color.green);
		}
		else
		{
			field.setBackground(Color.red);
		}
	}

	private boolean isValidAge(String ageValue)
	{
		try
		{
			Integer.parseInt(ageValue);
			return true;
		}
		catch (NumberFormatException e)
		{
			return false;
		}
	}
}
