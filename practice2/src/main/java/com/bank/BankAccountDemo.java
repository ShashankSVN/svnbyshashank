package com.bank;

class T1 implements Runnable {
	BankAccount account;

	T1(BankAccount account) {
		this.account = account;
	}

	@Override
	public void run() {
		int i = 2;
		while (i != 0) {

			i--;
		}

	}

}

class T2 implements Runnable {
	BankAccount account;

	T2(BankAccount account) {
		this.account = account;
	}

	@Override
	public void run() {
		int i = 2;
		while (i != 0) {

			i--;
		}

	}

}

public class BankAccountDemo {

	public static void main(String[] args) throws InterruptedException {

		BankService bankService = new BankServiceImpl();
		User  user1=new User(101,"Mohan");
		bankService.createUser(user1);
		BankAccount account1 = new BankAccount(1001, "Mohan", 0.0);
		bankService.openAccount(account1);
		user1.getAccounts().add(1001);
		bankService.credit(1001, 10000);
		bankService.checkBalance(1001);
		bankService.debit(1001, 5000);
		bankService.checkBalance(1001);
		bankService.debit(1001, 6000);
		bankService.checkBalance(1001);
		bankService.deleteAccount(1001);
		bankService.debit(1001, 3000);
		bankService.checkBalance(1001);
		BankAccount account2 = new BankAccount(1002, "Mohan", 0.0);
		user1.getAccounts().add(1002);
		bankService.openAccount(account2);
		bankService.transfer(1002, 1001, 3000);
		bankService.transfer(1002, 1001, 2000);
		bankService.checkBalance(1001);
	//	bankService.deleteAccount(1001);
		bankService.checkBalance(1002);
		bankService.getConsolidatedAmountForUser(101);
		bankService.getLastTenTransactions(1001);
		
		bankService.deleteUser(101);
		
		
		Thread t1 = new Thread(new T1(account1));
		Thread t2 = new Thread(new T2(account1));
		t1.start();
		t2.start();
		t1.join();
		t2.join();

	}

}
