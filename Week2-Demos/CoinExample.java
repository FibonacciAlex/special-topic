
/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * Example of an 'if...else' statement
 */

public class CoinExample
{
	public static void main(String[] args)
	{
		// generate a random number between 0.0 and 1.0
		double randomNumber = Math.random();
		
		// use the random number in an 'if' statement to display the face of the coin
		if (randomNumber < 0.5)
		{
			System.out.println("The coin shows heads");
		}
		else
		{
			System.out.println("The coin shows tails");
		}
	}
}
