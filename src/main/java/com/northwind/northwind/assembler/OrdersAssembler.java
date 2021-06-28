package com.northwind.northwind.assembler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.northwind.northwind.model.Orders;
import com.northwind.northwind.resource.OrdersResource;
import com.northwind.northwind.resource.ShipInformationOrders;
import com.northwind.northwind.service.OrdersService;

@Component
public class OrdersAssembler {

	private static final Logger logger = LoggerFactory.getLogger(OrdersService.class);
	
    public OrdersResource toResource (Orders orders) {
    	logger.info("[toResource] - [START]");
    	OrdersResource orderResource = new OrdersResource();
    	ShipInformationOrders ship = new ShipInformationOrders();
    	List<ShipInformationOrders> shipInf = new ArrayList<>();

    	orderResource.setOrderID(orders.getOrderID());
        orderResource.setOrderDate(orders.getOrderDate());
        orderResource.setFreight(orders.getFreight());
        orderResource.setRequiredDate(orders.getOrderDate());
        
        ship.setShipCity(orders.getShipCity());
        ship.setShipCountry(orders.getShipCountry());
        ship.setShipName(orders.getShipName());
        ship.setShipPostalCode(orders.getShipPostalCode());
        ship.setShippedDate(orders.getShippedDate());
        shipInf.add(ship);
        orderResource.setShipInformationOrders(shipInf);
        logger.info("[toResource] - [END]");
        
        return orderResource;
    }

}