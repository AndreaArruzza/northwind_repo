package com.northwind.northwind.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.northwind.northwind.MongoCopy;
import com.northwind.northwind.assembler.OrdersAssembler;
import com.northwind.northwind.model.OrderIn;
import com.northwind.northwind.model.Order;
import com.northwind.northwind.mongo.repository.OrderMongoRepository;
import com.northwind.northwind.repository.OrderRepository;
import com.northwind.northwind.resource.OrderResource;

@Service
@Transactional
public class OrderService implements MongoCopy<OrderIn> {
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	OrderMongoRepository repoMongo;
	
	@Autowired
	OrderRepository repo;
	
	@Autowired
	OrdersAssembler assembler;
	
	
	//by customer id
	public List<OrderResource> getOrdersByCustomerID(String customerID) {
		logger.info("[getOrderByCustomerID] - [START] ---- customerID:  {}",customerID);
		List<OrderResource> resource = new ArrayList<>();
		
		logger.info("[findByCustomerID --- Mongodb] - [START] ---- customerID:  {}", customerID);
		List<Order> listOrders =  repoMongo.findByCustomerID(customerID);
		logger.info("[findByCustomerID --- Mongodb] - [END] ---- listOrders:  {}", listOrders);
	
		if(!listOrders.isEmpty()) {
			listOrders.stream().forEach(p -> 
			{		
				OrderResource orderResource = new OrderResource();
				orderResource = assembler.toResource(p);
				resource.add(orderResource);
				logger.info(" orderResource:{}", orderResource);
			});
		}
		else {
			OrderResource orderResource = new OrderResource();
			logger.error("  non vi sono ordini associati al customer ID indicato :  {} ", customerID);
			orderResource.setMessage("non vi sono ordini associati al customer ID indicato :  ".concat(customerID));
			resource.add(orderResource);
		}
		
		
		logger.info("[getOrderByCustomerID] - [END]");
		return resource;
	}
	
	//by order id
	public List<OrderResource> getOrdersByOrderID(Integer orderID) {
		logger.info("[getOrdersByOrderID] - [START] ---- orderID:  {}",orderID);
		OrderResource orderResource = new OrderResource();
		List<OrderResource> resource = new ArrayList<>();
		logger.info("[findByOrderID --- Mongodb] - [START] ---- orderID:  {}", orderID);
		Order order =  repoMongo.findByOrderID(orderID);
		logger.info("[findByOrderID --- Mongodb] - [END] ---- listOrders:  {}", order);
		
		if(order != null) {
			orderResource = assembler.toResource(order);
			resource.add(orderResource);
			logger.info(" orderResource:{}", orderResource);
		}
		else {
			orderResource.setMessage("non vi sono ordini associati al order ID indicato :  ".concat(String.valueOf(orderID)));
			logger.error("  non vi sono ordini associati al order ID indicato :  {} ", orderID);
			resource.add(orderResource);
		}
		
		logger.info("[getOrdersByOrderID] - [END]");
		return resource;
	}
	
	//by ship country e ship name
	public List<OrderResource> getOrdersShipCountryShipName(String shipCountry, String shipName) {
		logger.info("[getOrdersShipCountryShipName] - [START] ---- ");
		
		List<OrderResource> resource = new ArrayList<>();
		logger.info("[getOrdersShipCountryShipName --- Mongodb] - [START] ---- :  {} - {}", shipCountry, shipName);
		List<Order> listOrders =  repoMongo.findByShipCountryShipName(shipCountry, shipName);
		logger.info("[getOrdersShipCountryShipName --- Mongodb] - [END] ---- listOrders:  {}", listOrders);
		
		if(!listOrders.isEmpty()) {
			listOrders.stream().forEach(p -> 
			{	
				OrderResource orderResource = new OrderResource();
				orderResource = assembler.toResource(p);
				resource.add(orderResource);
				logger.info(" orderResource:{}", orderResource);
			});
		}
		else {
			OrderResource orderResource = new OrderResource();
			orderResource.setMessage(" non vi sono ordini associati al shipCountry : ".concat(shipCountry).concat(" e  shipName  indicaio :   ").concat(shipName));
			logger.error("  non vi sono ordini associati al shipCountry e  shipName  indicaio :  {} - {}", shipCountry, shipName);
			resource.add(orderResource);
		}
		
		logger.info("[getOrdersShipCountryShipName] - [END]");
		return resource;
	}
	
	//insert new order o copy
	public OrderResource insertNewOrder(OrderIn newOrder)  {
		logger.info("[insertNewOrder] - [START] ---- createOrders:  {}",newOrder);
		List<Order> orders = new ArrayList<>();
		OrderResource orderResource = new OrderResource();
		//verifico se è un nuovo ordine o no
		if(!newOrder.getNewOrder()) {
			prepareCopyOrder(newOrder);
		}

		logger.info("[repo.insert] - [START] ---- orders:  {}", orders);
		try {
			repo.insert(newOrder);
			logger.info("[repo.insert] - [END]");
			copyMongo(newOrder);
			orderResource.setMessage("inserimento avvenuto con successo");
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		logger.info("[insertNewOrder] - [END]");
		return orderResource;
	}
	
	
	private void prepareCopyOrder(OrderIn newOrder) {
		logger.info("[findByCustomerID --- Mongodb] - [START] ---- orderID:  {}", newOrder.getOrderID());
		try {
			Order copyOrder = repoMongo.findByOrderID(newOrder.getOrderID());
			logger.info("[findByCustomerID --- Mongodb] - [END] ---- copyOrder:  {}", copyOrder);
			
			newOrder.setOrderDate(LocalDateTime.now());
			newOrder.setRequiredDate(LocalDateTime.now());
			newOrder.setShippedDate(null);
			newOrder.setCustomerID(copyOrder.getCustomerID());
			newOrder.setEmployeeID(copyOrder.getEmployeeID());
			newOrder.setFreight(copyOrder.getFreight());
			newOrder.setOrderID(copyOrder.getOrderID());
			newOrder.setShipAddress(copyOrder.getShipAddress());
			newOrder.setShipCity(copyOrder.getShipCity());
			newOrder.setShipCountry(copyOrder.getShipCountry());
			newOrder.setShipName(copyOrder.getShipName());
			newOrder.setShipPostalCode(copyOrder.getShipPostalCode());
			newOrder.setShipRegion(copyOrder.getShipRegion());
			newOrder.setShipVia(copyOrder.getShipVia());
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void copyMongo(OrderIn dto) {
		logger.info("[copyMongo] - [START] ---- dto:  {}" , dto);
		Order order = new Order();
		order.setOrderDate(dto.getOrderDate());
		order.setRequiredDate(dto.getRequiredDate());
		order.setShippedDate(dto.getShippedDate());
		order.setCustomerID(dto.getCustomerID());
		order.setEmployeeID(dto.getEmployeeID());
		order.setFreight(dto.getFreight());
		order.setShipAddress(dto.getShipAddress());
		order.setShipCity(dto.getShipCity());
		order.setShipCountry(dto.getShipCountry());
		order.setShipName(dto.getShipName());
		order.setShipPostalCode(dto.getShipPostalCode());
		order.setShipRegion(dto.getShipRegion());
		order.setShipVia(dto.getShipVia());
		
		try {
			order.setOrderID(repo.getLastOrderID());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		logger.info("[copyMongo] - [END]");
		repoMongo.save(order);
	}

	
}