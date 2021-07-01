package com.northwind.northwind.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import javax.validation.Valid;

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

import com.northwind.northwind.model.NorthwindUsersDetails;
import com.northwind.northwind.model.OrderIn;
import com.northwind.northwind.resource.OrderResource;
import com.northwind.northwind.service.OrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path="/orders", produces = { MediaType.APPLICATION_JSON_VALUE, "application/hal+json" })
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService service;
	
	@ApiOperation(value = "return orders by authentication")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/authentication")
	public ResponseEntity<List<OrderResource>> getOrdersByAuthentication(){
		logger.info("[getOrders] - [START]");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		NorthwindUsersDetails principal = (NorthwindUsersDetails) authentication.getPrincipal();
		List<OrderResource> resource = service.getOrdersByCustomerID(principal.getCustomerID());
		logger.info("[getOrders] - [END]");
		return ok(resource);
	}
	

	@ApiOperation(value = "return orders by customer id ")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/customer-id")
	public ResponseEntity<List<OrderResource>>  getOrdersByCustomerID(@RequestParam("customerID") String customerID) {
		logger.info("[getOrdersByCustomerID] - [START]");

		List<OrderResource> resource = (service.getOrdersByCustomerID(customerID));
		logger.info("[getOrdersByCustomerID] - [END]");
		return ok(resource);
	}
	
	
	
	@ApiOperation(value = "return orders by order id ")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/order-id")
	public ResponseEntity<List<OrderResource>>  getOrdersByOrderID(@RequestParam("orderID") Integer orderID){
		  logger.info("[getOrdersByOrderID] - [START]");
		  List<OrderResource> resource = (service.getOrdersByOrderID(orderID));
		  logger.info("[getOrdersByOrderID] - [END]");
		  return ok(resource);
	}
	
	
	@ApiOperation(value = "return orders by ship country and ship name")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/shpCountry-shipName")
	public ResponseEntity<List<OrderResource>>  getOrdersShipCountryShipName(@RequestParam("shipCountry") String shipCountry,
																  			  @RequestParam("shipName")    String shipName) {
		  logger.info("[getOrdersShipCountryShipName] - [START]");
		  List<OrderResource> resource = (service.getOrdersShipCountryShipName(shipCountry, shipName));
		  logger.info("[getOrdersShipCountryShipName] - [END]");
		  return ok(resource);
	}
	
	
	@ApiOperation(value = "insert new orders")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping("/insert")
	public ResponseEntity<String> insertNewOrder(@RequestBody @Valid OrderIn newOrder){
		  logger.info("[insertNewOrder] - [START]");
		  service.insertNewOrder(newOrder);
		  logger.info("[insertNewOrder] - [END]");
		  return ResponseEntity.ok("inserimento avvenuto con successo");
	}
	
}
