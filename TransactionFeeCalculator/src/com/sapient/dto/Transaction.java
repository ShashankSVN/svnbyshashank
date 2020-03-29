package com.sapient.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction implements Comparable<Transaction> {

	private int externalTransactionId;
	private String clientId;
	private String securityId;
	private TransactionType transactionType;
	private Date transactionDate;
	private double marketValue;
	private boolean priorityFlag;
	private int processingFee;
	private boolean canIntraday;

	public boolean isCanIntraday() {
		return canIntraday;
	}

	public void setCanIntraday(boolean canIntraday) {
		this.canIntraday = canIntraday;
	}

	public Transaction(int externalTransactionId, String clientId, String securityId, TransactionType transactionType, Date transactionDate,
			double marketValue, boolean priorityFlag) {
		this.externalTransactionId = externalTransactionId;
		this.clientId = clientId;
		this.securityId = securityId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.marketValue = marketValue;
		this.priorityFlag = priorityFlag;
	}

	public int getProcessingFee() {
		return processingFee;
	}

	public void setProcessingFee(int processingFee) {
		this.processingFee = processingFee;
	}

	public int getExternalTransactionId() {
		return externalTransactionId;
	}

	public String getClientId() {
		return clientId;
	}

	public String getSecurityId() {
		return securityId;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public double getMarketValue() {
		return marketValue;
	}

	public boolean isPriorityFlag() {
		return priorityFlag;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		return "Transaction [externalTransactionId=" + externalTransactionId + ", clientId=" + clientId + ", securityId=" + securityId + ", transactionType="
				+ transactionType + ", transactionDate=" + dateFormat.format(transactionDate) + ", marketValue=" + marketValue + ", priorityFlag="
				+ priorityFlag + ", processingFee=" + processingFee + "]";
	}

	@Override
	public int compareTo(Transaction o) {
		int i = this.clientId.compareTo(o.clientId);
		if (i == 0) {
			int j = this.securityId.compareTo(o.securityId);
			if (j == 0) {
				int k = this.transactionDate.compareTo(o.transactionDate);
				if (k == 0) {
					if(this.transactionType==TransactionType.Buy&&o.transactionType==TransactionType.Sell)
					{
						this.canIntraday=true;
						o.canIntraday=true;
					}
					else if(this.transactionType==TransactionType.Sell&&o.transactionType==TransactionType.Buy)
					{
						this.canIntraday=true;
						o.canIntraday=true;
					}
				} 
				return k;
			} else {
				return j;
			}

		} else {
			return i;
		}
	}

}
