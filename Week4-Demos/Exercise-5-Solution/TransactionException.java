

/**
 * Code exercise from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * TransactionException class - example of a custom  exception
 */

public class TransactionException extends Exception
{

	public TransactionException()
	{
		// TODO Auto-generated constructor stub
	}

	public TransactionException(String message)
	{
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TransactionException(Throwable cause)
	{
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public TransactionException(String message, Throwable cause)
	{
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
