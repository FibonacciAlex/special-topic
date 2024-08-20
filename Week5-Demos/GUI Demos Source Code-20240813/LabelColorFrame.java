package Demo.GUI;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * LabelColorFrame class - demonstrates setting the colors of a Label component
 */

//objects of this class will not be Serialized, so this suppresses
//the warning about there being no serialVersionUID
@SuppressWarnings("serial")
public class LabelColorFrame extends JFrame
{
	public LabelColorFrame(String title)
	{
		super(title);
		this.setLayout(null);
		JLabel label = new JLabel("Name:");
		label.setOpaque(true);
		label.setForeground(Color.darkGray);
		label.setBackground(new Color(150, 210, 190));
		label.setBounds(10,10,100,50);
        add(label);
	}
		
    public static void main(String[] args)
    {
        LabelColorFrame frame = new LabelColorFrame("Label Frame");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	frame.setBounds(100,100,300,100);
    	frame.setVisible(true);
    }
}
