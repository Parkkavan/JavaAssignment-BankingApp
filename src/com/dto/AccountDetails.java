package com.dto;

import java.time.LocalDate;

public class AccountDetails {

	private String firstName;
	private String lastName;
	private LocalDate dob;
	private int aid;
	private String accountType;
	private double balance;
	private int customerId;
	
	
	public AccountDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AccountDetails(String firstName, String lastName, LocalDate dob, int aid, String accountType, double balance,
			int customerId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.aid = aid;
		this.accountType = accountType;
		this.balance = balance;
		this.customerId = customerId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public int getAid() {
		return aid;
	}


	public void setAid(int aid) {
		this.aid = aid;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	@Override
	public String toString() {
		return "AccountDetails [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", aid=" + aid
				+ ", accountType=" + accountType + ", balance=" + balance + ", customerId=" + customerId + "]";
	}


	
	
	
	
	

}
