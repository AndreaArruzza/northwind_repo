package com.northwind.northwind.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.northwind.northwind.BackendRestTemplate;
import com.northwind.northwind.Constants;
import com.northwind.northwind.exception.WeatherException;
import com.northwind.northwind.model.FavoriteLocationIn;
import com.northwind.northwind.model.WeatherResponse;
import com.northwind.northwind.resource.WeatherResource;
import com.northwind.northwind.utils.Util;

@Component
public class WeatherRepository {
	private static final Logger logger = LoggerFactory.getLogger(WeatherRepository.class);

	@Value("${spring.APPID}")
	public String appId;
	
	@Value("${spring.weather_service_url}")
	public String url;
	
	@Autowired
	BackendRestTemplate backendRestTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public WeatherResponse getWeatherResponse(Map<String,Object> params)  {
		
		params.put("units", "metric");
		params.put("APPID", appId);
		
		logger.info("[getWeatherResponse] - [START] ---- url:  {}" , url);
		String responseJson = backendRestTemplate.get(params, url);
		logger.info("[controllo response] con result: {} ", responseJson);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		
		WeatherResponse listWeather = new WeatherResponse();
		try
		{
			listWeather = mapper.readValue(responseJson, WeatherResponse.class);
		} catch (Exception e)
		{
			logger.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		
		logger.info("[getWeatherResponse] - [END] ---- url:  {}" , url);
		return listWeather;
	}
	
	public void insert (FavoriteLocationIn p) {
		try {
			jdbcTemplate.update(Util.readQuery(Constants.INSERT_FAVORITE_LOCATION),  p.getCityID(), p.getCustomerID());
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}

}
