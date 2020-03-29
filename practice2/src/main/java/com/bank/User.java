package com.bank;

import java.util.ArrayList;
import java.util.List;

public class User {

	private int userId;
	private String userName;

	User(int userId, String userName) {
		this.userId = userId;
		this.userName = userName;

	}

	private List<Integer> accounts = new ArrayList<Integer>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Integer> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Integer> accounts) {
		this.accounts = accounts;
	}

}
