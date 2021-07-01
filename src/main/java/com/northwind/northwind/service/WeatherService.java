package com.northwind.northwind.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northwind.northwind.MongoCopy;
import com.northwind.northwind.assembler.WeatherAssembler;
import com.northwind.northwind.model.FavoriteLocation;
import com.northwind.northwind.model.FavoriteLocationIn;
import com.northwind.northwind.model.WeatherResponse;
import com.northwind.northwind.mongo.repository.CustomersMongoRepository;
import com.northwind.northwind.mongo.repository.FavoriteLocationMongoRepository;
import com.northwind.northwind.repository.WeatherRepository;
import com.northwind.northwind.resource.WeatherResource;

@Service
public class WeatherService implements MongoCopy<FavoriteLocationIn> {
	private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

	
	@Autowired
	private CustomersMongoRepository repoMongoCust;
	
	@Autowired
	private WeatherRepository repoWeather;
	
	@Autowired
	private WeatherAssembler assembler;

	@Autowired
	private FavoriteLocationMongoRepository repoMongo;
	
	
	//by city name AUTOTHENTICATION + MONGODB
	public List<WeatherResource> getWeatherByCustomerID(String customerID){
		Map<String,Object> params = new HashMap<>();
		List<WeatherResource> weatherResource = new ArrayList<>();
		logger.info("[getWeatherByCustomerID] - [START] ---- customerID:  {}",customerID);
		String cityCustomer = repoMongoCust.findByCustomerID(customerID).getCity();
		params.put("q", cityCustomer);
		weatherResource = getResponse(params);
		logger.info("[getWeatherByCustomerID] - [END]");
		return weatherResource;
	}
	
	//by city name
	public List<WeatherResource> getWeatherByCityName(String cityName){
		Map<String,Object> params = new HashMap<>();
		List<WeatherResource> weatherResource = new ArrayList<>();
		logger.info("[getWeatherByCityName] - [START] ---- cityName:  {}",cityName);
		params.put("q", cityName);
		weatherResource = getResponse(params);
		logger.info("[getWeatherByCityName] - [END]");
		return weatherResource;
	}
	
	//by city id
	public List<WeatherResource> getWeatherByCityID(String cityID){
		Map<String,Object> params = new HashMap<>();
		List<WeatherResource> weatherResource = new ArrayList<>();
		logger.info("[getWeatherByCityID] - [START] ---- cityName:  {}", cityID);
		params.put("id", cityID);
		weatherResource = getResponse(params);
		logger.info("[getWeatherByCityID] - [END]");
		return weatherResource;
	}
	
	//by lat e lon
	public List<WeatherResource> getWeatherByLatLon(Double lat, Double lon){
		Map<String,Object> params = new HashMap<>();
		List<WeatherResource> weatherResource = new ArrayList<>();
		logger.info("[getWeatherByLatLon] - [START] ---- lat:  {},  lon:  {},", lat,lon);
		params.put("lat", lat);
		params.put("lon", lon);
		
		weatherResource = getResponse(params);
		logger.info("[getWeatherByLatLon] - [END]");
		return weatherResource;
	}

	private List<WeatherResource>getResponse (Map<String,Object> params) {
		WeatherResponse response = repoWeather.getWeatherResponse(params);
		
		List<WeatherResource> listResource = new ArrayList<>();
		response.getListWeatherDTO().stream().forEach(p -> 
		{	
				WeatherResource weatherResource = assembler.toResource(p, response.getCity().getName());
				listResource.add(weatherResource);
				logger.info(" weatherResource:{}", weatherResource);
		});
		return listResource;
	}

	public WeatherResource insertFavoriteLocation(List<FavoriteLocationIn> favoriteLoc) {
		WeatherResource resource = new WeatherResource();
		logger.info("[insertFavoriteLocation] - [START] ---- favoriteLoc:  {}",favoriteLoc);
		favoriteLoc.stream().forEach(p ->{
			repoWeather.insert(p);
			copyMongo(p);
		});
		logger.info("[insertFavoriteLocation] - [END]");
		return resource;
	}

	@Override
	public void copyMongo(FavoriteLocationIn dto) {
		logger.info("[copyMongo] - [START] ---- dto:  {}" , dto);
		FavoriteLocation favoriteLoc = new FavoriteLocation();
		favoriteLoc.setCityID(dto.getCityID());
		favoriteLoc.setCustomerID(dto.getCustomerID());
		
		try {
			repoMongo.save(favoriteLoc);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		logger.info("[copyMongo] - [END] ---- dto:  {}" , dto);
	}

	public Map<String, List<WeatherResource>> getWeatherByFavoriteLocation(String customerID) {
		List<FavoriteLocation> favoriteLocation = repoMongo.findFavoriteLocation(customerID);
		
		Map<String, List<WeatherResource>> map = new HashMap<>();
		favoriteLocation.stream().forEach(p -> {
			List<WeatherResource> list = getWeatherByCityID(String.valueOf(p.getCityID()));
			map.put(String.valueOf(p.getCityID()) , list);
		});
		return map;
				
	}
}
