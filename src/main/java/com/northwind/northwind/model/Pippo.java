package com.northwind.northwind.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pippo {
	@Id
	private String name;
	private String lastname;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public Pippo(String name, String lastname) {
		super();
		this.name = name;
		this.lastname = lastname;
	}
	
	
}
