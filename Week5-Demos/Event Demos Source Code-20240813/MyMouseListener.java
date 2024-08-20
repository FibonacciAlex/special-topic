package Demo.Event;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * MyMouseListener class - a MouseListener to respond to mouse events
 */

public class MyMouseListener implements MouseListener
{
	private Point position;
	private JFrame frame;
	
	public MyMouseListener (JFrame c)
	{
		this.frame  = c;
	}
	
	@Override
	public void mousePressed(MouseEvent event)
	{
		position = event.getPoint();
		frame.getGraphics().drawString(position.x + "," + position.y, position.x, position.y);
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		System.out.println("clicked");
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		System.out.println("released");
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		frame.getContentPane().setBackground(Color.WHITE);
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
	}
}
