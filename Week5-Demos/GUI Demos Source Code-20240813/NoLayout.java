package Demo.GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * NoLayout class - demonstrates adding components to a frame manually, without a layout manager
 */

//objects of this class will not be Serialized, so this suppresses
//the warning about there being no serialVersionUID
@SuppressWarnings("serial")
public class NoLayout extends JFrame
{
	private JLabel label;
	private JTextField textField;
	private JButton button;

	public NoLayout()
	{
// turn off the default layout manager
		setLayout(null);
// create the components
		label = new JLabel("Enter some text");
		textField = new JTextField(20);
		textField.setToolTipText("Enter some text here");
		button = new JButton("Press Me!");
		button.setEnabled(false);
// add them to the window
		add(label);
		add(textField);
		add(button);
// manually position and size them
		label.setBounds(10, 20, 300, 50);
		textField.setBounds(110, 30, 200, 30);
		button.setBounds(110,70,100,30);
	}

	public static void main(String[] args)
	{
		NoLayout window = new NoLayout();
		window.setTitle("Manually Positioned Components");
		window.setBounds(200, 170, 500, 200);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
