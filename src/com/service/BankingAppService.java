package com.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.dto.CustomerCred;
import com.dao.BankingAppDao;
import com.dao.BankingAppDaoImpl;
import com.exception.InvalidCredentialsException;
import com.util.LoginUtil;

public class BankingAppService {

	BankingAppDao bankingAppDao=new BankingAppDaoImpl();
	public void verifyUsername(String userName) throws InvalidCredentialsException {
		if(!LoginUtil.verifyUsername(userName))
		{
			throw new InvalidCredentialsException("Invalid Credentials");
		}
	}

	public void verifyPassword(String userName, String password) throws InvalidCredentialsException {
		if(!LoginUtil.login(userName,password))
		{
			throw new InvalidCredentialsException("Invalid Credentials");
		}
	}


	public void verifyCustomer(String userName, LocalDate password) throws InvalidCredentialsException, SQLException {
		
		List<CustomerCred> list=bankingAppDao.fetchCustomerDetails();
		
		
		int flag=0;
		for(CustomerCred cd:list)
		{
			if(cd.getFirstName().equals(userName))
			{
				flag=1;
				int val=cd.getDob().compareTo(password);
				if(val!=0)
				{
					throw new InvalidCredentialsException("Invalid Credentials");
				}
			}
		}
		if(flag==0)
		{
			throw new InvalidCredentialsException("Invalid Credentials");
		}	
	}

}
