package Demo.Event;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * FlightDistances class - represents a table of flight distances between cities. Acts as an underlying model for a view class
 */

public class FlightDistances
{
	private static final String[] cities = { "Auckland", "Beijing", "Cairo",
			"Cape Town", "London", "Mumbai", "New York", "Rio De Janeiro",
			"Sydney", "Tokyo" };
	// declare a two-dimensional array of integers
	private static final int[][] distanceTable;

	// the static block creates the array and fills it with data
	static
	{
		// create a 10 by 10 array
		distanceTable = new int[10][10];
		// where the two indexes are the same, the distance is zero because the
		// origin and destination are the same city
		for (int i = 0; i < 10; i++)
		{
			distanceTable[i][i] = 0;
		}

		distanceTable[0][1] = 6455; // Auckland <-> Beijing
		distanceTable[0][2] = 10298;// Auckland <-> Cairo
		distanceTable[0][3] = 7329; // Auckland <-> Cape Town
		distanceTable[0][4] = 11389;// Auckland <-> London
		distanceTable[0][5] = 7640; // Auckland <-> Mumbai
		distanceTable[0][6] = 8815; // Auckland <-> New York
		distanceTable[0][7] = 7635; // Auckland <-> Rio De Janeiro
		distanceTable[0][8] = 1342; // Auckland <-> Sydney
		distanceTable[0][9] = 5474; // Auckland <-> Tokyo

		distanceTable[1][2] = 4695; // Beijing <-> Cairo
		distanceTable[1][3] = 8044; // Beijing <-> Cape Town
		distanceTable[1][4] = 5070; // Beijing <-> London
		distanceTable[1][5] = 2957; // Beijing <-> Mumbai
		distanceTable[1][6] = 6842; // Beijing <-> New York
		distanceTable[1][7] = 10764;// Beijing <-> Rio De Janeiro
		distanceTable[1][8] = 5545; // Beijing <-> Sydney
		distanceTable[1][9] = 1307; // Beijing <-> Tokyo

		distanceTable[2][3] = 4479; // Cairo <-> Cape Town
		distanceTable[2][4] = 2183; // Cairo <-> London
		distanceTable[2][5] = 2710; // Cairo <-> Mumbai
		distanceTable[2][6] = 5618; // Cairo <-> New York
		distanceTable[2][7] = 6140; // Cairo <-> Rio De Janeiro
		distanceTable[2][8] = 8958; // Cairo <-> Sydney
		distanceTable[2][9] = 5957; // Cairo <-> Tokyo

		distanceTable[3][4] = 5987; // Cape Town <-> London
		distanceTable[3][5] = 5105; // Cape Town <-> Mumbai
		distanceTable[3][6] = 7799; // Cape Town <-> New York
		distanceTable[3][7] = 3775; // Cape Town <-> Rio De Janeiro
		distanceTable[3][8] = 6856; // Cape Town <-> Sydney
		distanceTable[3][9] = 9156; // Cape Town <-> Tokyo

		distanceTable[4][5] = 4476; // London <-> Mumbai
		distanceTable[4][6] = 3471; // London <-> New York
		distanceTable[4][7] = 5750; // London <-> Rio De Janeiro
		distanceTable[4][8] = 10558; // London <-> Sydney
		distanceTable[4][9] = 5956; // London <-> Tokyo

		distanceTable[5][6] = 7807; // Mumbai <-> New York
		distanceTable[5][7] = 8338; // Mumbai <-> Rio De Janeiro
		distanceTable[5][8] = 6306; // Mumbai <-> Sydney
		distanceTable[5][9] = 4194; // Mumbai <-> Tokyo

		distanceTable[6][7] = 4803; // New York <-> Rio De Janeiro
		distanceTable[6][8] = 9934; // New York <-> Sydney
		distanceTable[6][9] = 6755; // New York <-> Tokyo

		distanceTable[7][8] = 8412; // Rio De Janeiro <-> Sydney
		distanceTable[7][9] = 11532; // Rio De Janeiro <-> Tokyo

		distanceTable[8][9] = 4842; // Sydney <-> Tokyo
	}

	// given integers to represent airports in the table, this method
	// returns the distance between them
	public static int getDistance(int origin, int destination)
	{
		try
		{
			if (origin < destination)
			{
				return distanceTable[origin][destination];
			}
			else
			{
				return distanceTable[destination][origin];
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.err.println("Invalid origin or destination index " + origin
					+ " or " + destination);
			return -1;
		}
	}

	public static String[] getCities()
	{
		return cities;
	}
}
