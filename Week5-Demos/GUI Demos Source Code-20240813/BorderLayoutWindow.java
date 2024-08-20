package Demo.GUI;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * BorderLayoutWindow class - demonstrates the use of a Borderlayout
 */

//objects of this class will not be Serialized, so this suppresses
//the warning about there being no serialVersionUID
@SuppressWarnings("serial")
public class BorderLayoutWindow extends JFrame
{
	public BorderLayoutWindow()
	{
//  a BorderLayout with a horizontal gap of 5 pixels and a vertical gap of 10 pixels
		setLayout(new BorderLayout(5, 10));
// create the components
		JTextField textField = new JTextField("Now Playing....", 30);
		textField.setEditable(false);
		JButton onButton = new JButton("On");
		JButton offButton = new JButton("Off");
		ButtonGroup radioButtons = new ButtonGroup();
		JRadioButton shuffle = new JRadioButton("Shuffle", true);
		JRadioButton continuous = new JRadioButton("Continuous");
		radioButtons.add(shuffle);
		radioButtons.add(continuous);
// add all the components to the window
		add(BorderLayout.CENTER, textField);
		add(BorderLayout.NORTH, shuffle);
		add(BorderLayout.WEST, onButton);
		add(BorderLayout.EAST, offButton);
		add(BorderLayout.SOUTH, continuous);
	}

	public static void main(String[] args)
	{
		BorderLayoutWindow window = new BorderLayoutWindow();
		window.setTitle("Border Layout Window");
		window.pack();
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
