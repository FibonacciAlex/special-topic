package Demo.GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * ColorAndFontExample class - demonstrates changing the colors and font of a JTextField
 */
//objects of this class will not be Serialized, so this suppresses
//the warning about there being no serialVersionUID
@SuppressWarnings("serial")
public class ColorAndFontExample extends JFrame
{
	public ColorAndFontExample()
	{
		JTextField field = new JTextField();
		field.setBackground(Color.black);
		field.setForeground(Color.white);
		field.setFont(new Font("Courier", Font.ITALIC | Font.BOLD, 20));
		add(field);
	}

	public static void main(String[] args)
	{
		ColorAndFontExample frame = new ColorAndFontExample();
		frame.setBounds(100,100,200,100);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
