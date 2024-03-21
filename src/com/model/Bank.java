package com.model;

import java.time.LocalDate;

public class Bank {
	 private int id; 
	 private String transaction_type;  
	 private double amount; 
	 private LocalDate transaction_date;  
	 private int account_id;

		public Bank() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Bank(int id, String transaction_type, double amount, LocalDate transaction_date, int account_id) {
			super();
			this.id = id;
			this.transaction_type = transaction_type;
			this.amount = amount;
			this.transaction_date = transaction_date;
			this.account_id = account_id;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTransaction_type() {
			return transaction_type;
		}

		public void setTransaction_type(String transaction_type) {
			this.transaction_type = transaction_type;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public LocalDate getTransaction_date() {
			return transaction_date;
		}

		public void setTransaction_date(LocalDate transaction_date) {
			this.transaction_date = transaction_date;
		}

		public int getAccount_id() {
			return account_id;
		}

		public void setAccount_id(int account_id) {
			this.account_id = account_id;
		}

		@Override
		public String toString() {
			return "Bank [id=" + id + ", transaction_type=" + transaction_type + ", amount=" + amount
					+ ", transaction_date=" + transaction_date + ", account_id=" + account_id + "]";
		}	
		
		
	 
}
