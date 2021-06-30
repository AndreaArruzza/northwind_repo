package com.northwind.northwind.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.northwind.northwind.assembler.OrdersAssembler;
import com.northwind.northwind.exception.UserAlreadyExistException;
import com.northwind.northwind.model.Users;
import com.northwind.northwind.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping(path="/register", produces = { MediaType.APPLICATION_JSON_VALUE, "application/hal+json" })
public class RegisterController {
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	
	@Autowired
	UserService service;
	
	@Autowired
	OrdersAssembler assembler;
	
	@ApiOperation(value = "insert new order")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping
	public ResponseEntity<String> insertNewUser(@RequestBody Users createUsers) throws UserAlreadyExistException {
		logger.info("[register] - [START]");
		service.insertNewUser(createUsers);
		logger.info("[register] - [END]");
		return ResponseEntity.ok("Inserimento avvenuto con successo.");
	}
}
