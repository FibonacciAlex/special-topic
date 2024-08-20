package Demo.GUI;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * MusicPlayerPanel class - a subclass of JPanel (will have a default FlowLayout)
 */

//objects of this class will not be Serialized, so this suppresses
//the warning about there being no serialVersionUID
@SuppressWarnings("serial")
public class MusicPlayerPanel extends JPanel
{
	public MusicPlayerPanel()
	{
// create components
		JLabel textLabel = new JLabel("Volume");
		JTextField textField = new JTextField("Now Playing....", 30);
		textField.setEditable(false);
		JSlider volume = new JSlider();
		JButton onButton = new JButton("On");
		JButton offButton = new JButton("Off");
		JCheckBox lockCheck = new JCheckBox("Lock");
		ButtonGroup radioButtons = new ButtonGroup();
		JRadioButton shuffle = new JRadioButton("Shuffle", true);
		JRadioButton continuous = new JRadioButton("Continuous");
		radioButtons.add(shuffle);
		radioButtons.add(continuous);

// add all the components to the panel
		add(textField);
		add(lockCheck);
		add(onButton);
		add(offButton);
		add(shuffle);
		add(continuous);
		add(textLabel);
		add(volume);
	}
}
