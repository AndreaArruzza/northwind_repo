package com.northwind.northwind.model;

import javax.validation.constraints.NotNull;

public class FavoriteLocationIn {
	@NotNull(message = "customerID cannot be null")
	private String customerID;
	
	@NotNull(message = "cityID cannot be null")
	private Integer cityID;
	
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public Integer getCityID() {
		return cityID;
	}
	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}
	
}
