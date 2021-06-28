package com.northwind.northwind.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.northwind.northwind.exception.WeatherException;
import com.northwind.northwind.resource.WeatherResource;
import com.northwind.northwind.service.WeatherService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path="/weather", produces = { MediaType.APPLICATION_JSON_VALUE, "application/hal+json" })
public class WeatherController {
	
	private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);
	
	@Autowired
	WeatherService service;
	
	@ApiOperation(value = "Return weather next 5 days by customer id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping
    public List<WeatherResource> getWeatherByCustomerID() throws WeatherException {
    	logger.info("[getWeatherByCustomerID] - [START]");
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<WeatherResource> listWeatherResource = service.getWeatherByCustomerID(authentication.getName());
        logger.info("[getWeatherByCustomerID] - [END]");
        return listWeatherResource;
    }
	  
    @ApiOperation(value = "Return weather next 5 days by city name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/{cityName}")
    public List<WeatherResource> getWeatherByCityName(@RequestParam("cityName") String cityName) throws WeatherException {
    	logger.info("[getWeatherByCityName] - [START] ---- cityName: {}", cityName);
        List<WeatherResource> listWeatherResource = service.getWeatherByCityName(cityName);
        logger.info("[getWeatherByCityName] - [END]");
        return listWeatherResource;
    }

}
