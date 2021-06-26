package com.northwind.northwind.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northwind.northwind.model.OrderDTO;
import com.northwind.northwind.repository.OrderRepository;

@Service
public class OrderService  {
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	OrderRepository repo;

	public List<OrderDTO> getOrderByCustomerID(String customerID) {
		logger.info("chiamata findByCustomerID con customerID ={}" + customerID);
		List<OrderDTO> listOrder = repo.findByCustomerID(customerID);
		logger.info("chiamata findByCustomerID con customerID = OK");
		return listOrder;
	}
	
	
	
}
