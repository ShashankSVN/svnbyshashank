package com.sapient.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.sapient.dao.CalculatorDao;
import com.sapient.dao.CalculatorDaoImpl;
import com.sapient.dto.FileType;
import com.sapient.dto.Report;
import com.sapient.dto.Transaction;
import com.sapient.dto.TransactionType;

public class CalculatorServiceImpl implements CalculatorService {

	private CalculatorDao calculatorDao = CalculatorDaoImpl.getCalculatorDao();
	private static CalculatorService calculatorService = new CalculatorServiceImpl();

	private CalculatorServiceImpl() {
	}

	@Override
	public void takeTransactionData(String filePath, FileType fileType) {
		List<Transaction> transactions = calculatorDao.getTransactions();
		BufferedReader bufferedReader = null;
		try {
			String cvsSplitBy = ",";
			String line = "";
			bufferedReader = new BufferedReader(new FileReader(filePath));
			while ((line = bufferedReader.readLine()) != null) {
				String[] words = line.split(cvsSplitBy);
				transactions.add(createTransaction(words));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private Transaction createTransaction(String[] words) {

		int externalTransactionId = 0;
		String clientId = null;
		String securityId = null;
		TransactionType transactionType = null;
		Date transactionDate = null;
		double marketValue = 0;
		boolean priorityFlag = false;

		String extId = words[0];
		int beginIndex = 8;
		extId = extId.substring(beginIndex);
		externalTransactionId = Integer.valueOf(extId);
		clientId = words[1];
		securityId = words[2];
		String transType = words[3];
		switch (transType) {
		case "BUY":
			transactionType = TransactionType.Buy;
			break;
		case "SELL":
			transactionType = TransactionType.Sell;
			break;
		case "DEPOSIT":
			transactionType = TransactionType.Deposit;
			break;

		case "WITHDRAW":
			transactionType = TransactionType.Withdraw;
			break;

		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		try {
			transactionDate = dateFormat.parse(words[4]);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		marketValue = Double.valueOf(words[5]);
		switch (words[6]) {
		case "Y":
			priorityFlag = Boolean.TRUE;
			break;
		case "N":
			priorityFlag = Boolean.FALSE;
		}

		return new Transaction(externalTransactionId, clientId, securityId, transactionType, transactionDate, marketValue, priorityFlag);

	}

	@Override
	public void processRules() {

		List<Transaction> transactionsDB = calculatorDao.getTransactions();
		List<Transaction> list = new ArrayList<Transaction>(transactionsDB);
		Collections.sort(list);
		for (Transaction transaction : list) {
			int externalTransactionId = transaction.getExternalTransactionId();
			Transaction transactiondb=transactionsDB.get(externalTransactionId-1);
			if (transaction.isCanIntraday() == true) {
				transactiondb.setCanIntraday(true);
				transactiondb.setProcessingFee(10);
				
			}else if(transaction.isPriorityFlag()==true){
				transactiondb.setProcessingFee(500);
			}else if(transaction.getTransactionType().equals(TransactionType.Sell)||transaction.getTransactionType().equals(TransactionType.Withdraw)){
				transactiondb.setProcessingFee(100);
			}else{
				transactiondb.setProcessingFee(50);
			}
		}
	}

	@Override
	public String printSummaryReport() {
		List<Transaction> transactions = calculatorDao.getTransactions();
		List<Report> reports = new ArrayList<Report>();
		for (Transaction transaction : transactions) {
			Report report = new Report(transaction.getClientId(), transaction.getTransactionType(), transaction.getTransactionDate(),
					transaction.isPriorityFlag(), transaction.getProcessingFee());
			reports.add(report);
		}
		StringBuilder builder = new StringBuilder();
		Collections.sort(reports);
		for (Report report : reports) {
			builder.append(report);
			builder.append("\n");
		}
		return builder.toString();

	}

	public static CalculatorService getCalculatorService() {
		return calculatorService;
	}

}
