package com.northwind.northwind.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.northwind.northwind.assembler.OrdersAssembler;
import com.northwind.northwind.model.Orders;
import com.northwind.northwind.resource.OrdersResource;
import com.northwind.northwind.service.OrdersService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path="/order", produces = { MediaType.APPLICATION_JSON_VALUE, "application/hal+json" })
public class OrdersController {
	private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);
	
	@Autowired
	OrdersService service;
	
	@Autowired
	OrdersAssembler assembler;
	
	@GetMapping( path = "/getOrderByCustomerID")
	@ApiOperation(value = "getOrderByCustomerID")
	public List<OrdersResource> getOrders(@RequestParam("customerID") String customerID) {
		logger.info("chiamata endpoint getOrderByCustomerID...");
		List<Orders> listOrders = service.getOrderByCustomerID(customerID);
		logger.info("fine chiamata endpoint getOrderByCustomerID: OK");
		
		List<OrdersResource> resource = new ArrayList<>();
		listOrders.stream().forEach(p -> resource.add(assembler.instantiateResource(p)));
		return resource;
	}
}
