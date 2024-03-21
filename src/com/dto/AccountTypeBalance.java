package com.dto;

public class AccountTypeBalance {

	private String accType;
	private double balance;
	public AccountTypeBalance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountTypeBalance(String accType, double balance) {
		super();
		this.accType = accType;
		this.balance = balance;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "AccountTypeBalance [accType=" + accType + ", balance=" + balance + "]";
	}
	
	
	
}
