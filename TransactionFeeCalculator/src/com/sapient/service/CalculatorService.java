package com.sapient.service;

import com.sapient.dto.FileType;

public interface CalculatorService {
	
	void takeTransactionData(String filePath,FileType fileType);
	
	void processRules();
	
	String printSummaryReport();

}
