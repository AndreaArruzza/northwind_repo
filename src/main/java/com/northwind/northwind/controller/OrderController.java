package com.northwind.northwind.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.northwind.northwind.model.OrderDTO;
import com.northwind.northwind.service.OrderService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path="/order", produces = { MediaType.APPLICATION_JSON_VALUE, "application/hal+json" })
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	OrderService service;
	
	@GetMapping( path = "/getOrderByCustomerID")
	@ApiOperation(value = "getOrderByCustomerID")
	public List<OrderDTO> getOrders(@RequestParam("customerID") String customerID) {
		logger.info("chiamata endpoint getOrderByCustomerID...");
		List<OrderDTO> dto = service.getOrderByCustomerID(customerID);
		logger.info("fine chiamata endpoint getOrderByCustomerID: OK");
		return dto;
	}
}
