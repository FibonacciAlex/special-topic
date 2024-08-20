

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Code exercise from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * A Transaction class with getters and setters that implements the Serializable interface 
 */

public class Transaction implements Serializable
{
	static final long serialVersionUID = 1L;
	private int accountNumber;
	private double amount;
	private String transactionType;
	private LocalDate date;
	
	public int getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	public String getTransactionType()
	{
		return transactionType;
	}

	public void setTransactionType(String transactionType)
	{
		this.transactionType = transactionType;
	}

	public LocalDate getDate()
	{
		return date;
	}

	public void setDate(LocalDate date)
	{
		this.date = date;
	}

	// overrides toString()
	public String toString()
	{
		return "Account Number: " + getAccountNumber() + ", Amount: " + getAmount() + ", Type: " + getTransactionType() + ", Date: " + getDate();
	}
}
