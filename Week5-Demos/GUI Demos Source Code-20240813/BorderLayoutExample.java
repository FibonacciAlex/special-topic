package Demo.GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * BorderLayoutExample class - demonstrates adding components to areas of a BorderLayout
 */

public class BorderLayoutExample
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		// Use add(Component, Object) method instead of add(Component)
		frame.add(new JButton("North"), BorderLayout.NORTH);
		frame.add(new JButton("South"), BorderLayout.SOUTH);
		frame.add(new JButton("Center"), BorderLayout.CENTER);
		frame.add(new JButton("East"), BorderLayout.EAST);
		frame.add(new JButton("West"), BorderLayout.WEST);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
