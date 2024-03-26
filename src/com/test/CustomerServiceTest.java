package com.test;

import com.dto.AccountBalance;
import com.dto.AccountDetails;
import com.exception.InvalidAccountException;
import com.service.CustomerService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Test;

public class CustomerServiceTest {
	
	CustomerService customerService=new CustomerService();
	
	@Test
	public void getAccBalanceTest()
	{

		/* Use case 1 : valid Id*/
		
		int id=1;
		
		AccountBalance expected=new AccountBalance(1,62000.0);
		
		try {
			Assert.assertEquals(expected,customerService.getAccBalance(id));
		} catch (SQLException | InvalidAccountException e) {}
		
		/* Use case 2 : Invalid Id*/
		
		id=19;
		try {
			Assert.assertEquals(expected,customerService.getAccBalance(id));
		} catch (SQLException | InvalidAccountException e) {
			Assert.assertEquals("Invalid Account ID".toLowerCase(),e.getMessage().toLowerCase());
		}
	}
	
	@Test
	public void getAccountDetailsTest()
	{
		/* Use case 1 : valid Id*/
		
		int id=2;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob=LocalDate.parse("2001-02-10", formatter);
		AccountDetails expected=new AccountDetails("ronald","weasley",dob,2,"current",55000.0,2);
		
		try {
			Assert.assertEquals(expected,customerService.getAccountDetails(id));
		} catch (SQLException | InvalidAccountException e) {}
		
		/* Use case 2 : Invalid Id*/
		
		id=35;
		try {
			Assert.assertEquals(expected,customerService.getAccountDetails(id));
		} catch (SQLException | InvalidAccountException e) {
			Assert.assertEquals("Invalid Account ID".toLowerCase(),e.getMessage().toLowerCase());
		}
	}
	
}
