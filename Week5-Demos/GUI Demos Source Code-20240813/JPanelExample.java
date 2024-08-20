package Demo.GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * JPanelExample class - demonstrates how a JPanel can be added to a JFrame
 */

public class JPanelExample
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JTextField textField = new JTextField(20);
		JButton button = new JButton("Press me!");
		panel.add(textField);
		panel.add(button);
		frame.add(panel);
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
