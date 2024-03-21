package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dto.AccountInterest;
import com.model.Account;
import com.util.DBUtil;

public class BankDaoImpl implements BankDao {

	@Override
	public List<Account> fetchAllAccount() throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="select * from account";
		
		List<Account> list=new ArrayList<>();
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		ResultSet rst=pstmt.executeQuery();
		
		while(rst.next())
		{
			int id=rst.getInt("id");
			String accType=rst.getString("account_type");
			Double balance=rst.getDouble("balance");
			int customerId=rst.getInt("customer_id");
			Account account=new Account(id,accType,balance,customerId);
			list.add(account);
		}
		DBUtil.dbClose();
		return list;
	}

	@Override
	public List<AccountInterest> fetchAccountInterest() throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="select * from account";
		
		List<AccountInterest> list=new ArrayList<>();
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		ResultSet rst=pstmt.executeQuery();
		
		while(rst.next())
		{
			int id=rst.getInt("id");
			Double balance=rst.getDouble("balance");
			AccountInterest accountInterest=new AccountInterest(id,balance*0.045);
			list.add(accountInterest);
			
		}
		DBUtil.dbClose();
		return list;
	}

	@Override
	public void addCustomer(String fname, String lname, LocalDate dob) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="insert into customer(first_name,last_name,dob) values(?,?,?)";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1, fname);
		pstmt.setString(2, lname);
		pstmt.setObject(3, dob);
		
		pstmt.executeUpdate();
		DBUtil.dbClose();
	}

	@Override
	public int getCustomerId(String fname) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="select id from customer where first_name=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, fname);
		
		ResultSet rst=pstmt.executeQuery();
		int id =0;
		if(rst.next())
		{
			id=rst.getInt("id");
		}
		DBUtil.dbClose();
		return id;
	}

	@Override
	public void updateAccounts(String accountType, Double balance, int cid) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="insert into account(account_type,balance,customer_id) values(?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, accountType);
		pstmt.setDouble(2, balance);
		pstmt.setInt(3, cid);
		pstmt.executeUpdate();
		DBUtil.dbClose();
	}

}
