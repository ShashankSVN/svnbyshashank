package com.sapient.data;

import java.util.ArrayList;
import java.util.List;

import com.sapient.dto.Transaction;

public class CalculatorDatabase {
	
	private static CalculatorDatabase calculatorDatabase=new CalculatorDatabase();
	
	private CalculatorDatabase() {
	}
	
	List<Transaction> transactions=new ArrayList<Transaction>();

	public static CalculatorDatabase getCalculatorDatabase() {
		return calculatorDatabase;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}
	
	
}
