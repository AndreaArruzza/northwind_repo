package com.northwind.northwind.resource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class OrdersResource {
	 private Integer orderID;
	 private LocalDateTime orderDate;
	 private String CustomerID;
	 private LocalDateTime requiredDate;
	 private Double freight;
	 List<ShipInformationOrders> shipInformationOrders;
	 
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
	public List<ShipInformationOrders> getShipInformationOrders() {
		return shipInformationOrders;
	}
	public void setShipInformationOrders(List<ShipInformationOrders> shipInformationOrders) {
		this.shipInformationOrders = shipInformationOrders;
	}
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	
	
	
}