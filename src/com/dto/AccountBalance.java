package com.dto;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(balance, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountBalance other = (AccountBalance) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance) && id == other.id;
	}
	
	

}
