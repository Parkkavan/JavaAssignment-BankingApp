package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dto.AccountBalance;
import com.dto.AccountDetails;
import com.dto.AccountTypeBalance;
import com.exception.InvalidAccountException;
import com.util.DBUtil;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public AccountBalance getAccBalance(int id) throws SQLException, InvalidAccountException {
		Connection conn=DBUtil.getDBConn();
		
		String sql="select id,balance from account where id=?";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setInt(1, id);
		
		ResultSet rst=pstmt.executeQuery();
		
		if(rst.next())
		{
			int aid=rst.getInt("id");
			double balance=rst.getDouble("balance");
			AccountBalance result=new AccountBalance(aid,balance);
			return result;
		}
		DBUtil.dbClose();
		throw new InvalidAccountException("Invalid Account ID");
	}

	
	@Override
	public String depositamount(int accId, double amount, double currBalance) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		
		String sql="update account set balance = ? where id=?";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setDouble(1,amount+currBalance);
		pstmt.setInt(2,accId);
		
		int result=pstmt.executeUpdate();
		
		DBUtil.dbClose();
		if(result==1)
		{
			return "Deposit successfull";
		}
		return "Deposit Failed";
	}
	
	@Override
	public AccountDetails getAccountDetails(int aid) throws SQLException, InvalidAccountException {
		Connection conn=DBUtil.getDBConn();
		
		String sql="select c.first_name,c.last_name,c.dob,a.* from customer c,account a where c.id=a.customer_id and a.id=?";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setInt(1, aid);
		
		ResultSet rst=pstmt.executeQuery();
		
		if(rst.next())
		{
			String firstName=rst.getString("first_name");
			String lastName=rst.getString("last_name");
			LocalDate dob=rst.getDate("dob").toLocalDate();
			int aId=rst.getInt("id");
			String accountType=rst.getString("account_type");
			double balance=rst.getDouble("balance");
			int cId=rst.getInt("customer_id");
			AccountDetails result=new AccountDetails(firstName,lastName,dob,aId,accountType,balance,cId);
			return result;
		}
		DBUtil.dbClose();
		throw new InvalidAccountException("Invalid Account ID");
	}

	@Override
	public boolean isValidAccount(int accId) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="select id from account";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		List<Integer> aid=new ArrayList<>();
		while(rst.next())
		{
			int id=rst.getInt("id");
			aid.add(id);
		}
		for(Integer id:aid)
		{
			if(id==accId)
			{
				return true;
			}
		}
		DBUtil.dbClose();
		return false;
	}


	@Override
	public void updateTransaction(String accType, double amount, LocalDate date, int accId) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		
		String sql="insert into transaction(transaction_type,amount,transaction_date,account_id) values (?,?,?,?)";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1, accType);
		pstmt.setDouble(2,amount);
		pstmt.setObject(3, date);
		pstmt.setInt(4, accId);
		
		pstmt.executeUpdate();
		DBUtil.dbClose();
	}


	@Override
	public AccountTypeBalance fetchDetails(int accId) throws SQLException, InvalidAccountException {
		Connection conn=DBUtil.getDBConn();
		String sql="select account_type,balance from account where id=?";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, accId);
		ResultSet rst=pstmt.executeQuery();
		
		if(rst.next())
		{
			String accType=rst.getString("account_type");
			double bal=rst.getDouble("balance");
			
			AccountTypeBalance accountTypeBalance=new AccountTypeBalance(accType,bal);
			return accountTypeBalance;
		}
		DBUtil.dbClose();
		throw new InvalidAccountException("Invalid Account ID");
	}


	@Override
	public void withdrawAmount(int accId, double amount, Double balance) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		
		String sql="update account set balance = ? where id=?";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setDouble(1,balance-amount);
		pstmt.setInt(2,accId);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
	}


	


	

	

}
