package com.northwind.northwind.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class UserIn {
	@Email(message = "Email should be valid")
	private String email;
	
	@NotNull(message = "password cannot be null")
	private String password;
	
    @NotNull(message = "CustomerID cannot be null")
	private String customerID;
	
	@Min(value = 1, message = "RoleID should not be less than 1")
	@Max(value = 5, message = "RoleID should not be greater than 5")
	private Integer roleID;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	

}