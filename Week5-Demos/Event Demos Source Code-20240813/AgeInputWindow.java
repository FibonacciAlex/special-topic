package Demo.Event;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * AgeInputWindow class - adds multiple listeners to text fields
 */

// objects of this class will not be Serialized, so this suppresses
// the warning about there being no serialVersionUID
@SuppressWarnings("serial")
public class AgeInputWindow extends JFrame
{
    public AgeInputWindow()
    {
    	setLayout(new GridLayout(3,0));
        JButton closeButton = new JButton("close window");
// add an action listener to a button to close the window
    	closeButton.addActionListener(new CloseButtonListener(this));
    	JTextField nameField = new JTextField(20);
    	JTextField ageField = new JTextField(20);
    	
// add an action listener to the 'age' filed to validate it
    	ageField.addActionListener(new NumberValidationListener());
    	
// add a focus listener to both text fields
    	TextFieldFocusListener focusListener = new TextFieldFocusListener();
    	nameField.addFocusListener(focusListener); 	
    	ageField.addFocusListener(focusListener);
    	
// add the components to the frame
     	add(new JLabel("Type in your name and press Enter"));
     	add(nameField);
     	add(new JLabel("Type in your age and press Enter"));
     	add(ageField);
     	add(new JLabel());
     	add(closeButton);
    }
    
    public static void main(String[] args)
    {
        AgeInputWindow window = new AgeInputWindow();
        window.setTitle("Age Input Window");
        window.pack();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}