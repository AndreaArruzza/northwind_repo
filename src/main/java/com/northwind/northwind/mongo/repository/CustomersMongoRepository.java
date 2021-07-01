package com.northwind.northwind.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.northwind.northwind.model.Customer;

public interface CustomersMongoRepository extends MongoRepository<Customer, String> {
	
	@Query("{ 'CustomerID' : ?0 }")
	public Customer findByCustomerID(String customerID);
}
