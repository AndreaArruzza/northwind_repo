package com.northwind.northwind.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.northwind.northwind.model.Users;

public class UsersRowMapper implements RowMapper<Users>{
	
	
	private static final String USER_ID	 = "UserID";
	private static final String EMAIL  	 = "Email";
	private static final String PASSWORD = "Password";
	private static final String ROLE 	 = "Role";
	
	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users user = new Users();
		user.setUserID(rs.getString(USER_ID));
		user.setEmail(rs.getString(EMAIL));
		user.setPassword(rs.getString(PASSWORD));
		user.setRole(rs.getString(ROLE));
		return user;
	} 

}
