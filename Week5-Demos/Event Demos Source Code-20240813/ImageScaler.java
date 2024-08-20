package Demo.Event;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * ImageScaler class - hosts a ScaledImagePanel and an ImageControlPanel
 */

//objects of this class will not be Serialized, so this suppresses
//the warning about there being no serialVersionUID
@SuppressWarnings("serial")
public class ImageScaler extends JFrame
{
	private ImageControlPanel controlPanel;
	private ScaledImagePanel scaledImagePanel;

	public ImageScaler(String imageFilename)
	{
		setLayout(new BorderLayout());
		scaledImagePanel = new ScaledImagePanel(imageFilename);
		controlPanel = new ImageControlPanel(scaledImagePanel);
		controlPanel.setBounds(0, 20, 400, 80);
		scaledImagePanel.setBounds(0, 100, 500, 500);
		add(controlPanel, BorderLayout.NORTH);
		add(scaledImagePanel, BorderLayout.CENTER);
	}

	public static void main(String[] args)
	{
		ImageScaler scaler = new ImageScaler("javacup_small.jpg");
		scaler.setTitle("Image Scaler");
		scaler.setBounds(0, 0, 500, 500);
		scaler.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scaler.setVisible(true);
	}
}
