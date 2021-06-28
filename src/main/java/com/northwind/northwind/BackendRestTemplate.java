package com.northwind.northwind;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.northwind.northwind.exception.WeatherException;
import com.northwind.northwind.utils.Utils;
import java.util.Optional;

@Component
public class BackendRestTemplate {
	
	private static final Logger logger = LoggerFactory.getLogger(RestTemplate.class);
	
	public String post(Map<String, String> body, String url) throws WeatherException {
		RestTemplate restTemplate = new RestTemplate();
		
		String currentToken = generateToken();
		Date startDate = new Date();
		logger.info("[@BackendRestTemplate" + currentToken + "] " + "chiamata al backend BackendRestTemplate UTF8 new.....: " + url + "...");
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity<?> entity = new HttpEntity<>(Utils.toJson(body),headers);
		logger.info("chiamata restTemplate con entity " + entity + " url " + url);
		try {
			ResponseEntity<?> response = restTemplate.exchange(url, HttpMethod.POST,entity, Object.class);
			Optional<Object> responseOptional = Optional.ofNullable(response.getBody());
			Date endDate = new Date();
			logger.info("[@BackendRestTemplate" + currentToken + "] " + "chiamata al backend BackendRestTemplate: " + url + " OK in ["+ (endDate.getTime() - startDate.getTime()) / 1 + "]ms");
			
			Object responseObj = responseOptional.orElse(null);
			String resultJson = "";
			if(responseObj != null) {
				resultJson = Utils.toJson(responseObj);
			}
			return resultJson;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new WeatherException("Errore durante la chiamata al servizio con url ".concat(url).concat("body: ").concat(Utils.toJson(body))); 
		}
	}
	
	public String get(Map<String, String> body, String url) throws WeatherException {
		RestTemplate restTemplate = new RestTemplate();
		
		String currentToken = generateToken();
		Date startDate = new Date();
		logger.info("[@BackendRestTemplate" + currentToken + "] " + "chiamata al backend BackendRestTemplate UTF8 new.....: " + url + "...");
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		for (Map.Entry<String, String> entry : body.entrySet()) {
		    builder.queryParam(entry.getKey(), entry.getValue());
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity<?> entity = new HttpEntity<>(null ,headers);	
		logger.info("chiamata restTemplate con entity " + entity + " url " + url);
		try {
			ResponseEntity<?> response = restTemplate.exchange(builder.toUriString(),HttpMethod.GET, entity,Object.class,body);
			
			Optional<Object> responseOptional = Optional.ofNullable(response.getBody());
			Date endDate = new Date();
			
			logger.info("[@BackendRestTemplate" + currentToken + "] " + "chiamata al backend BackendRestTemplate: " + url + " OK in ["+ (endDate.getTime() - startDate.getTime()) / 1 + "]ms");
			Object responseObj = responseOptional.orElse(null);
			String resultJson = "";
			if(responseObj != null) {
				resultJson = Utils.toJson(responseObj);
			}
			return resultJson;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new WeatherException("Errore durante la chiamata al servizio con url ".concat(builder.toUriString())); 
		}
	}
	
	protected static String generateToken(){
        return  new Long(new Date().getTime()).toString();
	}

}