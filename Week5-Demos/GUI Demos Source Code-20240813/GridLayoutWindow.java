package Demo.GUI;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * GridLayoutWindow class - adds a MusicPlayerPanel with a GridLayout to a JFrame
 */

//objects of this class will not be Serialized, so this suppresses
//the warning about there being no serialVersionUID
@SuppressWarnings("serial")
public class GridLayoutWindow extends JFrame
{
	public GridLayoutWindow()
	{
		MusicPlayerPanel playerPanel = new MusicPlayerPanel();
// set the layout of the hosted JPanel using a 'GridLayout'. this
// constructor is passed the number of rows and columns. passing
// '0' for the number of rows means that it will be automatically
// calculated from the number of columns and components
		playerPanel.setLayout(new GridLayout(0, 2));
		add(playerPanel);
	}

	public static void main(String[] args)
	{
		GridLayoutWindow window = new GridLayoutWindow();
		window.setTitle("GridLayout example");
		window.pack();
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);

	}
}

