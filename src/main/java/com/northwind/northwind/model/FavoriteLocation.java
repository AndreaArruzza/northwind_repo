package com.northwind.northwind.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = "Favorite Location")
public class FavoriteLocation {
	
	@Field(name = "CustomerID")
	private String customerID;
	
	@Field(name = "CityID")
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