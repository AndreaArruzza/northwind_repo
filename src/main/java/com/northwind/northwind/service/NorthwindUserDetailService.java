package com.northwind.northwind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.northwind.northwind.model.NorthwindUsersDetails;
import com.northwind.northwind.model.User;
import com.northwind.northwind.repository.UserRepository;

@Component
public class NorthwindUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository usersRepository;
	@Override
	public UserDetails loadUserByUsername(String email) {
		User user = usersRepository.getUserByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException(" nessun user trovato con la seguente email ");
		}
		return new NorthwindUsersDetails(user);
	}

}
