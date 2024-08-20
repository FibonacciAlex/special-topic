package Demo.Event;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming", London: Springer 2012
 * 
 * @author David Parsons
 * 
 * DrawMouseListener class - a MouseMotionListener to respond to mouse motion events by drawing filled squares if the mouse is dragged
 */

public class DrawMouseListener implements MouseMotionListener
{
	private Point position;
	private JFrame frame;
	
	public DrawMouseListener (JFrame frame)
	{
		this.frame  = frame;
	}
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
		position = e.getPoint();
		frame.getGraphics().fillRect(position.x, position.y, 5, 5);
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		// empty implementation
	}
}

