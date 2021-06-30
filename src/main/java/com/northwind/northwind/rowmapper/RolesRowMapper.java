package com.northwind.northwind.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.northwind.northwind.model.Roles;

public class RolesRowMapper implements RowMapper<Roles>{

	
	
	private static final String ROLE_ID  	= "RoleID";
	private static final String NAME  	 	= "Name";
	private static final String DESCRIPTION = "Description";
	
	@Override
	public Roles mapRow(ResultSet rs, int rowNum) throws SQLException {
		Roles role = new Roles();
		role.setRoleID(rs.getString(ROLE_ID));
		role.setName(rs.getString(NAME));
		role.setDescription(rs.getString(DESCRIPTION));
		return role;
	} 

}
