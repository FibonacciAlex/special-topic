

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Code exercise from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * Tutorial Task 1 (part 1)
 * 
 * Write Transaction data to file
 */

public class Task1_DataOutputStream_Write
{
	public static void main(String[] args)
	{
		LocalDate date = null;
		try(var dataOut = new DataOutputStream(new FileOutputStream("transactions.dat")))
		{
			dataOut.writeInt(1009876);
			dataOut.writeDouble(145.50);
			dataOut.writeUTF("DR");
			date = LocalDate.of(2012, 12, 03);
			dataOut.writeUTF(date.toString());

			dataOut.writeInt(1876253);
			dataOut.writeDouble(1267.00);
			dataOut.writeUTF("CR");
			date = LocalDate.of(2012, 11, 30);
			dataOut.writeUTF(date.toString());

			dataOut.writeInt(1192873);
			dataOut.writeDouble(45.30);
			dataOut.writeUTF("CR");
			date = LocalDate.of(2012, 02, 15);
			dataOut.writeUTF(date.toString());

			System.out.println("Data written to file");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
