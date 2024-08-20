package com.foundjava.solutions.chapter9;

/**
 * Code exercise from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 */

public class BankAccount
{
	private double balance;

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	public void debit(double amount) throws TransactionException
	{
		if (this.getBalance() < amount)
		{
			throw new TransactionException("insufficient funds");
		}
		setBalance(getBalance() - amount);
	}
}
