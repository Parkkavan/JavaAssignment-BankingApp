package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dto.CustomerCred;
import com.util.DBUtil;

public class BankingAppDaoImpl implements BankingAppDao{

	@Override
	public List<CustomerCred> fetchCustomerDetails() throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="select first_name,dob from customer";
		
		List<CustomerCred> list=new ArrayList<>();
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		ResultSet rst=pstmt.executeQuery();
		
		while(rst.next())
		{
			String fname=rst.getString("first_name");
			LocalDate dob=rst.getDate("dob").toLocalDate();
			CustomerCred cd=new CustomerCred(fname,dob);
			list.add(cd);
		}
		DBUtil.dbClose();
		return list;
	}

	

}
