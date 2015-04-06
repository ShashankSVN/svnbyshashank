package com.sapient.dao;

import java.util.List;

import com.sapient.dto.Transaction;

public interface CalculatorDao {
	
	List<Transaction> getTransactions();
	

}
