package com.model;

import java.time.LocalDate;

public class Customer {
	private int id;
	private String fistName;
	private String LastName;
	private LocalDate Dob;
	
	public Customer() {}

	public Customer(int id, String fistName, String lastName, LocalDate dob) {
		super();
		this.id = id;
		this.fistName = fistName;
		LastName = lastName;
		Dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public LocalDate getDob() {
		return Dob;
	}

	public void setDob(LocalDate dob) {
		Dob = dob;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fistName=" + fistName + ", LastName=" + LastName + ", Dob=" + Dob + "]";
	}
	
	
	
	
}
