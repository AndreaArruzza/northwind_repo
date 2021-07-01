package com.northwind.northwind.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import javax.swing.text.Utilities;

import org.apache.commons.io.Charsets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {
	private static Util utils;
	
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
	
	
	private Util() {
	}
	
	public static Util getInstance() {
		if (utils == null)
			utils = new Util();
		return utils;
	}
	
	public String readTxtFromClasspath(String path) {
	    InputStream is = getClass().getResourceAsStream(path);
	    String result = null;
	    if (is != null) {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	        result = reader.lines().collect(Collectors.joining(System.lineSeparator()));
	    }
		return result;
	}
	
	public static final String readQuery(String query) {
		return Util.getInstance().readTxtFromClasspath(query);
	}
	
}
