package com.northwind.northwind.assembler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.northwind.northwind.model.Order;
import com.northwind.northwind.resource.OrderResource;
import com.northwind.northwind.resource.ShipInformationOrder;

@Component
public class OrdersAssembler {

	private static final Logger logger = LoggerFactory.getLogger(OrdersAssembler.class);
	
    public OrderResource toResource (Order orders) {
    	logger.info("[toResource] - [START]");
    	OrderResource orderResource = new OrderResource();
    	ShipInformationOrder ship = new ShipInformationOrder();
    	List<ShipInformationOrder> shipInf = new ArrayList<>();

    	orderResource.setOrderID(orders.getOrderID());
        orderResource.setOrderDate(orders.getOrderDate());
        orderResource.setCustomerID(orders.getCustomerID());
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