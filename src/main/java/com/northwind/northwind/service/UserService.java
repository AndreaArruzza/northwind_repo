package com.northwind.northwind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.northwind.northwind.exception.UserAlreadyExistException;
import com.northwind.northwind.model.Users;
import com.northwind.northwind.repository.UsersRepository;

@Service
@Transactional
public class UserService {
    @Autowired
    private UsersRepository repository;
    
    
    public Users insertNewUser(Users user) throws UserAlreadyExistException {
        if (emailExists(user.getEmail()) == true) {
            throw new UserAlreadyExistException("There is an account with that email address : ".concat(user.getEmail()));
        }
        return repository.insert(user);
    }

    private boolean emailExists(String email) {
        return repository.getUserByEmail(email).getUserID() != null;
    }
}