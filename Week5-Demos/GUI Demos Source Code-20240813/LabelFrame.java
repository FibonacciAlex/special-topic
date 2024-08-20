package Demo.GUI;

import static javax.swing.SwingConstants.CENTER;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * LabelFrame class - demonstrates adding a JLabel to a frame
 */

public class LabelFrame extends JFrame
{
	// this line is needed to remove the warning about not having a serialVersionUID
	// the version number should be updated if the class is changed.
	private static final long serialVersionUID = 1L;

	private JLabel label;

	public LabelFrame(String title)
	{
		super(title);
		label = new JLabel("I am a label", CENTER);
		add(label);
	}

	public static void main(String[] args)
	{
		LabelFrame frame = new LabelFrame("Label Frame");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
