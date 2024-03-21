package com.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.dao.BankDao;
import com.dao.BankDaoImpl;
import com.dto.AccountInterest;
import com.model.Account;

public class BankService {
	BankDao bankDao=new BankDaoImpl();
	public List<Account> fetchAllAccount() throws SQLException {
		return bankDao.fetchAllAccount();
	}
	public List<AccountInterest> fetchAccountInterest() throws SQLException {
		
		return bankDao.fetchAccountInterest();
	}
	public void addCustomer(String fname, String lname, LocalDate dob) throws SQLException {
		bankDao.addCustomer(fname,lname,dob);
	}
	public int getCustomerId(String fname) throws SQLException {
		return bankDao.getCustomerId(fname);
	}
	public void updateAccounts(String accountType, Double balance, int cid) throws SQLException {
		bankDao.updateAccounts(accountType,balance,cid);
	}

}
