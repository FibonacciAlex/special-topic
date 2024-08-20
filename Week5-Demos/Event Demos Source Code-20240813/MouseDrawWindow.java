package Demo.Event;

import javax.swing.JFrame;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * MouseDrawWindow class - demonstrates the DrawMouseListener
 */

public class MouseDrawWindow
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Mouse Draw Window");
		frame.addMouseMotionListener(new DrawMouseListener(frame));
		frame.setBounds(100,100,500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}