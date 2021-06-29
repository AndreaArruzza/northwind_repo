package com.northwind.northwind.model;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="Orders")
public class Orders {
	 private ObjectId _id;
	 private Integer OrderID;
	 private String CustomerID;
	 private String EmployeeID;
	 private LocalDateTime  OrderDate;
	 private LocalDateTime RequiredDate;
	 private LocalDateTime ShippedDate;
	 private Double Freight;
	 private String ShipVia;
	 private String ShipName;
	 private String ShipAddress;
	 private String ShipCity;
	 private String ShipRegion;
	 private String ShipPostalCode;
	 private String ShipCountry;
	 
	 
	 
	public Integer getOrderID() {
		return OrderID;
	}
	public void setOrderID(Integer orderID) {
		OrderID = orderID;
	}
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String CustomerID) {
		this.CustomerID = CustomerID;
	}
	public String getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}
	public LocalDateTime getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		OrderDate = orderDate;
	}
	public LocalDateTime getRequiredDate() {
		return RequiredDate;
	}
	public void setRequiredDate(LocalDateTime requiredDate) {
		RequiredDate = requiredDate;
	}
	public LocalDateTime getShippedDate() {
		return ShippedDate;
	}
	public void setShippedDate(LocalDateTime shippedDate) {
		ShippedDate = shippedDate;
	}
	public String getShipVia() {
		return ShipVia;
	}
	public void setShipVia(String shipVia) {
		ShipVia = shipVia;
	}
	public Double getFreight() {
		return Freight;
	}
	public void setFreight(Double freight) {
		Freight = freight;
	}
	public String getShipName() {
		return ShipName;
	}
	public void setShipName(String shipName) {
		ShipName = shipName;
	}
	public String getShipAddress() {
		return ShipAddress;
	}
	public void setShipAddress(String shipAddress) {
		ShipAddress = shipAddress;
	}
	public String getShipCity() {
		return ShipCity;
	}
	public void setShipCity(String shipCity) {
		ShipCity = shipCity;
	}
	public String getShipRegion() {
		return ShipRegion;
	}
	public void setShipRegion(String shipRegion) {
		ShipRegion = shipRegion;
	}
	public String getShipPostalCode() {
		return ShipPostalCode;
	}
	public void setShipPostalCode(String shipPostalCode) {
		ShipPostalCode = shipPostalCode;
	}
	public String getShipCountry() {
		return ShipCountry;
	}
	public void setShipCountry(String shipCountry) {
		ShipCountry = shipCountry;
	}
	 
	 
	 
	 
	 
	 
}
