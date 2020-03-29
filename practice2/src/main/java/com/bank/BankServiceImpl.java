package com.bank;

import java.util.Date;

import com.bank.Transaction.TransactionType;

public class BankServiceImpl implements BankService {

	@Override
	public boolean openAccount(BankAccount account) {
		Bank.bankAccounts.put(account.getAccountNo(), account);
		account.getTransactions().add(
				new Transaction(new Date(), account.getBalance(),
						TransactionType.OPEN));
		System.out.println("Account open sucessfully for account no: "
				+ account.getAccountNo());
		return true;
	}

	@Override
	public boolean debit(int accountNo, double amount) {
		BankAccount account = Bank.bankAccounts.get(accountNo);
		synchronized (account) {
			if (account.getBalance() < amount) {
				System.out.println("balance is less which is equal to: "
						+ account.getBalance());
				account.getTransactions()
						.add(new Transaction(new Date(), amount,
								TransactionType.FAILED));

				return false;
			} else {
				account.setBalance(account.getBalance() - amount);
				account.getTransactions().add(
						new Transaction(new Date(), amount, TransactionType.DEBIT));
				return true;
			}
		}
		
	}

	@Override
	public boolean credit(int accountNo, double amount) {
		BankAccount account = Bank.bankAccounts.get(accountNo);
		synchronized (account) {
			account.setBalance(account.getBalance() + amount);
		}
		account.getTransactions().add(
				new Transaction(new Date(), amount, TransactionType.CREDIT));
		return true;

	}

	@Override
	public boolean transfer(int toAccountNo, int fromAccountNo, double amount) {

		if (debit(fromAccountNo, amount) && credit(toAccountNo, amount)) {
			System.out.println("transfer done");
			return true;

		} else {
			return false;
		}

	}

	@Override
	public boolean deleteAccount(int accountNo) {
		BankAccount account = Bank.bankAccounts.get(accountNo);
		synchronized (account) {
			if (account.getBalance() == 0.0) {
				Bank.bankAccounts.remove(accountNo);
				account.getTransactions().add(
						new Transaction(new Date(), 0.0, TransactionType.DELETE));
				System.out.println("Delete account Successfully");
				return true;
			} else {
				account.getTransactions().add(
						new Transaction(new Date(), 0.0, TransactionType.FAILED));
				System.out
						.println("Can not delete a account with non zero balance");
				return false;
			}
		}
	}

	@Override
	public boolean checkBalance(int accountNo) {
		BankAccount account = Bank.bankAccounts.get(accountNo);
		System.out.println("Current balance in account no: " + accountNo
				+ " is :" + account.getBalance());
		return true;
	}

	@Override
	public boolean getLastTenTransactions(int accountNo) {
		BankAccount account = Bank.bankAccounts.get(accountNo);
		int i=1;
		synchronized(account){
			for (Transaction transaction : account.getTransactions()) {
				System.out.println("Transaction date: " + transaction.getDate()
						+ " amount: " + transaction.getAmount() + " Type: "
						+ transaction.getTransactionType().toString());
				if(i==10)
				{
					break;
				}
				i++;
			}
		}
	
		return true;
	}

	@Override
	public boolean getTransactionsByDate(int accountNo, Date date) {

		return false;
	}

	@Override
	public boolean createUser(User user) {
		Bank.users.put(user.getUserId(), user);
		return true;
	}

	@Override
	public boolean addAccountToUser(int userId, int accountNo) {
		User user = Bank.users.get(userId);
		synchronized (user) {
			user.getAccounts().add(accountNo);
		}
		return false;
	}

	@Override
	public boolean deleteUser(int userID) {
		
		User user=Bank.users.get(userID);
		synchronized (user) {
			Bank.users.remove(userID);
		}
		System.out.println("User Deleted with id: "+ userID);
		return false;
	}

	@Override
	public boolean getConsolidatedAmountForUser(int userID) {
		User user = Bank.users.get(userID);
		double amount = 0;
		synchronized (user) {
			for (Integer accountNo : user.getAccounts()) {
				amount += Bank.bankAccounts.get(accountNo).getBalance();
			}
			System.out.println("Total amount for this user in all accounts: "
					+ amount);
		}
		
		return false;
	}

}
