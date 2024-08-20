package Demo.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * CloseButtonListener class - an ActionListener to dispose of a frame
 */

public class CloseButtonListener implements ActionListener
{
	private JFrame target;

	public CloseButtonListener(JFrame aFrame)
	{
		target = aFrame;
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		target.dispose();
	}
}
