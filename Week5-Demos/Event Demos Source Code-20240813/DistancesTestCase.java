package Demo.Event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * DistancesTestCase class - JUnit test case for the FlightDistances class
 */

public class DistancesTestCase
{
	@Test
	public void testGetZeroDistance()
	{
		int distance = FlightDistances.getDistance(0, 0);
		assertEquals(0, distance);
	}
	
	@Test
	public void testGetValidDistance()
	{
		int distance = FlightDistances.getDistance(1, 2);
		assertEquals(4695, distance);
	}
	
	@Test
	public void testGetValidDistanceHigherFirstIndex()
	{
		int distance = FlightDistances.getDistance(2, 1);
		assertEquals(4695, distance);
	}
	
	@Test
	public void testInvalidIndex()
	{
		int distance = FlightDistances.getDistance(10, 1);
		assertEquals(-1, distance);
	}
	
	@Test
	public void testGetCitiesArray()
	{
		String[] cities = FlightDistances.getCities();
		assertNotNull(cities);
	}
	
	@Test
	public void testGetCities()
	{
		String[] cities = FlightDistances.getCities();
		assertEquals("Tokyo", cities[9]);
	}
}
