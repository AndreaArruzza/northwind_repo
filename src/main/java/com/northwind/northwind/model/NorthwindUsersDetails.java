package com.northwind.northwind.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.northwind.northwind.repository.RolesRepository;

public class NorthwindUsersDetails implements UserDetails {
	

	private static final long serialVersionUID = -2419178299606274127L;

	private Users user;
	
	@Autowired
	RolesRepository roleRepo;
	
	public NorthwindUsersDetails(Users user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	     return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
	}

	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}