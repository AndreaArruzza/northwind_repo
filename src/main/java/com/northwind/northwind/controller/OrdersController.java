package com.northwind.northwind.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.northwind.northwind.assembler.OrdersAssembler;
import com.northwind.northwind.exception.OrdersException;
import com.northwind.northwind.model.Orders;
import com.northwind.northwind.resource.OrdersResource;
import com.northwind.northwind.service.OrdersService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path="/order", produces = { MediaType.APPLICATION_JSON_VALUE, "application/hal+json" })
public class OrdersController {
	private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);
	
	@Autowired
	OrdersService service;
	
	@Autowired
	OrdersAssembler assembler;
	
	@ApiOperation(value = "return orders by authentication")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping
	public List<OrdersResource> getOrders() throws OrdersException {
		logger.info("[getOrders] - [START]");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		List<OrdersResource> resource = service.getOrdersByCustomerID(authentication.getName());
		logger.info("[getOrders] - [END]");
		return resource;
	}
	

	@ApiOperation(value = "return orders by customer id ")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/{customerID}")
	public ResponseEntity<List<OrdersResource>>  getOrdersByCustomerID(@RequestParam("customerID") String customerID) throws OrdersException {
		logger.info("[getOrdersByCustomerID] - [START]");

		List<OrdersResource> resource = (service.getOrdersByCustomerID(customerID));
		logger.info("[getOrdersByCustomerID] - [END]");
		return ok(resource);
	}
	
	
	
	@ApiOperation(value = "return orders by order id ")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/{orderID}")
	public ResponseEntity<List<OrdersResource>>  getOrdersByOrderID(@RequestParam("orderID") Integer orderID) throws OrdersException {
		logger.info("[getOrdersByOrderID] - [START]");

		List<OrdersResource> resource = (service.getOrdersByOrderID(orderID));
		logger.info("[getOrdersByOrderID] - [END]");
		return ok(resource);
	}
	
	
	@ApiOperation(value = "return orders by ship country and ship name")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/{shipCountry}/{shipName}")
	public ResponseEntity<List<OrdersResource>>  getOrdersShipCountryShipName(@RequestParam("shipCountry") String shipCountry,
																  				@RequestParam("shipName")   String shipName) throws OrdersException {
		logger.info("[getOrdersShipCountryShipName] - [START]");

		List<OrdersResource> resource = (service.getOrdersShipCountryShipName(shipCountry, shipName));
		logger.info("[getOrdersShipCountryShipName] - [END]");
		return ok(resource);
	}
	
	
	@ApiOperation(value = "insert new orders")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping
	public ResponseEntity<String> insertNewOrder(@RequestBody Orders createOrdersDTO) throws OrdersException  {
		logger.info("[insertNewOrder] - [START]");
		service.insertNewOrder(createOrdersDTO);
		logger.info("[insertNewOrder] - [END]");
		return ResponseEntity.ok("Inserimento avvenuto con successo.");
	}
}
