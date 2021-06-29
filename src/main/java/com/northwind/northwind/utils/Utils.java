package com.northwind.northwind.utils;

import org.apache.commons.io.Charsets;

import com.fasterxml.jackson.core.JsonProcessingException;
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
	
}
