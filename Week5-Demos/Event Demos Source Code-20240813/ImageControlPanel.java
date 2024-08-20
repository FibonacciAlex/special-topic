package Demo.Event;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * ImageControlPanel class - demonstrates a ChangeListener that uses sliders to scale an image on another panel
 */

//objects of this class will not be Serialized, so this suppresses
//the warning about there being no serialVersionUID
@SuppressWarnings("serial")
public class ImageControlPanel extends JPanel
{
	private JLabel heightLabel = new JLabel("Image Height:");
	private JLabel widthLabel = new JLabel("Image Width:");
	private JSlider heightSlider = new JSlider(0, 1000, 500);
	private JSlider widthSlider = new JSlider(0, 1000, 500);
	// a reference to the other panel so it can be updated
	private ScaledImagePanel scaledImagePanel;

	// constructor - receives a reference to the scaled image panel
	ImageControlPanel(ScaledImagePanel panel)
	{
		GridLayout layout = new GridLayout(2, 0);
		setLayout(layout);
		scaledImagePanel = panel;
		add(heightLabel);
		add(widthLabel);
		add(heightSlider);
		add(widthSlider);
		scaledImagePanel.setImageHeight(heightSlider.getValue());
		scaledImagePanel.setImageWidth(widthSlider.getValue());
		
		// inner class implements the ChangeListener
		ChangeListener sliderListener = new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent e)
			{
				if(e.getSource().equals(heightSlider))
				{
					scaledImagePanel.setImageHeight(heightSlider.getValue());
				}
				else
				{
					scaledImagePanel.setImageWidth(widthSlider.getValue());
				}
			}
		};
		// same listener applied to both sliders
		heightSlider.addChangeListener(sliderListener);
		widthSlider.addChangeListener(sliderListener);
	}
}
