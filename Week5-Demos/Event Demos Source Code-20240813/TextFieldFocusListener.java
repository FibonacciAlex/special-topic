package Demo.Event;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * TextFieldFocusListener class - a FocusListener to respond to text field focus events
 */

public class TextFieldFocusListener implements FocusListener
{
	@Override
	public void focusGained(FocusEvent e)
	{
		JTextField field = (JTextField)e.getSource();
		field.setBackground(Color.YELLOW);
	}

	@Override
	public void focusLost(FocusEvent e)
	{
		JTextField field = (JTextField)e.getSource();
		field.setBackground(Color.WHITE);
	}
}
