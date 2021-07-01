package com.northwind.northwind.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.northwind.northwind.Constants;
import com.northwind.northwind.model.OrderIn;
import com.northwind.northwind.mongo.repository.OrderMongoRepository;
import com.northwind.northwind.utils.Util;

@Repository
public class OrderRepository{
	
	private static final Logger logger = LoggerFactory.getLogger(OrderRepository.class);
	
	@Autowired
	OrderMongoRepository repoMongo;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insert(OrderIn newOrder){
		logger.info("[Inizio inserimento]  di ordine {}...", newOrder);
		try {
				jdbcTemplate.update(Util.readQuery(Constants.INSERT_NEW_ORDER),  newOrder.getCustomerID()    , newOrder.getEmployeeID() , newOrder.getOrderDate()  ,  newOrder.getRequiredDate(), newOrder.getShippedDate() , 
																				  newOrder.getShipVia()	      , newOrder.getFreight()    , newOrder.getShipName()   , newOrder.getShipAddress()	 , newOrder.getShipCity()    , newOrder.getShipRegion(),
																				  newOrder.getShipPostalCode(), newOrder.getShipCountry());
			logger.info("Fine inserimento ordini.");
		}
		catch(Exception e ) {
			logger.error("[insert] ----- [ERROR] ----- ".concat(e.getMessage()));
			throw new RuntimeException(e);
		}
	}
	
	
	public Integer getLastOrderID() {
		Integer orderID = 0;
		try {
			logger.info("[getLastOrderID] ----- [START]");
			orderID = jdbcTemplate.queryForObject(Util.readQuery(Constants.GET_LAST_ORDER_ID),  Integer.class);
			logger.info("[getLastOrderID] ----- [END]---- lastOrderID: {}", orderID);
		}
		catch(Exception e ) {
			logger.error("[getLastOrderID] ----- [ERROR] ----- ".concat(e.getMessage()));
			throw new RuntimeException(e);
		}
		return orderID;
	}
}
