package Demo.GUI;

import javax.swing.JFrame;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * FlowLayoutWindow class - adds a MusicPlayerPanel (with a FlowLayout) to a JFrame
 */

//objects of this class will not be Serialized, so this suppresses
//the warning about there being no serialVersionUID
@SuppressWarnings("serial")
public class FlowLayoutWindow extends JFrame
{
	public FlowLayoutWindow()
	{
		MusicPlayerPanel playerPanel = new MusicPlayerPanel();
		add(playerPanel);
	}

	public static void main(String[] args)
	{
		FlowLayoutWindow window = new FlowLayoutWindow();
		window.setTitle("FlowLayout example");
		window.setBounds(0, 0, 600, 150);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
