
/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 *
 * Demonstrates iterating through an array using a 'for' loop
 */

public class ArrayForLoopExample
{
	public static void main(String[] args)
	{
		String[] monthNames = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		int[] monthlyRainfall = {74,81,86,93,100,116,126,111,93,80,84,91};
		System.out.println("Average monthly rainfall");
		for(int i = 0; i < monthlyRainfall.length; i++)
		{
			System.out.println(monthNames[i] + ": " + monthlyRainfall[i] + "mm.");
		}
	}
}
