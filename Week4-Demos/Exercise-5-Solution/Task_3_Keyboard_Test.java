

/**
 * Code exercise from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 *
 * Test the 'Keyboard' class
 */

public class Task_3_Keyboard_Test
{
	public static void main(String[] args)
	{
		System.out.print("Enter a single character ");
		char c = Keyboard.getChar();
		System.out.print("Enter a String ");
		String s = Keyboard.getString();
		System.out.print("Enter an integer ");
		int i = Keyboard.getInt();
		System.out.print("Enter a double ");
		double d = Keyboard.getDouble();
		System.out.println("Single character = " + c);
		System.out.println("String = " + s);
		System.out.println("Integer = " + i);
		System.out.println("Double = " + d);
	}
}
