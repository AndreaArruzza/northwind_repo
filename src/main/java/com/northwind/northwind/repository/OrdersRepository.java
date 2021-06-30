package com.northwind.northwind.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.northwind.northwind.Constants;
import com.northwind.northwind.exception.OrdersException;
import com.northwind.northwind.model.Orders;
import com.northwind.northwind.mongo.repository.OrdersMongoRepository;
import com.northwind.northwind.utils.Utils;

@Repository
public class OrdersRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(OrdersRepository.class);
	
	@Autowired
	OrdersMongoRepository repoMongo;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean insert(List<Orders> orders) throws OrdersException {
		boolean execSqlServer = false;
		logger.info("[Inizio inserimento]  di {} ordini...", orders.size());
		try {
			orders.stream().forEach(p -> {
				jdbcTemplate.update(Utils.readQuery(Constants.INSERT_NEW_ORDER),  p.getCustomerID(), p.getEmployeeID() , p.getOrderDate() ,  p.getRequiredDate(), p.getShippedDate(), 
																				  p.getShipVia(), p.getFreight()   , p.getShipName()   , p.getShipAddress(), p.getShipCity()    , p.getShipRegion(),
																				  p.getShipPostalCode(), p.getShipCountry());
				insertNewRecordMongo(p);
			});
			logger.info("Fine inserimento ordini.");
		}
		catch(Exception e ) {
			logger.error(e.getMessage());
			throw new OrdersException("[INSERT] Errore in OrdersRepository.insert");
		}
		return execSqlServer;
	}
	
	
	public Integer getLastOrderID() throws OrdersException {
		Integer orderID = 0;
		try {
			logger.info("[getLastOrderID] ----- [START]");
			orderID = jdbcTemplate.queryForObject(Utils.readQuery(Constants.GET_LAST_ORDER_ID),  Integer.class);
			logger.info("[getLastOrderID] ----- [END]---- lastOrderID: {}", orderID);
		}
		catch(Exception e ) {
			logger.error(e.getMessage());
			throw new OrdersException("[GET] Errore in OrdersRepository.getLastOrderID");
		}
		return orderID;
	}
	
	
	private void insertNewRecordMongo(Orders p) {
		Orders order = new Orders();
		order.setOrderDate(p.getOrderDate());
		order.setRequiredDate(p.getRequiredDate());
		order.setShippedDate(p.getShippedDate());
		order.setCustomerID(p.getCustomerID());
		order.setEmployeeID(p.getEmployeeID());
		order.setFreight(p.getFreight());
		order.setShipAddress(p.getShipAddress());
		order.setShipCity(p.getShipCity());
		order.setShipCountry(p.getShipCountry());
		order.setShipName(p.getShipName());
		order.setShipPostalCode(p.getShipPostalCode());
		order.setShipRegion(p.getShipRegion());
		order.setShipVia(p.getShipVia());
		try {
			order.setOrderID(getLastOrderID());
		} catch (OrdersException e) {
			logger.error(e.getMessage());
		}
		
		repoMongo.save(order);
	}
}
