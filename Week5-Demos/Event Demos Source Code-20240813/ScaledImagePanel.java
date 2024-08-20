package Demo.Event;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * ScaledImagePanel class - demonstrates drawing an image with changeable height and width
 */

//objects of this class will not be Serialized, so this suppresses
//the warning about there being no serialVersionUID
@SuppressWarnings("serial")
public class ScaledImagePanel extends JPanel
{
	private int imageHeight = 1000;
	private int imageWidth = 1000;
	private String imageFilename;

	public ScaledImagePanel(String imageFilename)
	{
		setImageFilename(imageFilename);
	}
	
	public void setImageFilename(String imageFilename)
	{
		this.imageFilename = imageFilename;
	}

	public String getImageFilename()
	{
		return imageFilename;
	}	
	
	public Image getImage()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		return kit.getImage(getImageFilename());
	}
	
	public void setImageHeight(int height)
	{
		imageHeight = height;
		repaint();
	}


	public void setImageWidth(int width)
	{
		imageWidth = width;
		repaint();
	}
	
	public int getImageHeight()
	{
		return imageHeight;
	}

	public int getImageWidth()
	{
		return imageWidth;
	}
	
	// paint displays the scaled image
	public void paint(Graphics g)
	{
		// clear the background
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// display the image scaled
		g.drawImage(getImage(), 0, 0, getImageWidth(), getImageHeight(), this);
	}
}
