package Demo.Event;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * GridBagScaler class - uses a GridBagLayout and GridBagConstraints with the components from the ImageScaler example
 */

//objects of this class will not be Serialized, so this suppresses
//the warning about there being no serialVersionUID
@SuppressWarnings("serial")
public class GridBagScaler extends JFrame
{
	private ScaledImagePanel scaledImagePanel;
	private JLabel heightLabel = new JLabel("Image Height");
	private JLabel widthLabel = new JLabel("Image Width");
	private JSlider heightSlider = new JSlider(SwingConstants.VERTICAL, 0, 1000, 400);
	private JSlider widthSlider = new JSlider(0, 1000, 400);

	GridBagScaler(String imageFilename)
	{
	// set up the GruidBagLayout
		setLayout(new GridBagLayout());
		scaledImagePanel = new ScaledImagePanel(imageFilename);
		
		GridBagConstraints widthLabelConstraints = new GridBagConstraints();
		widthLabelConstraints.gridx = 0;
		widthLabelConstraints.gridy = 0;
		widthLabelConstraints.gridwidth = 2;
		
		GridBagConstraints widthSliderConstraints = new GridBagConstraints();
		widthSliderConstraints.gridx = 0;
		widthSliderConstraints.gridy = 1;
		widthSliderConstraints.gridwidth = 2;
		widthSliderConstraints.fill = GridBagConstraints.HORIZONTAL;
		widthSliderConstraints.ipady = 20;
		
		GridBagConstraints heightLabelConstraints = new GridBagConstraints();
		heightLabelConstraints.gridx = 0;
		heightLabelConstraints.gridy = 4;
		heightLabelConstraints.gridwidth = 2;
		heightLabelConstraints.anchor = GridBagConstraints.WEST;
		
		GridBagConstraints heightSliderConstraints = new GridBagConstraints();
		heightSliderConstraints.gridx = 0;
		heightSliderConstraints.gridy = 3;
		heightSliderConstraints.anchor = GridBagConstraints.WEST;
		heightSliderConstraints.fill = GridBagConstraints.VERTICAL;
		heightSliderConstraints.ipadx = 20;
		
		GridBagConstraints scaledImagePanelConstraints = new GridBagConstraints();
		scaledImagePanelConstraints.gridx = 1;
		scaledImagePanelConstraints.gridy = 3;
		scaledImagePanelConstraints.weightx = 1.0;
		scaledImagePanelConstraints.weighty = 1.0;
		scaledImagePanelConstraints.fill = GridBagConstraints.BOTH;

		// add the components to the layout
		add(heightLabel, heightLabelConstraints);
		add(widthLabel, widthLabelConstraints);
		add(heightSlider, heightSliderConstraints);
		add(widthSlider, widthSliderConstraints);
		add(scaledImagePanel, scaledImagePanelConstraints);
		scaledImagePanel.setImageHeight(heightSlider.getValue());
		scaledImagePanel.setImageWidth(widthSlider.getValue());
		
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
		// add the ChangeListener to both sliders
		heightSlider.addChangeListener(sliderListener);
		widthSlider.addChangeListener(sliderListener);
		
		// Invert the vertical slider so it changes the size of the picture in the same direction as the slider
		heightSlider.setInverted(true);
	}

	public static void main(String[] args)
	{
		GridBagScaler scaler = new GridBagScaler("javacup_small.jpg");
		scaler.setTitle("Image Scaler");
		scaler.setBounds(500,500,500,500);
		scaler.setDefaultCloseOperation(EXIT_ON_CLOSE);
		scaler.setVisible(true);
	}
}
