package com.sapient.dao;

import java.util.List;

import com.sapient.data.CalculatorDatabase;
import com.sapient.dto.Transaction;

public class CalculatorDaoImpl implements CalculatorDao {

	private static CalculatorDao calculatorDao = new CalculatorDaoImpl();

	private CalculatorDaoImpl() {
	}

	private CalculatorDatabase calculatorDatabase = CalculatorDatabase.getCalculatorDatabase();

	@Override
	public List<Transaction> getTransactions() {
		return calculatorDatabase.getTransactions();
	}

	public static CalculatorDao getCalculatorDao() {
		return calculatorDao;
	}

}
