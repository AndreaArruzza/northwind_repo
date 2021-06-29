package com.northwind.northwind.model;

import java.time.LocalDateTime;

public class OrdersDTO {

	private Integer orderID;
	private boolean newOrder;
	private String customerID;
	private String employeeID;
	private LocalDateTime  orderDate;
	private LocalDateTime requiredDate;
	private LocalDateTime shippedDate;
	private Double freight;
	private String shipVia;
	private String shipName;
	private String shipAddress;
	private String shipCity;
	private String shipRegion;
	private String shipPostalCode;
    private String shipCountry;
	
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
	public boolean getNewOrder() {
		return newOrder;
	}
	public void setNewOrder(boolean newOrder) {
		this.newOrder = newOrder;
	}
	
	
	@Override
	public String toString() {
		return "OrderDTO [orderID=" + orderID + ", customerID=" + customerID + ", employeeID=" + employeeID
				+ ", orderDate=" + orderDate + ", requiredDate=" + requiredDate + ", shippedDate=" + shippedDate
				+ ", freight=" + freight + ", shipVia=" + shipVia + ", shipName=" + shipName + ", shipAddress="
				+ shipAddress + ", shipCity=" + shipCity + ", shipRegion=" + shipRegion + ", shipPostalCode="
				+ shipPostalCode + ", shipCountry=" + shipCountry + ", newOrder=" + newOrder + "]";
	}
}
