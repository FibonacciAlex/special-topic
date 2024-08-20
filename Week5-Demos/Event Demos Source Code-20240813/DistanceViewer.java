package Demo.Event;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * DistanceViewer class - view class that uses the FlightDistances class as its model
 */

//objects of this class will not be Serialized, so this suppresses
//the warning about there being no serialVersionUID
@SuppressWarnings("serial")
public class DistanceViewer extends JFrame
{
	private JComboBox<String> fromCity;
	private JComboBox<String> toCity;
	// declare text labels for dynamic update
	private JLabel resultLabel;

	public DistanceViewer()
	{
		// get an array of city names and populate two combo boxes
		String[] cities = FlightDistances.getCities();
		fromCity = new JComboBox<String>(cities);
		toCity = new JComboBox<String>(cities);

		// add ActionListeners to respond to JComboBox events
		ActionListener cityListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				showDistance(fromCity.getSelectedIndex(), toCity.getSelectedIndex());
			}
		};
		fromCity.addActionListener(cityListener);
		toCity.addActionListener(cityListener);

		// configure the layout manager
		setLayout(new GridBagLayout());
		GridBagConstraints line2Constraints = new GridBagConstraints();
		line2Constraints.gridy = 1;
		GridBagConstraints labelConstraints = new GridBagConstraints();
		labelConstraints.gridwidth = 3;
		
		// create the text labels for the choices
		JLabel fromLabel = new JLabel("From:");
		JLabel toLabel = new JLabel("To:");
		// create and add the text label for the result
		JLabel distanceLabel = new JLabel("The distance between the cities is");
		// create a text label to display the result
		resultLabel = new JLabel("0");		
		
		// add these components to the frame
		add(distanceLabel, labelConstraints);		
		add(resultLabel);
		add(fromLabel, line2Constraints);
		add(fromCity, line2Constraints);
		add(toLabel, line2Constraints);
		add(toCity, line2Constraints);
	}

	private void showDistance(int fromCity, int toCity)
	{
		int distance = FlightDistances.getDistance(fromCity, toCity);
		String measureString = " miles";
		resultLabel.setText(distance + measureString);
	}

	public static void main(String[] args)
	{
		DistanceViewer viewer = new DistanceViewer();
		viewer.setTitle("Mileage table between major cities");
		viewer.setDefaultCloseOperation(EXIT_ON_CLOSE);
		viewer.setBounds(100, 100, 500, 150);
		viewer.setVisible(true);
	}
}
