package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.CustomerCred;

public interface BankingAppDao {


	List<CustomerCred> fetchCustomerDetails() throws SQLException;
	
}
