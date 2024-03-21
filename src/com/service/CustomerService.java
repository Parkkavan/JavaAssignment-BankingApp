package com.service;

import java.sql.SQLException;
import java.time.LocalDate;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.dto.AccountBalance;
import com.dto.AccountDetails;
import com.dto.AccountTypeBalance;
import com.exception.InsufficientFundException;
import com.exception.InvalidAccountException;
import com.exception.OverDraftLimitExcededException;

public class CustomerService {

	CustomerDao customerDao=new CustomerDaoImpl();
	public AccountBalance getAccBalance(int id) throws SQLException, InvalidAccountException {
		return customerDao.getAccBalance(id);
	}
	public AccountDetails getAccountDetails(int aid) throws SQLException, InvalidAccountException {
		return customerDao.getAccountDetails(aid);
	}
	public void isValidAccount(int accId) throws InvalidAccountException, SQLException {
		if(!(customerDao.isValidAccount(accId)))
		{
			throw new InvalidAccountException("Invalid Account Id");
		}
	}
	public String depositAmount(int accId, double amount) throws SQLException, InvalidAccountException {
		AccountBalance accBalance=customerDao.getAccBalance(accId);
		double currBalance=accBalance.getBalance();
		return customerDao.depositamount(accId,amount,currBalance);
	}
	public void updateTransaction(String accType, double amount, LocalDate date, int accId) throws SQLException {
		customerDao.updateTransaction(accType,amount,date,accId);
	}
	public String withdrawAmount(int accId, double amount) throws SQLException, InvalidAccountException, InsufficientFundException, OverDraftLimitExcededException {
		AccountTypeBalance accountTypeBalance=customerDao.fetchDetails(accId);
		String aType=accountTypeBalance.getAccType();
		Double balance=accountTypeBalance.getBalance();
		
		if(aType.equals("savings"))
		{
			if(balance-amount>=1000)
			{
				customerDao.withdrawAmount(accId,amount,balance);
			}
			else
			{
				throw new InsufficientFundException("There is no sufficient balance");
			}
		}
		if(aType.equals("current"))
		{
			throw new OverDraftLimitExcededException("Over Draft Limit Exceded");
		}
		if(aType.equals("zero_balance"))
		{
			if(balance>=amount)
			{
				customerDao.withdrawAmount(accId,amount,balance);
			}
			else
			{
				throw new InsufficientFundException("There is no sufficient balance");
			}
		}
		return "Withdrawal Successfull";
	}
}
