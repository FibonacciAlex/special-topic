package Demo.Event;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * CloseableWindow class - demonstrates the use of an action listener to close a frame
 */

public class CloseableWindow
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		JButton closeButton = new JButton("close window");
		closeButton.addActionListener(new CloseButtonListener(frame));
		frame.add(closeButton);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
