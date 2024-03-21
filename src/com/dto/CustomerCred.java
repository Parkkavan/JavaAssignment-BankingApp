package com.dto;

import java.time.LocalDate;

public class CustomerCred {
	private String firstName;
	private LocalDate dob;
	
	
	public CustomerCred() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomerCred(String firstName, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.dob = dob;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	@Override
	public String toString() {
		return "CustomerCred [firstName=" + firstName + ", dob=" + dob + "]";
	}
}
