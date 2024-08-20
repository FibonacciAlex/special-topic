
/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * Example generating a random number
 */

public class DieExample
{
	public static void main(String args[])
	{
		// generate a random number in the range 0.0 to 1.0
		double randomNumber = Math.random();
		
		// to get a number in the range 1 to 6, we need to multiply the
		// random number by 6 and add 1
		randomNumber *= 6;
		randomNumber++;
		
		// to convert this value into an integer we cast it
		int dieValue = (int) randomNumber;
		System.out.println(dieValue);
	}
}
