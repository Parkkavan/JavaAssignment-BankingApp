package com.dto;

public class AccountInterest {
	private int id;
	private double interest;
	public AccountInterest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountInterest(int id, double interest) {
		super();
		this.id = id;
		this.interest = interest;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	@Override
	public String toString() {
		return "AccountInterest [id=" + id + ", interest=" + interest + "]";
	}
	
}
