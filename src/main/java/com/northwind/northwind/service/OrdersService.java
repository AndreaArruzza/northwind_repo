package com.northwind.northwind.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northwind.northwind.model.Orders;
import com.northwind.northwind.repository.OrdersRepository;

@Service
public class OrdersService  {
	private static final Logger logger = LoggerFactory.getLogger(OrdersService.class);

	@Autowired
	OrdersRepository repo;
	
	public List<Orders> getOrderByCustomerID(String customerID) {
		logger.info("chiamata findByCustomerID con customerID ={}" + customerID);
		Orders order = new Orders();
		order.setCustomerID(customerID);
		List<Orders> listOrder = repo.findByCustomerID(order.getCustomerID());
		logger.info("chiamata findByCustomerID con customerID = OK");
		return listOrder;
	}
	
	
	
}
