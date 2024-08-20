
import java.io.IOException;

/**
 * Code exercise from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 *
 * A reusable 'Keyboard' class
 */

public class Keyboard
{
	// getString reads a string from the keyboard
	public static String getString()
	{
		// byte array for input characters
		byte buffer[] = new byte[80];
		// declare a String reference with a default value (null)
		String tempString = null;
		// read characters into the byte array, handling IOExceptions if necessary
		try
		{
			System.in.read(buffer);
			// create a string from the characters
			tempString = new String(buffer);
			// trim the string
			tempString = tempString.trim();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		return tempString;
	}

	// this method gets a single char by reading a string and using only
	// the first character
	public static char getChar()
	{
		// byte array for input characters
		byte buffer[] = new byte[80];
		// declare a 'char' with a default value (space)
		char readChar = ' ';
		// read characters into the byte array, handling IOExceptions if necessary
		try
		{
			System.in.read(buffer);
			// create a string from the byte array
			String tempString = new String(buffer);
			// take the first character of the string and put it into
			// 'read_char'
			readChar = tempString.charAt(0);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		return readChar;
	}

	// the method gets an integer by converting a string
	public static int getInt()
	{
		// byte array for input characters
		byte buffer[] = new byte[80];
		// declare an int with a default value of zero
		int tempInt = 0;
		// read characters into the byte array, handling IOExceptions if necessary
		try
		{
			System.in.read(buffer);
			// create a string from the byte array
			String tempString = new String(buffer);
			// trim the string
			tempString = tempString.trim();
			// use the static 'parseInt' method of Integer to convert the String
			tempInt = Integer.parseInt(tempString);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		// if the characters are not numeric, catch the exception
		catch (NumberFormatException e)
		{
			System.out.println(e);
		}
		return tempInt;
	}
	
	// the method gets a double by converting a string
	public static double getDouble()
	{
		// byte array for input characters
		byte buffer[] = new byte[80];
		// declare an int with a default value of zero
		double tempDouble = 0.0;
		// read characters into the byte array, handling IOExceptions if necessary
		try
		{
			System.in.read(buffer);
			// create a string from the byte array
			String tempString = new String(buffer);
			// trim the string
			tempString = tempString.trim();
			// use the static 'parseDouble' method of Double to convert the String
			tempDouble = Double.parseDouble(tempString);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		// if the characters are not numeric, catch the exception
		catch (NumberFormatException e)
		{
			System.out.println(e);
		}
		return tempDouble;
	}
}