package com.dto;

public class AccountBalance {

	private int id;
	private double balance;
	
	public AccountBalance() {}

	public AccountBalance(int id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountBalance [id=" + id + ", balance=" + balance + "]";
	}
	
	

}
