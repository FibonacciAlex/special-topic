
/**
 * Code example from "Foundational Java: Key Elements and Practical Programming 2nd Edition", Springer 2020
 * 
 * @author David Parsons
 *
 * Example of using an array, precendence, promotion and typecasting
 */

public class ArrayPromotionTypecastingExample
{
	public static void main(String[] args)
	{
		int[] intArray = {3,4,6};
		
		// all of the examples below, apart from the one at the end, have issues!
		
		// this version fails to cater for either precedence or floating point numbers
		// int mean = intArray[0] + intArray[1] + intArray[2] / 3;

		// parentheses around the additions to ensure they are executed before the division, but still uses only integers
		// int mean = (intArray[0] + intArray[1] + intArray[2]) / 3;

		// floating point number as the result, but the calculation is still using integers
		// double mean = (intArray[0] + intArray[1] + intArray[2]) / 3;

		// promoting the literal number - right answer but using 'magic number'.
		// double mean = (intArray[0] + intArray[1] + intArray[2]) / 3.0;

		// try to use 'length' but lose the promotion
		// double mean = (intArray[0] + intArray[1] + intArray[2]) / intArray.length;

		// Finally, promote another operand instead to get correct result
		double mean = ((double)intArray[0] + intArray[1] + intArray[2]) / intArray.length;
		System.out.println(mean);
	}
}
