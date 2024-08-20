

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Code exercise from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * Test writing and reading Transaction objects
 */

public class Task_2_Transaction_Test
{
	private Transaction writeTransaction;
	private Transaction readTransaction;
	
	@BeforeEach
	public void setUp() throws Exception
	{
	// initialize the Transaction to be written
		writeTransaction = new Transaction();
		writeTransaction.setAccountNumber(1001);
		writeTransaction.setAmount(45.5);
		writeTransaction.setTransactionType("CR");
		LocalDate date = LocalDate.of(2012,01,12);
		writeTransaction.setDate(date);
	}
	
	// Writes a Transaction object to a file and then reads it back again, testing that the state of the object has been correctly restored from the file. 
	@Test
	public void testTransactionWrite()
	{
		try(var objectOut = new ObjectOutputStream(new FileOutputStream("transobject.dat")))
	    {
          objectOut.writeObject(writeTransaction);
          assertNotNull(writeTransaction);
          objectOut.close();
	    }
	    catch(FileNotFoundException e)
	    {
			e.printStackTrace();
	    }
	    catch(IOException e)
	    {
			e.printStackTrace();
	    }
	}
	
	// Reads a Transaction object from a file, testing that the state of the object has been correctly restored from the file. 
		@Test
		public void testTransactionRead()
		{
		    try(var objectIn = new ObjectInputStream(new FileInputStream("transobject.dat")))
		    {
		      readTransaction = (Transaction)objectIn.readObject();	
		      System.out.println(readTransaction);
		      assertEquals(1001,readTransaction.getAccountNumber());
		      assertEquals(45.5,readTransaction.getAmount(), 0);
		      assertEquals("CR",readTransaction.getTransactionType());
		      LocalDate date = LocalDate.of(2012,01,12);
		      assertEquals(date,readTransaction.getDate());
	          objectIn.close();
		    }
		    catch(FileNotFoundException e)
		    {
				e.printStackTrace();
		    }
		    catch(IOException e)
		    {
				e.printStackTrace();
		    }
		    catch (ClassNotFoundException e)
		    {
				e.printStackTrace();
			}
		    catch (Exception e)
		    {
				e.printStackTrace();
			}
		}
	
// JUnit test for the toString method
	@Test
	public void testToString()
	{
		// test against the 'writeTransaction' which has been set up in the @Before method
		assertEquals("Account Number: 1001, Amount: 45.5, Type: CR, Date: 2012-01-12", writeTransaction.toString());
	}
}
