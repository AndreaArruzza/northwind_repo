package com.northwind.northwind.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.northwind.northwind.Constants;
import com.northwind.northwind.model.UserIn;
import com.northwind.northwind.model.User;
import com.northwind.northwind.rowmapper.UserRowMapper;
import com.northwind.northwind.utils.Util;


@Repository
public class UserRepository {
	private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
   
	@Autowired
	private PasswordEncoder encoder;
	
	public User getUserByEmail(String email) {
		List<User> list;
		logger.info("[getUserByEmail] ----	[START] ---- email {} ...", email);
		Map<String,Object> params =  new HashMap<>();
		params.put("Email" , email);
		list = jdbcTemplate.query(Util.readQuery(Constants.GET_USER_BY_EMAIL),new Object[] { email },new UserRowMapper());
		User user = new User();
		if(!list.isEmpty()) {
			user = list.get(0);
		}
		logger.info("[getUserByEmail] ----	[END] ----  user {} ...", user);
		return user;
	}

	public UserIn insert(UserIn newUser) {
		logger.info("[Inizio inserimento]  di newUser {} ...", newUser);
		try {
			jdbcTemplate.update(Util.readQuery(Constants.INSERT_NEW_USER),newUser.getEmail(),encoder.encode(newUser.getPassword()), newUser.getRoleID(), newUser.getCustomerID());
			logger.info("Fine inserimento newUser.");
		}
		catch(Exception e ) {
			logger.error("[INSERT] Errore in UsersRepository.insert".concat(e.getMessage()));
			throw new RuntimeException(e);
		}
		return newUser;
	}
	
	public String getLastUserID() {
		String userID = "";
		try {
			logger.info("[getLastUserID] ----- [START]");
			userID = jdbcTemplate.queryForObject(Util.readQuery(Constants.GET_LAST_USER_ID),  String.class);
			logger.info("[getLastUserID] ----- [END]---- lastUserID: {}", userID);
		}
		catch(Exception e ) {
			logger.error("[INSERT] Errore in getLastUserID".concat(e.getMessage()));
			throw new RuntimeException(e);
		}
		return userID;
	}
}
