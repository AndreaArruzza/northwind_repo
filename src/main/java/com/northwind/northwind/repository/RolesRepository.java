package com.northwind.northwind.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.northwind.northwind.Constants;
import com.northwind.northwind.model.Roles;
import com.northwind.northwind.rowmapper.RolesRowMapper;
import com.northwind.northwind.utils.Utils;

@Repository
public class RolesRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Roles getRoleByID(String roleID) {
		Map<String,Object> params =  new HashMap<>();
		params.put("RoleID" , roleID);
		List<Roles> query = jdbcTemplate.query(Utils.readQuery(Constants.GET_ROLE_BY_ID),new RolesRowMapper(),  params);
		return query.get(0);
	}


}
