package Demo.Event;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * GridBagWindow class - demonstrates a GridBagLayout and GridBagConstraints
 */

//objects of this class will not be Serialized, so this suppresses
//the warning about there being no serialVersionUID
@SuppressWarnings("serial")
public class GridBagWindow extends JFrame
{
	// constructor
	public GridBagWindow()
	{
		// set the layout of the window
		setLayout(new GridBagLayout());
		
		// create the components:
		// a text label
		JLabel textLabel = new JLabel("Station Presets");
		
		// a dropdown list
//		JComboBox presets = new JComboBox();
//		presets.addItem("Radio 1");
//		presets.addItem("Radio 2");
//		presets.addItem("Radio 3");
//		presets.addItem("Radio 4");
		JComboBox<String> presets = new JComboBox<String>();
		presets.addItem("Radio 1");
		presets.addItem("Radio 2");
		presets.addItem("Radio 3");
		presets.addItem("Radio 4");
		// a text area
		JTextArea textArea = new JTextArea();
		
		// two buttons
		JButton onButton = new JButton("On");
		JButton offButton = new JButton("Off");
		
		// add all the components to the window. each has its own constraints object.
		
		// the text label constraints are position and insets
		GridBagConstraints textLabelConstraints = new GridBagConstraints();

		//The constraints set the position of the component on the underlying grid. The top left cell of the grid is 0, 0:
		textLabelConstraints.gridx = 0;
		textLabelConstraints.gridy = 0;
		// The “insets” constraint is an object of the Insets class that is used to represent the margins around a component.
		textLabelConstraints.insets = new Insets(4, 4, 4, 4);
		add(textLabel, textLabelConstraints);

		// the JComboBox constraints are position, insets, spanning two columns
		// and filling those columns horizontally
		GridBagConstraints presetsConstraints = new GridBagConstraints();
		presetsConstraints.gridx = 1;
		presetsConstraints.gridy = 0;
		presetsConstraints.insets = new Insets(4, 4, 4, 4);
		presetsConstraints.gridwidth = 2;
		//The “fill” constraint defines how a component fills the available space within its cell.
		presetsConstraints.fill = GridBagConstraints.HORIZONTAL;
		add(presets, presetsConstraints);

		// the text area constraints are position, insets, spanning two
		// columns and two rows and filling both rows and columns.
		// this component is also given a weighting to help adjust all
		// components to the frame
		GridBagConstraints textAreaConstraints = new GridBagConstraints();
		textAreaConstraints.gridx = 0;
		textAreaConstraints.gridy = 1;
		textAreaConstraints.insets = new Insets(4, 4, 4, 4);
		textAreaConstraints.gridwidth = 2;
		textAreaConstraints.gridheight = 2;
		textAreaConstraints.fill = GridBagConstraints.BOTH;
		textAreaConstraints.weightx = 1;
		textAreaConstraints.weighty = 1;
		add(textArea, textAreaConstraints);

		// the constraints on the buttons are position, insets and padding.
		GridBagConstraints onButtonConstraints = new GridBagConstraints();
		onButtonConstraints.gridx = 2;
		onButtonConstraints.gridy = 1;
		onButtonConstraints.insets = new Insets(4, 4, 4, 4);
		onButtonConstraints.ipadx = 20;
		onButtonConstraints.ipady = 10;
		add(onButton, onButtonConstraints);

		// in addition, the 'off' button is anchored to the top (north)
		// of its cell
		GridBagConstraints offButtonConstraints = new GridBagConstraints();
		offButtonConstraints.gridx = 2;
		offButtonConstraints.gridy = 2;
		// The “anchor” constraint controls the position of the component within its cell, provided it does not already fill the cell.
		offButtonConstraints.anchor = GridBagConstraints.NORTH;
		offButtonConstraints.insets = new Insets(4, 4, 4, 4);
		offButtonConstraints.ipadx = 20;
		offButtonConstraints.ipady = 10;
		add(offButton, offButtonConstraints);
	}

	public static void main(String[] args)
	{
		GridBagWindow window = new GridBagWindow();
		window.setTitle("GridBagLayout example");
		window.pack();
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
