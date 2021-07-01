package com.northwind.northwind.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.northwind.northwind.model.User;

public class UserRowMapper implements RowMapper<User>{
	
	
	private static final String USER_ID	 = "UserID";
	private static final String EMAIL  	 = "Email";
	private static final String PASSWORD = "Password";
	private static final String CUSTOMER_ID = "CustomerID";
	private static final String ROLE_ID  = "RoleID";
	private static final String ROLE_NAME = "RoleName";
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserID(rs.getString(USER_ID));
		user.setEmail(rs.getString(EMAIL));
		user.setPassword(rs.getString(PASSWORD));
		user.setCustomerID(rs.getString(CUSTOMER_ID));
		user.setRoleID(rs.getInt(ROLE_ID));
		user.setRoleName(rs.getString(ROLE_NAME));
		return user;
	} 

}
