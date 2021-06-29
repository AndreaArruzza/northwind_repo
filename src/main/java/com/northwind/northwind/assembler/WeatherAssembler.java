package com.northwind.northwind.assembler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.northwind.northwind.model.ListWeatherDTO;
import com.northwind.northwind.resource.WeatherResource;

@Component
public class WeatherAssembler {
	private static final Logger logger = LoggerFactory.getLogger(WeatherAssembler.class);

	
	 public WeatherResource toResource(ListWeatherDTO listWeather, String cityName) {
		 logger.info("[toResource] - [START]");
		 WeatherResource resource = new WeatherResource();
		 String str = listWeather.getDateTxt();
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		 LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

		 String main 		= listWeather.getWeather().get(0).getMain();
		 String description = listWeather.getWeather().get(0).getDescription();
		 Double tempMax 	= listWeather.getMainWeather().getTempMax();
		 Double temp 		= listWeather.getMainWeather().getTemp();
		 Double tempMin 	= listWeather.getMainWeather().getTempMin();
		 Double feelLike 	= listWeather.getMainWeather().getFeelsLike();
		 Integer humidity 	= listWeather.getMainWeather().getHumidity();

		 String descrWeather = "In the date, ".concat(dateTime.toString()).concat(" in ").concat(cityName).concat(" . ").concat(main).concat(" with ").concat(description)
				 					   .concat(" . The max temperature is ").concat(String.valueOf(tempMax)).concat("°C and min temperature ").concat(String.valueOf(tempMin))
				 					   .concat("°C . Feel like is ").concat(String.valueOf(feelLike)).concat("°C and humidity is ").concat(String.valueOf(humidity).concat(" kg/m³."));
		 
		 
		 resource.setDate(dateTime);
		 resource.setHumidity(humidity);
		 resource.setTemp(temp);
		 resource.setTempMax(tempMax);
		 resource.setTempMin(tempMin);
		 resource.setDescrTemp(descrWeather);
		 
		 logger.info("[toResource] - [END]");
		 return resource;
	 }
}
