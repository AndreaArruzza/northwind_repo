package com.northwind.northwind.utils;

import java.util.List;
import java.util.Map;

import org.apache.commons.io.Charsets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
	
	public static String toJson(Object o)
	{	
		ObjectMapper mapper = new ObjectMapper();
		if (o == null) return null;
		try
		{
			byte[] data = mapper.writeValueAsBytes(o);
			return new String(data, Charsets.UTF_8);
		} catch (JsonProcessingException e)
		{
			throw new RuntimeException(e);
		} 
	}
	
	
	public static Map<String, Object> jsonToMap(String json)
	{
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			
			return mapper.readValue(json, new TypeReference<Map<String, Object>>(){});
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public static List<Map<String, Object>> jsonToList(String json)
	{
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			return mapper.readValue(json, new TypeReference<List<Map<String, Object>>>(){});
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
