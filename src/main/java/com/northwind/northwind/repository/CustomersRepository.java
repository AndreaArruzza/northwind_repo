package com.northwind.northwind.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.northwind.northwind.model.Customers;

public interface CustomersRepository extends MongoRepository<Customers, String> {
	
	@Query("{ 'CustomerID' : ?0 }")
	public Customers findByCustomerID(String customerID);
}
