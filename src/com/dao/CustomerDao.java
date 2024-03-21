package com.dao;

import java.sql.SQLException;
import java.time.LocalDate;

import com.dto.AccountBalance;
import com.dto.AccountDetails;
import com.dto.AccountTypeBalance;
import com.exception.InvalidAccountException;

public interface CustomerDao {

	AccountBalance getAccBalance(int id) throws SQLException, InvalidAccountException;

	AccountDetails getAccountDetails(int aid) throws SQLException, InvalidAccountException;

	boolean isValidAccount(int accId) throws SQLException;

	String depositamount(int accId, double amount, double currBalance) throws SQLException;

	void updateTransaction(String accType, double amount, LocalDate date, int accId) throws SQLException;

	AccountTypeBalance fetchDetails(int accId) throws SQLException, InvalidAccountException;

	void withdrawAmount(int accId, double amount, Double balance) throws SQLException;

	

	
	
}
