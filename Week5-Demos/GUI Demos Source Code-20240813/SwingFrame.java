package Demo.GUI;

import javax.swing.JFrame;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * SwingFrame class - demonstrates a simple Swing JFrame
 */

public class SwingFrame
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("My JFrame");
        //frame.setTitle("My JFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setBounds(0, 0, 500, 200); // or frame.pack();
    	frame.setVisible(true);
    }
}
