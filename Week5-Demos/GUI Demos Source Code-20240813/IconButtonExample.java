package Demo.GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * IconButtonExample class - demonstrates adding an image to a JButton
 */

public class IconButtonExample
{
    public static void main(String[] args)
    {
       JFrame frame = new JFrame();
       JButton button = new JButton("Foundational Java", new ImageIcon("javacup_small.jpg"));
       button.setHorizontalTextPosition(SwingConstants.CENTER);
       button.setVerticalTextPosition(SwingConstants.TOP);
       button.setFont(new Font("helvetica", Font.PLAIN ,40));
       button.setForeground(Color.red);
       frame.add(button);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.pack();
       frame.setVisible(true);
    }
}
