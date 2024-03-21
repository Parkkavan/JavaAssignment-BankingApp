package com.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.dto.AccountInterest;
import com.model.Account;

public interface BankDao {

	List<Account> fetchAllAccount() throws SQLException;

	List<AccountInterest> fetchAccountInterest() throws SQLException;

	void addCustomer(String fname, String lname, LocalDate dob) throws SQLException;

	int getCustomerId(String fname) throws SQLException;

	void updateAccounts(String accountType, Double balance, int cid) throws SQLException;
	
}
