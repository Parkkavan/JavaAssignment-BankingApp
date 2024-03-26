package com.dto;

import java.util.Objects;

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
	@Override
	public int hashCode() {
		return Objects.hash(id, interest);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountInterest other = (AccountInterest) obj;
		return id == other.id && Double.doubleToLongBits(interest) == Double.doubleToLongBits(other.interest);
	}
	
	
	
	
}
