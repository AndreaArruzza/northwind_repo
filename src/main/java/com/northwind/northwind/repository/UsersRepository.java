package com.northwind.northwind.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.northwind.northwind.Constants;
import com.northwind.northwind.model.Users;
import com.northwind.northwind.rowmapper.UsersRowMapper;
import com.northwind.northwind.utils.Utils;

@Repository
public class UsersRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
   
	@Autowired
    PasswordEncoder encoder;
    
	public Users getUserByEmail(String email) {
		List<Users> list = new ArrayList<>();
		Map<String,Object> params =  new HashMap<>();
		params.put("Email" , email);
		list = jdbcTemplate.query(Utils.readQuery(Constants.GET_USER_BY_EMAIL),new Object[] { email },new UsersRowMapper());
		Users user = new Users();
		if(list.size() > 0) {
			user = list.get(0);
		}
		return user;
	}

	public Users insert(Users user) {
		jdbcTemplate.update(Utils.readQuery(Constants.INSERT_NEW_USER),user.getEmail(),encoder.encode(user.getPassword()), user.getRole(), user.getCustomerID());
		return user;
	}
}
