package com.northwind.northwind.service;

import java.util.ArrayList;
import java.util.List;

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

	
	public List<WeatherResource> getWeatherByCustomerID(String customerID) throws WeatherException{
		logger.info("[getWeatherByCustomerID] - [START] ---- customerID:  {}",customerID);
		String cityCustomer = repo.findByCustomerID(customerID).getCity();
		List<WeatherResource> weatherResource = getResponse(cityCustomer);
		logger.info("[getWeatherByCustomerID] - [END]");
		return weatherResource;
	}

	public List<WeatherResource> getWeatherByCityName(String cityName) throws WeatherException{
		logger.info("[getWeatherByCityName] - [START] ---- cityName:  {}",cityName);
		List<WeatherResource> weatherResource = getResponse(cityName);
		logger.info("[getWeatherByCityName] - [END]");
		return weatherResource;
	}


	private List<WeatherResource>getResponse (String param) throws WeatherException {
		WeatherResponse response = template.getWeatherResponse(param);
		
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
