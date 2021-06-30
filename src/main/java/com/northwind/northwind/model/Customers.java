package com.northwind.northwind.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = "Customers")
public class Customers {
	 @Field(name = "CustomerID")
	 private String customerID;
	 
	 @Field(name = "CompanyName")
	 private String companyName;
	 
	 @Field(name = "ContactName")
	 private String contactName;
	 
	 @Field(name = "ContactTitle")
	 private String contactTitle;
	 
	 @Field(name = "Address")
	 private String address;
	 
	 @Field(name = "City")
	 private String city;
	 
	 @Field(name = "Region")
	 private String region;
	 
	 @Field(name = "PostalCode")
	 private String  postalCode;
	 
	 @Field(name = "Country")
	 private String country;
	 
	 @Field(name = "Phone")
	 private String phone;
	 
	 @Field(name = "Fax")
	 private String fax;
	 
	 
	 private String password;
	 
	 
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactTitle() {
		return contactTitle;
	}
	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	@Override
	public String toString() {
		return "Customers [customerID=" + customerID + ", companyName=" + companyName + ", contactName=" + contactName
				+ ", contactTitle=" + contactTitle + ", address=" + address + ", city=" + city + ", region=" + region
				+ ", postalCode=" + postalCode + ", country=" + country + ", phone=" + phone + ", fax=" + fax + "]";
	}
}
