package com.northwind.northwind.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.northwind.northwind.model.Orders;

@Repository
public interface OrdersRepository extends MongoRepository<Orders, String> {
	
	@Query("{ 'CustomerID' : ?0 }")
	public List<Orders> findByCustomerID(String customerID);
}