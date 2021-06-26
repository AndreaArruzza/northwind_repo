package com.northwind.northwind.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.northwind.northwind.model.Orders;
import com.northwind.northwind.resource.OrdersResource;
import com.northwind.northwind.resource.ShipInformationOrders;

@Component
public class OrdersAssembler {


    public OrdersResource instantiateResource ( Orders orders) {
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
        
        return orderResource;
    }


}
