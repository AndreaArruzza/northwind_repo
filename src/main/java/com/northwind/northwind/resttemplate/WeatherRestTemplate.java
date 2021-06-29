package com.northwind.northwind.resttemplate;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.northwind.northwind.BackendRestTemplate;
import com.northwind.northwind.exception.WeatherException;
import com.northwind.northwind.model.WeatherResponse;

@Component
public class WeatherRestTemplate {
	private static final Logger logger = LoggerFactory.getLogger(WeatherRestTemplate.class);

	@Value("${spring.APPID}")
	public String appId;
	
	@Value("${spring.weather_service_url}")
	public String url;
	
	@Autowired
	BackendRestTemplate backendRestTemplate;
	
	public WeatherResponse getWeatherResponse(String param) throws WeatherException {
		Map<String,String> params = new HashMap<>();
		params.put("q", param);
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
			throw new WeatherException("Errore durante la conversione alla response");
		}
		
		logger.info("[getWeatherResponse] - [END] ---- url:  {}" , url);
		return listWeather;
	}
}
