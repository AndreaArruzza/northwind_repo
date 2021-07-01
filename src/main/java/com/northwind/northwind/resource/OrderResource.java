package com.northwind.northwind.resource;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResource {
	 private Integer orderID;
	 private LocalDateTime orderDate;
	 private String CustomerID;
	 private LocalDateTime requiredDate;
	 private Double freight;
	 List<ShipInformationOrder> shipInformationOrders;
	 private String message;
	 
	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
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
	public Double getFreight() {
		return freight;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}
	public List<ShipInformationOrder> getShipInformationOrders() {
		return shipInformationOrders;
	}
	public void setShipInformationOrders(List<ShipInformationOrder> shipInformationOrders) {
		this.shipInformationOrders = shipInformationOrders;
	}
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String Message) {
		this.message = message;
	}
	
	
	
}