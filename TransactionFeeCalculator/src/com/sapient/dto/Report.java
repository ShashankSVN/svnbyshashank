package com.sapient.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Report implements Comparable<Report> {

	private String clientId;
	private TransactionType transactionType;
	private Date transactionDate;
	private boolean priorityFlag;
	private int processingFee;

	public Report(String clientId, TransactionType transactionType, Date transactionDate, boolean priorityFlag, int processingFee) {
		this.clientId = clientId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.priorityFlag = priorityFlag;
		this.processingFee = processingFee;
	}

	@Override
	public String toString() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		return "Report [clientId=" + clientId + ", transactionType=" + transactionType + ", transactionDate=" + dateFormat.format(transactionDate)
				+ ", priorityFlag=" + priorityFlag + ", processingFee=" + processingFee + "]";
	}

	@Override
	public int compareTo(Report o) {
		int i = this.clientId.compareTo(o.clientId);
		if (i == 0) {
			int j = this.transactionType.compareTo(o.transactionType);
			if (j == 0) {
				int k = this.transactionDate.compareTo(o.transactionDate);
				if (k == 0) {
					return (this.priorityFlag == true) ? 0 : -1;
				} else {
					return k;
				}
			} else {
				return j;
			}

		} else {
			return i;
		}
	}
}
