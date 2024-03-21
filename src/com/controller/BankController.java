package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.dto.AccountInterest;
import com.model.Account;
import com.service.BankService;

public class BankController {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		BankService bankService=new BankService();
		while(true)
		{
			System.out.println("Press 1. Create customer account");
			System.out.println("Press 2. List All Accounts");
			System.out.println("Press 3. Calculate Interest");
			System.out.println("Press 0. Exit");
			System.out.println();
			System.out.println("Enter your choice");
			int input=s.nextInt();
			if(input==0)
			{
				System.out.println("Exiting,Thank you");
				break;
			}
			switch(input)
			{
				case 1:
					System.out.println("Enter the first name of the customer");
					String fname=s.next();
					System.out.println("Enter the last name of the customer");
					String lname=s.next();
					System.out.println("Enter the DOB of the customer");
					String date=s.next();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate dob=LocalDate.parse(date, formatter);
					System.out.println("Enter the accountType of the customer");
					String accountType=s.next();
					System.out.println("Enter the balance of the customer");
					Double balance=s.nextDouble();
					try {
						bankService.addCustomer(fname, lname, dob);
						int cid=bankService.getCustomerId(fname);
						bankService.updateAccounts(accountType,balance,cid);
						System.out.println("Customer Added");
						System.out.println("Accounts Updated");
					} catch (SQLException e1) {
						System.out.println(e1.getMessage());
					}
						
					break;
				case 2:
					System.out.println("");
					try {
						List<Account> list = bankService.fetchAllAccount();
						System.out.println("**************************List of all accounts********************************");
						System.out.println();
						System.out.println(" Account_id "+" Customer_id "+" Account_type "+"\tBalance ");
						for(Account a:list)
						{
							System.out.println("    "+a.getId()+"\t\t"+a.getCustomerId()+"\t   "+a.getAccountType()+"\t"+a.getBalance());
						}
						System.out.println("******************************************************************************");
						System.out.println();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					try {
						List<AccountInterest> list = bankService.fetchAccountInterest();
						System.out.println("Account_id "+" Interest ");
						for(AccountInterest ai:list)
						{
							System.out.println("     "+ai.getId()+"      "+ai.getInterest());
						}
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					System.out.println("Invalid Input");
					break;	
			}
		}
		s.close();
	}

}
