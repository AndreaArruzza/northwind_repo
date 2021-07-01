package com.northwind.northwind.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.northwind.northwind.model.Order;

@Repository
public interface OrderMongoRepository extends MongoRepository<Order, String> {
	
	@Query("{ 'CustomerID' : ?0 }")
	public List<Order> findByCustomerID(String customerID);
	
	@Query("{ 'OrderID' : ?0 }")
	public Order findByOrderID(Integer orderID);

	@Query("{ 'ShipCountry' : ?0 , 'ShipName' : ?1}")
	public List<Order> findByShipCountryShipName(String shipCountry, String shipName);
	
	
}