package com.northwind.northwind.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;

@Document(value = "Roles")
public class Roles implements GrantedAuthority {
	
	@Field(name = "RoleID")
	private String roleID;
	
	@Field(name = "Name")
	private String name;
	
	@Field(name = "Description")
	private String description;

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Roles [roleID=" + roleID + ", name=" + name + ", description=" + description + "]";
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
