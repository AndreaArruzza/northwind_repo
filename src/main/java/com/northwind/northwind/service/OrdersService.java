package com.northwind.northwind.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northwind.northwind.assembler.OrdersAssembler;
import com.northwind.northwind.exception.OrdersException;
import com.northwind.northwind.model.Orders;
import com.northwind.northwind.repository.OrdersRepository;
import com.northwind.northwind.resource.OrdersResource;

@Service
public class OrdersService  {
	private static final Logger logger = LoggerFactory.getLogger(OrdersService.class);

	@Autowired
	OrdersRepository repo;
	
	@Autowired
	OrdersAssembler assembler;
	
	public List<OrdersResource> getOrdersByCustomerID(String customerID) throws OrdersException {
		logger.info("[getOrderByCustomerID] - [START] ---- customerID:  {}",customerID);
		
		logger.info("[findByCustomerID --- Mongodb] - [START] ---- customerID:  {}", customerID);
		List<Orders> listOrders =  repo.findByCustomerID(customerID);
		logger.info("[findByCustomerID --- Mongodb] - [END] ---- listOrders:  {}", listOrders);
		List<OrdersResource> resource = new ArrayList<>();
		
		if(!listOrders.isEmpty()) {
			listOrders.stream().forEach(p -> 
			{	
				OrdersResource orderResource = assembler.toResource(p);
				resource.add(orderResource);
				logger.info(" orderResource:{}", orderResource);
			});
		}
		else {
			logger.error("  non vi sono ordini associati al customer ID indicato :  {}", customerID);
			throw new OrdersException(" non vi sono ordini associati al customer ID indicato : ".concat(customerID));
		}
		
		logger.info("[getOrderByCustomerID] - [END]");
		return resource;
	}
	
}