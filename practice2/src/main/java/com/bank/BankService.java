package com.bank;

import java.util.Date;

public interface BankService {
	
	boolean createUser(User user);
	
	boolean openAccount(BankAccount account);
	
	boolean addAccountToUser(int userId,int accountNo);

	boolean debit(int accountNo, double amount);

	boolean credit(int accountNo, double amount);

	boolean transfer(int toAccountNo, int fromAccountNo, double amount);

	boolean deleteAccount(int toAccountNo);
	
	boolean deleteUser(int userID);

	boolean checkBalance(int accountNo);
	
	boolean getLastTenTransactions(int accountNo);

	boolean getTransactionsByDate(int accountNo,Date date);
	
	boolean getConsolidatedAmountForUser(int userID);
	
	
	
	//boolean getTransactionsByAmount(int accountNo,double amount);

}
