package com.model;

import java.util.Objects;

public class Account {
	private int id;
	private String accountType;
	private Double balance;
	private int customerId;
	
	public Account() {}

	public Account(int id, String accountType, Double balance, int customerId) {
		super();
		this.id = id;
		this.accountType = accountType;
		this.balance = balance;
		this.customerId = customerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
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
		return "Account [id=" + id + ", accountType=" + accountType + ", balance=" + balance + ", customerId="
				+ customerId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountType, balance, customerId, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountType, other.accountType) && Objects.equals(balance, other.balance)
				&& customerId == other.customerId && id == other.id;
	}
	
	
	
}
