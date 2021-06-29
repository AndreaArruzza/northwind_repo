package com.northwind.northwind.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.microsoft.sqlserver.jdbc.SQLServerException;

@Configuration
public class ConfigDatasource {
	
	@Value("${spring.datasource.username}")
	private String dbUsername;
	@Value("${spring.datasource.password}")
	private String dbPassword;
	@Value("${spring.datasource.driverClassName}")
	private String dbDriver;
	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource)
	{
		return new JdbcTemplate(dataSource);
	}
	
	@Bean 
	public NamedParameterJdbcTemplate getJdbcTemplate(DataSource dataSource) 
	{ 
	    return new NamedParameterJdbcTemplate(dataSource); 
	} 
	
	@Bean(name = "dataSource")
	public DataSource dataSource() 
	{	
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dbDriver);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUsername);
		dataSource.setPassword(dbPassword);
	
	return dataSource;}
	
	@Bean
	public DataSourceTransactionManager transactionManager()
	{
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		
		return transactionManager;
	}
}
