package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
import com.dto.AccountBalance;
import com.dto.AccountDetails;
import com.exception.InsufficientFundException;
import com.exception.InvalidAccountException;
import com.exception.OverDraftLimitExcededException;
import com.service.CustomerService;

public class CustomerController {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		CustomerService customerService=new CustomerService();
		while(true)
		{
			System.out.println("Press 1. Get Account Balance");
			System.out.println("Press 2. Deposit");
			System.out.println("Press 3. Withdraw");
			System.out.println("Press 4. Transfer");
			System.out.println("Press 5. Get Account Details");
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
					try {
						System.out.println("Enter your account Id");
						int id = s.nextInt();
						AccountBalance balance = customerService.getAccBalance(id);
						System.out.println("************************ Account Balance **************************");
						System.out.println();
						System.out.println(" Account_id"+"\t"+"balance");
						System.out.println("     "+balance.getId()+"\t\t"+balance.getBalance());
						System.out.println();
						System.out.println("********************************************************************");
					} catch (SQLException | InvalidAccountException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					System.out.println("Enter account Id");
					int accId = s.nextInt();
					try {
						customerService.isValidAccount(accId);
						System.out.println("Enter the amount to deposit");
						double amount=s.nextDouble();
						String mess=customerService.depositAmount(accId,amount);
						System.out.println(mess);
						double balance=customerService.getAccBalance(accId).getBalance();
						System.out.println("The current balance is "+balance);
						customerService.updateTransaction("deposit",amount,LocalDate.now(),accId);
						System.out.println("Transaction Updated");
					} catch (InvalidAccountException | SQLException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					System.out.println("Enter account Id");
					accId = s.nextInt();
					try {
						customerService.isValidAccount(accId);
						System.out.println("Enter the amount to withdraw");
						double amount=s.nextDouble();
						String response=customerService.withdrawAmount(accId,amount);
						System.out.println(response);
						double balance=customerService.getAccBalance(accId).getBalance();
						System.out.println("The current balance is "+balance);
						customerService.updateTransaction("withdrawal",amount,LocalDate.now(),accId);
						System.out.println("Transaction Updated");
					} catch (InvalidAccountException | SQLException | InsufficientFundException | OverDraftLimitExcededException e1) {
						System.out.println(e1.getMessage());
					}
					System.out.println();
					break;
				case 4:
					System.out.println("Enter the account number");
					accId = s.nextInt();
					try {
						customerService.isValidAccount(accId);
						System.out.println("Enter the account number of the receiver");
						int recAccId = s.nextInt();
						customerService.isValidAccount(recAccId);
						System.out.println("Enter the amount to Transfer");
						double amount=s.nextDouble();
						String response=customerService.withdrawAmount(accId,amount);
						System.out.println(response);
						String mess=customerService.depositAmount(recAccId,amount);
						System.out.println(mess);
						customerService.updateTransaction("transfer",amount,LocalDate.now(),accId);
						System.out.println("Transaction completed successfully");
					} catch (InvalidAccountException | SQLException | InsufficientFundException | OverDraftLimitExcededException e1) {
						System.out.println(e1.getMessage());
					}
					System.out.println();
					break;
				case 5:
					try {
						System.out.println("Enter the account ID");
						int aid = s.nextInt();
						AccountDetails result = customerService.getAccountDetails(aid);
						System.out.println("********************* Account Details *************************");
						System.out.println();
						System.out.println("first_name "+" last_name "+"     dob    "+"  account_id "+" account_type "+" balance "+" customer_id ");
						System.out.println(" "+result.getFirstName()+"        "+result.getLastName()+"    "+result.getDob()+"\t"+result.getAid()+" \t  "+result.getAccountType()+"     "+result.getBalance()+" \t   "+result.getCustomerId());
						System.out.println();
						System.out.println("****************************************************************");
						
					
					} catch (SQLException | InvalidAccountException e) {
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
