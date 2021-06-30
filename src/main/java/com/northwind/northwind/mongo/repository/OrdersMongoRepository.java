package com.northwind.northwind.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.northwind.northwind.model.Orders;

@Repository
public interface OrdersMongoRepository extends MongoRepository<Orders, String> {
	
	@Query("{ 'CustomerID' : ?0 }")
	public List<Orders> findByCustomerID(String customerID);
	
	@Query("{ 'OrderID' : ?0 }")
	public Orders findByOrderID(Integer orderID);

	@Query("{ 'ShipCountry' : ?0 , 'ShipName' : ?1}")
	public List<Orders> findByShipCountryShipName(String shipCountry, String shipName);
	
	
}