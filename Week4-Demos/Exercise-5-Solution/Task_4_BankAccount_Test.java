
/**
 * Code exercise from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * Tests the 'debit' method with its TransationException 
 */

public class Task_4_BankAccount_Test
{
	public static void main(String[] args)
	{
		BankAccount account = new BankAccount();
		
		 // Setting the original balance of the account
		account.setBalance(20);
		try
		{
			// making a number of debits until the exception is thrown
			account.debit(10);
			System.out.println("Balance is " + account.getBalance());
			account.debit(10);
			System.out.println("Balance is " + account.getBalance());
			account.debit(10);
			System.out.println("Balance is " + account.getBalance());
		}
		catch (TransactionException e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Executing finally block");
		}
	}
}
