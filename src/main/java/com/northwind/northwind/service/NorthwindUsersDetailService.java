package com.northwind.northwind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.northwind.northwind.model.NorthwindUsersDetails;
import com.northwind.northwind.model.Users;
import com.northwind.northwind.repository.UsersRepository;

@Component
public class NorthwindUsersDetailService implements UserDetailsService {

	@Autowired
	UsersRepository usersRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users user = usersRepository.getUserByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException(" nessun user trovato con la seguente email ");
		}
		return new NorthwindUsersDetails(user);
	}

}
