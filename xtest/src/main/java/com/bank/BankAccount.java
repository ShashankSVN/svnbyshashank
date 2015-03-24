package com.bank;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

	private int accountNo;
	private String customerName;
	private double balance;
	
	private List<Transaction>  transactions=new ArrayList<Transaction>();
	
	

	public BankAccount(int accountNo, String customerName, double balance) {
		this.accountNo = accountNo;
		this.customerName = customerName;
		this.balance = balance;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
}
