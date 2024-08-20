
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Code exercise from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * Tutorial Task 1 (part 2)
 * 
 * read Transaction data from file
 */

public class Task1_DataInputStream_Read
{
	public static void main(String[] args)
	{
		System.out.println("Account Number\tAmount\tTransaction Type\tDate");
		try(var dataIn = new DataInputStream(new FileInputStream("transactions.dat")))
		{
			while (dataIn.available() > 0)
			{
				int accountNumber = dataIn.readInt();
				double amount = dataIn.readDouble();
				String transactionType = dataIn.readUTF();
				String date = dataIn.readUTF();
				DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("y-M-d");
				LocalDate parsedDate = LocalDate.parse(date, dateFormat);
				System.out.println(accountNumber + "\t\t\t" + amount + "\t"
						+ transactionType + "\t\t\t\t\t" + parsedDate);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
