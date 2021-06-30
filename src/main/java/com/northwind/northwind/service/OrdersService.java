package com.northwind.northwind.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northwind.northwind.assembler.OrdersAssembler;
import com.northwind.northwind.exception.OrdersException;
import com.northwind.northwind.model.Orders;
import com.northwind.northwind.mongo.repository.OrdersMongoRepository;
import com.northwind.northwind.repository.OrdersRepository;
import com.northwind.northwind.resource.OrdersResource;

@Service
public class OrdersService  {
	private static final Logger logger = LoggerFactory.getLogger(OrdersService.class);

	@Autowired
	OrdersMongoRepository repoMongo;
	
	@Autowired
	OrdersRepository repo;
	
	@Autowired
	OrdersAssembler assembler;
	
	//by customer id
	public List<OrdersResource> getOrdersByCustomerID(String customerID) throws OrdersException {
		logger.info("[getOrderByCustomerID] - [START] ---- customerID:  {}",customerID);
		
		logger.info("[findByCustomerID --- Mongodb] - [START] ---- customerID:  {}", customerID);
		List<Orders> listOrders =  repoMongo.findByCustomerID(customerID);
		logger.info("[findByCustomerID --- Mongodb] - [END] ---- listOrders:  {}", listOrders);
		List<OrdersResource> resource = new ArrayList<>();
		
		if(!listOrders.isEmpty()) {
			listOrders.stream().forEach(p -> 
			{	
				OrdersResource orderResource = assembler.toResource(p);
				resource.add(orderResource);
				logger.info(" orderResource:{}", orderResource);
			});
		}
		else {
			logger.error("  non vi sono ordini associati al customer ID indicato :  {}", customerID);
			throw new OrdersException(" non vi sono ordini associati al customer ID indicato : ".concat(customerID));
		}
		
		logger.info("[getOrderByCustomerID] - [END]");
		return resource;
	}
	
	//by order id
	public List<OrdersResource> getOrdersByOrderID(Integer orderID) throws OrdersException {
		logger.info("[getOrdersByOrderID] - [START] ---- orderID:  {}",orderID);
		
		logger.info("[findByOrderID --- Mongodb] - [START] ---- orderID:  {}", orderID);
		Orders order =  repoMongo.findByOrderID(orderID);
		logger.info("[findByOrderID --- Mongodb] - [END] ---- listOrders:  {}", order);
		List<OrdersResource> resource = new ArrayList<>();
		
		if(order != null) {
			OrdersResource orderResource = assembler.toResource(order);
			resource.add(orderResource);
			logger.info(" orderResource:{}", orderResource);
		}
		else {
			logger.error("  non vi sono ordini associati al orderID ID indicato :  {}", orderID);
			throw new OrdersException(" non vi sono ordini associati al order ID indicato : ".concat(String.valueOf(orderID)));
		}
		
		logger.info("[getOrdersByOrderID] - [END]");
		return resource;
	}
	
	//by ship country e ship name
	public List<OrdersResource> getOrdersShipCountryShipName(String shipCountry, String shipName) throws OrdersException {
		logger.info("[getOrdersShipCountryShipName] - [START] ---- ");
		
		logger.info("[getOrdersShipCountryShipName --- Mongodb] - [START] ---- :  {} - {}", shipCountry, shipName);
		List<Orders> listOrders =  repoMongo.findByShipCountryShipName(shipCountry, shipName);
		logger.info("[getOrdersShipCountryShipName --- Mongodb] - [END] ---- listOrders:  {}", listOrders);
		List<OrdersResource> resource = new ArrayList<>();
		
		if(!listOrders.isEmpty()) {
			listOrders.stream().forEach(p -> 
			{	
				OrdersResource orderResource = assembler.toResource(p);
				resource.add(orderResource);
				logger.info(" orderResource:{}", orderResource);
			});
		}
		else {
			logger.error("  non vi sono ordini associati al shipCountry e  shipName  indicaio :  {} - {}", shipCountry, shipName);
			throw new OrdersException(" non vi sono ordini");
		}
		
		logger.info("[getOrdersShipCountryShipName] - [END]");
		return resource;
	}
	
	//insert new order o copy
	public void insertNewOrder(Orders createOrders) throws OrdersException {
		logger.info("[insertNewOrder] - [START] ---- createOrders:  {}",createOrders);
		List<Orders> orders = new ArrayList<>();
		
		//verifico se è un nuovo ordine o no
		if(!createOrders.getNewOrder()) {
			prepareCopyOrder(createOrders, orders);
		}
		else {
			orders.add(createOrders);
		}
		logger.info("[repo.insert] - [START] ---- orders:  {}", orders);
		boolean execSqlServer = repo.insert(orders);
		logger.info("[repo.insert] - [END] ---- execSqlServer:  {}", execSqlServer);
//		if(execSqlServer) {
//			insertNewRecordMongo(orders);
//		}
		logger.info("[insertNewOrder] - [END]");
		
	}
	
	
	private void prepareCopyOrder(Orders createOrders, List<Orders> orders) throws OrdersException {
		logger.info("[findByCustomerID --- Mongodb] - [START] ---- orderID:  {}", createOrders.getOrderID());
		Orders copyOrder = repoMongo.findByOrderID(createOrders.getOrderID());
		logger.info("[findByCustomerID --- Mongodb] - [END] ---- copyOrder:  {}", copyOrder);
		
		if(copyOrder != null){
			createOrders.setOrderDate(LocalDateTime.now());
			createOrders.setRequiredDate(LocalDateTime.now());
			createOrders.setShippedDate(null);
			createOrders.setCustomerID(copyOrder.getCustomerID());
			createOrders.setEmployeeID(copyOrder.getEmployeeID());
			createOrders.setFreight(copyOrder.getFreight());
			createOrders.setOrderID(copyOrder.getOrderID());
			createOrders.setShipAddress(copyOrder.getShipAddress());
			createOrders.setShipCity(copyOrder.getShipCity());
			createOrders.setShipCountry(copyOrder.getShipCountry());
			createOrders.setShipName(copyOrder.getShipName());
			createOrders.setShipPostalCode(copyOrder.getShipPostalCode());
			createOrders.setShipRegion(copyOrder.getShipRegion());
			createOrders.setShipVia(copyOrder.getShipVia());
			
			orders.add(createOrders);
		}
		else {
			logger.error("  non vi sono ordini associati al order ID indicato :  {}", createOrders.getOrderID());
			throw new OrdersException(" non vi sono ordini associati al customer ID indicato : ".concat(String.valueOf(createOrders.getOrderID())));
		}
	}

//	private void insertNewRecordMongo(List<Orders> orders) {
//		orders.stream().forEach(p -> {
//			Orders order = new Orders();
//			order.setOrderDate(p.getOrderDate());
//			order.setRequiredDate(p.getRequiredDate());
//			order.setShippedDate(p.getShippedDate());
//			order.setCustomerID(p.getCustomerID());
//			order.setEmployeeID(p.getEmployeeID());
//			order.setFreight(p.getFreight());
//			order.setShipAddress(p.getShipAddress());
//			order.setShipCity(p.getShipCity());
//			order.setShipCountry(p.getShipCountry());
//			order.setShipName(p.getShipName());
//			order.setShipPostalCode(p.getShipPostalCode());
//			order.setShipRegion(p.getShipRegion());
//			order.setShipVia(p.getShipVia());
//			try {
//				order.setOrderID(repo.getLastOrderID());
//			} catch (OrdersException e) {
//				logger.error(e.getMessage());
//			}
//			
//			repoMongo.save(order);
//		});
//		
//	}

	
}