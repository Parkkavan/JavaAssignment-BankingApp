package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.exception.InvalidCredentialsException;
import com.service.BankingAppService;

public class BankingApp {

	public static void main(String[] args) {
		
		System.out.println("**************************************** BANKING-APP ****************************************");
		System.out.println();
		System.out.println("Press 1. Admin Login");
		System.out.println("Press 2. Customer Login");
		
		Scanner s=new Scanner(System.in);
		BankingAppService bankingAppService=new BankingAppService();
		
		int input=s.nextInt();
		switch(input)
		{
			case 1:
				System.out.println("Enter the user name");
				try {
					String userName=s.next();
					bankingAppService.verifyUsername(userName);
					System.out.println("Enter Password");
					String password=s.next();
					bankingAppService.verifyPassword(userName,password);
					System.out.println("Welcome "+userName);
					BankController.main(args);
				} catch (InvalidCredentialsException e) {
					System.out.println(e.getMessage());
				}			
				break;
			case 2:
				
				try {
					System.out.println("Enter the user name");
					String userName=s.next();
					System.out.println("Enter Password");
					String date=s.next();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate password=LocalDate.parse(date, formatter);
					bankingAppService.verifyCustomer(userName, password);
					System.out.println("Welcome,"+userName);
					CustomerController.main(args);
				} catch (InvalidCredentialsException | SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Invalid Input");
				break;
		}
		s.close();
	}
}
