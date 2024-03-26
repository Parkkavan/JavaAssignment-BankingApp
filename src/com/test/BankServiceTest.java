package com.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.AccountInterest;
import com.model.Account;
import com.service.BankService;

import org.junit.Assert;
import org.junit.Test;

public class BankServiceTest {

	BankService bankService=new BankService();
	
	@Test
	public void fetchAllAccountTest()
	{
		List<Account> list=new ArrayList<>();
		Account a1=new Account(1,"savings",62000.0,1);
		Account a2=new Account(2,"current",55000.0,2);
		Account a3=new Account(3,"zero_balance",100000.0,3);
		Account a4=new Account(4,"current",150000.0,1);
		Account a5=new Account(5,"savings",58000.0,3);
		Account a6=new Account(6,"zero_balance",50000.0,4);
		Account a7=new Account(7,"savings",45000.0,7);
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
		list.add(a6);
		list.add(a7);
		try {
			Assert.assertEquals(list,bankService.fetchAllAccount());
		} catch (SQLException e) {}
	}
	
	
	@Test
	public void fetchAccountInterestTest()
	{
		List<AccountInterest> list=new ArrayList<>();
		AccountInterest ai1=new AccountInterest(1,2790.0);
		AccountInterest ai2=new AccountInterest(2,2475.0);
		AccountInterest ai3=new AccountInterest(3,4500.0);
		AccountInterest ai4=new AccountInterest(4,6750.0);
		AccountInterest ai5=new AccountInterest(5,2610.0);
		AccountInterest ai6=new AccountInterest(6,2250.0);
		AccountInterest ai7=new AccountInterest(7,2025.0);
		
		list.add(ai1);
		list.add(ai2);
		list.add(ai3);
		list.add(ai4);
		list.add(ai5);
		list.add(ai6);
		list.add(ai7);
		
		try {
			Assert.assertEquals(list,bankService.fetchAccountInterest());
		} catch (SQLException e) {}
		
	}
}
