package com.northwind.northwind.resource;

import java.time.LocalDate;
import java.util.List;

public class OrdersResource {
	 private String orderID;
	 private LocalDate  orderDate;
	 private LocalDate requiredDate;
	 private Double freight;
	 List<ShipInformationOrders> shipInformationOrders;
	 
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public LocalDate getRequiredDate() {
		return requiredDate;
	}
	public void setRequiredDate(LocalDate requiredDate) {
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
	
}