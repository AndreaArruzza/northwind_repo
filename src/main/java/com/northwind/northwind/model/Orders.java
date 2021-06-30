package com.northwind.northwind.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value="Orders")
public class Orders {
	 @Field(name = "OrderID")
	 private Integer orderID;
	 @Field(name = "CustomerID")
	 private String customerID;
	 @Field(name = "EmployeeID")
	 private String employeeID;
	 @Field(name = "OrderDate")
	 private LocalDateTime  orderDate;
	 @Field(name = "RequiredDate")
	 private LocalDateTime requiredDate;
	 @Field(name = "ShippedDate")
	 private LocalDateTime shippedDate;
	 @Field(name = "Freight")
	 private Double freight;
	 @Field(name = "ShipVia")
	 private String shipVia;
	 @Field(name = "ShipName")
	 private String shipName;
	 @Field(name = "ShipAddress")
	 private String shipAddress;
	 @Field(name = "ShipCity")
	 private String shipCity;
	 @Field(name = "ShipRegion")
	 private String shipRegion;
	 @Field(name = "ShipPostalCode")
	 private String shipPostalCode;
	 @Field(name = "ShipCountry")
	 private String shipCountry;
	 
	 private Boolean newOrder;
	 

	public Boolean getNewOrder() {
		return newOrder;
	}
	public void setNewOrder(Boolean newOrder) {
		this.newOrder = newOrder;
	}
	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public LocalDateTime getRequiredDate() {
		return requiredDate;
	}
	public void setRequiredDate(LocalDateTime requiredDate) {
		this.requiredDate = requiredDate;
	}
	public LocalDateTime getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(LocalDateTime shippedDate) {
		this.shippedDate = shippedDate;
	}
	public Double getFreight() {
		return freight;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}
	public String getShipVia() {
		return shipVia;
	}
	public void setShipVia(String shipVia) {
		this.shipVia = shipVia;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public String getShipAddress() {
		return shipAddress;
	}
	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}
	public String getShipCity() {
		return shipCity;
	}
	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}
	public String getShipRegion() {
		return shipRegion;
	}
	public void setShipRegion(String shipRegion) {
		this.shipRegion = shipRegion;
	}
	public String getShipPostalCode() {
		return shipPostalCode;
	}
	public void setShipPostalCode(String shipPostalCode) {
		this.shipPostalCode = shipPostalCode;
	}
	public String getShipCountry() {
		return shipCountry;
	}
	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}
	
	@Override
	public String toString() {
		return "Orders [orderID=" + orderID + ", customerID=" + customerID + ", employeeID=" + employeeID
				+ ", orderDate=" + orderDate + ", requiredDate=" + requiredDate + ", shippedDate=" + shippedDate
				+ ", freight=" + freight + ", shipVia=" + shipVia + ", shipName=" + shipName + ", shipAddress="
				+ shipAddress + ", shipCity=" + shipCity + ", shipRegion=" + shipRegion + ", shipPostalCode="
				+ shipPostalCode + ", shipCountry=" + shipCountry + "]";
	}
	 
}
