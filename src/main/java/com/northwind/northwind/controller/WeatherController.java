//package com.northwind.northwind.controller;
//
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.northwind.northwind.resource.WeatherResource;
//
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//
//@RestController
//@RequestMapping(path="/weather", produces = { MediaType.APPLICATION_JSON_VALUE, "application/hal+json" })
//public class WeatherController {
//	
//
//    @ApiOperation(value = "Return weather next 5 days")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success|OK"),
//            @ApiResponse(code = 401, message = "not authorized!"),
//            @ApiResponse(code = 403, message = "forbidden!!!"),
//            @ApiResponse(code = 404, message = "not found!!!") })
//    @GetMapping
//	public ResponseEntity<WeatherResource> getWeather(@RequestParam("customerID")){
//		
//    	return null;
//    	
//    }
//}
