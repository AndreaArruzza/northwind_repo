package com.northwind.northwind.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.northwind.northwind.MongoCopy;
import com.northwind.northwind.exception.UserAlreadyExistException;
import com.northwind.northwind.model.UserIn;
import com.northwind.northwind.model.User;
import com.northwind.northwind.mongo.repository.UserMongoRepository;
import com.northwind.northwind.repository.UserRepository;
import com.northwind.northwind.resource.RegisterResource;

@Service
@Transactional
public class UserService implements MongoCopy<UserIn>{
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
    @Autowired
    private UserRepository repository;
	
	@Autowired
	private UserMongoRepository repoMongo;
    
    
    public RegisterResource insertNewUser(UserIn newUser) throws UserAlreadyExistException {
    	RegisterResource registerResource = new RegisterResource();
    	try {
    		logger.info("[insertNewUser] - [START] ---- newUser:  {}", newUser);
    		if (emailExists(newUser.getEmail()) == true) {
    			throw new UserAlreadyExistException("There is an account with that email address : ".concat(newUser.getEmail()));
    		}
    		repository.insert(newUser);
    		logger.info("[insertNewUser] - [END]");
    		copyMongo(newUser);
    	}
    	catch(Exception e) {
    		throw new RuntimeException(e);
    	}
		return registerResource;
    }

    private boolean emailExists(String email) {
        return repository.getUserByEmail(email).getUserID() != null;
    }

    @Override
	public void copyMongo(UserIn dto) {
		logger.info("[copyMongo] - [START] ---- dto:  {}" , dto);
		User user = new User();
		user.setCustomerID(dto.getCustomerID());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setRoleID(dto.getRoleID());
		try {
			user.setUserID(repository.getLastUserID());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
		repoMongo.save(user);
		logger.info("[copyMongo] - [END] ---- dto:  {}" , dto);
	}
}