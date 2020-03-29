package com.sapient.main;

import com.sapient.dto.FileType;
import com.sapient.service.CalculatorService;
import com.sapient.service.CalculatorServiceImpl;

public class FeeCalculator {

	public static void main(String[] args) throws InterruptedException {
		
		CalculatorService calculatorService=CalculatorServiceImpl.getCalculatorService();
		String filePath="C:\\hCentive\\workspace\\Individual_508_Compliance\\TransactionFeeCalculator\\src\\com\\sapient\\file\\CommaDelimitedTransactionsData.txt";
		calculatorService.takeTransactionData(filePath, FileType.CommaDelimitedTextFile);
		calculatorService.processRules();
	System.out.println(calculatorService.printSummaryReport());

	}

}
