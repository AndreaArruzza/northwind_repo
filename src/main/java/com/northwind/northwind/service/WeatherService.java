package com.northwind.northwind.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northwind.northwind.assembler.WeatherAssembler;
import com.northwind.northwind.exception.WeatherException;
import com.northwind.northwind.model.WeatherResponse;
import com.northwind.northwind.repository.CustomersRepository;
import com.northwind.northwind.resource.WeatherResource;
import com.northwind.northwind.resttemplate.WeatherRestTemplate;

@Service
public class WeatherService {
	private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

	
	@Autowired
	CustomersRepository repo;
	
	@Autowired
	WeatherRestTemplate template;
	
	@Autowired
	WeatherAssembler assembler;

	
	//by city name
	public List<WeatherResource> getWeatherByCustomerID(String customerID) throws WeatherException{
		logger.info("[getWeatherByCustomerID] - [START] ---- customerID:  {}",customerID);
		String cityCustomer = repo.findByCustomerID(customerID).getCity();
		Map<String,Object> params = new HashMap<>();
		params.put("q", cityCustomer);
		List<WeatherResource> weatherResource = getResponse(params);
		logger.info("[getWeatherByCustomerID] - [END]");
		return weatherResource;
	}
	
	//by city name
	public List<WeatherResource> getWeatherByCityName(String cityName) throws WeatherException{
		logger.info("[getWeatherByCityName] - [START] ---- cityName:  {}",cityName);
		Map<String,Object> params = new HashMap<>();
		params.put("q", cityName);
		List<WeatherResource> weatherResource = getResponse(params);
		logger.info("[getWeatherByCityName] - [END]");
		return weatherResource;
	}
	
	//by city id
	public List<WeatherResource> getWeatherByCityID(String cityID) throws WeatherException{
		logger.info("[getWeatherByCityID] - [START] ---- cityName:  {}", cityID);
		Map<String,Object> params = new HashMap<>();
		params.put("id", cityID);
		List<WeatherResource> weatherResource = getResponse(params);
		logger.info("[getWeatherByCityID] - [END]");
		return weatherResource;
	}
	
	//by lat e lon
	public List<WeatherResource> getWeatherByLatLon(Double lat, Double lon) throws WeatherException{
		logger.info("[getWeatherByLatLon] - [START] ---- lat:  {},  lon:  {},", lat,lon);
		Map<String,Object> params = new HashMap<>();
		params.put("lat", lat);
		params.put("lon", lon);
		
		List<WeatherResource> weatherResource = getResponse(params);
		logger.info("[getWeatherByLatLon] - [END]");
		return weatherResource;
	}

	


	private List<WeatherResource>getResponse (Map<String,Object> params) throws WeatherException {
		WeatherResponse response = template.getWeatherResponse(params);
		
		List<WeatherResource> listResource = new ArrayList<>();
		response.getListWeatherDTO().stream().forEach(p -> 
		{	
				WeatherResource weatherResource = assembler.toResource(p, response.getCity().getName());
				listResource.add(weatherResource);
				logger.info(" weatherResource:{}", weatherResource);
		});
		return listResource;
	}
}
