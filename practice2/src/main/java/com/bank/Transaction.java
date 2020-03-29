package com.bank;

import java.util.Date;

public class Transaction {

	public enum TransactionType {
		OPEN, CREDIT, DEBIT, DELETE,FAILED
	}

	private TransactionType transactionType;


	private Date date;
	private double amount;

	public Transaction(Date date, double amount,TransactionType transactionType) {
		this.date = date;
		this.amount = amount;
		this.transactionType=transactionType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

}
