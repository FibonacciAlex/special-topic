
/**
 * Code example from "Foundational Java: Key Elements and Practical Programming 2nd Edition", Springer 2020
 * 
 * @author David Parsons
 *
 * Examples of String concatenation
 */

public class ConcatenationExample
{
	public static void main(String[] args)
	{
		// This code will print "The value of myVariable is 99" in the console.
		int myVariable = 99;
		System.out.println("The value of myVariable is " + myVariable);

		// You can also use the += operator as a shorthand for concatenating Strings, e.g.
		String greeting = "Happy birthday ";
		String message = greeting += "Mr. President";
		System.out.println(message);

		// with char data types the + operator will add the Unicode values of
		// the characters together (i.e. 97 + 98 + 99 = 294)
		System.out.println('a' + 'b' + 'c');

		// this will print "abc" because the first character is a String 
		// (note the double quotes), not a char
		System.out.println("a" + 'b' + 'c');
	}
}
