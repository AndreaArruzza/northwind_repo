package com.northwind.northwind.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;
import java.util.Map;

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

import com.northwind.northwind.model.FavoriteLocationIn;
import com.northwind.northwind.model.NorthwindUsersDetails;
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
	private WeatherService service;
	
	@ApiOperation(value = "Return weather next 5 days by customer id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/customer-id")
    public ResponseEntity<List<WeatherResource>> getWeatherByCustomerID() {
		logger.info("[getWeatherByCustomerID] - [START]");
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	NorthwindUsersDetails principal = (NorthwindUsersDetails) authentication.getPrincipal();
        List<WeatherResource> resource = service.getWeatherByCustomerID(principal.getCustomerID());
        logger.info("[getWeatherByCustomerID] - [END]");
        return ok(resource);
    }
	  
    @ApiOperation(value = "Return weather next 5 days by city id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/city-ID")
    public ResponseEntity<List<WeatherResource>> getWeatherByCityID(@RequestParam("cityID") String cityID) {
		logger.info("[getWeatherByCityName] - [START] ---- cityName: {}", cityID);
		List<WeatherResource> resource = service.getWeatherByCityID(cityID);
		logger.info("[getWeatherByCityName] - [END]");
		 return ok(resource);
	}
    
    
    @ApiOperation(value = "Return weather next 5 days by city name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/city-name")
    public ResponseEntity<List<WeatherResource>> getWeatherByCityName(@RequestParam("cityName") String cityName) {
    	logger.info("[getWeatherByCityName] - [START] ---- cityName: {}", cityName);
        List<WeatherResource> resource = service.getWeatherByCityName(cityName);
        logger.info("[getWeatherByCityName] - [END]");
        return ok(resource);
    }
    
    
    @ApiOperation(value = "Return weather next 5 days by favorite location")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/favorite-location")
    public ResponseEntity<Map<String,List<WeatherResource>>> getWeatherByFavoriteLocation() {
		logger.info("[getWeatherByCustomerID] - [START]");
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	NorthwindUsersDetails principal = (NorthwindUsersDetails) authentication.getPrincipal();
        Map<String,List<WeatherResource>> resource = service.getWeatherByFavoriteLocation(principal.getCustomerID());
        logger.info("[getWeatherByCustomerID] - [END]");
        return ok(resource);
    }
	  
    
    @ApiOperation(value = "Return weather next 5 days by latitude and longitude")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/latitude-longitude")
    public ResponseEntity<List<WeatherResource>> getWeatherByLatLon(@RequestParam("lat") Double lat,
    																@RequestParam("lon") Double lon) {
    	logger.info("[getWeatherByLatLon] - [START] ---- lat: {} ---- lon: {}", lat, lon);
        List<WeatherResource> resource = service.getWeatherByLatLon(lat, lon);
        logger.info("[getWeatherByLatLon] - [END]");
        return ok(resource);
    }
    
	@ApiOperation(value = "insert new favorite location")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping("/insert")
	public ResponseEntity<WeatherResource> insertFavoriteLocation(@RequestBody @Valid List<FavoriteLocationIn> favoriteLoc) {
		logger.info("[insertFavoriteLocation] - [START]");
		WeatherResource resource = service.insertFavoriteLocation(favoriteLoc);
		logger.info("[insertFavoriteLocation] - [END]");
		return ok(resource);
	}

}
