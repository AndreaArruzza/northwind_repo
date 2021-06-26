package com.northwind.northwind.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.northwind.northwind.model.OrderDTO;

@Repository
public interface OrderRepository extends MongoRepository<OrderDTO, String> {

	  //public OrderDTO findByFirstName(String firstName);
	  public List<OrderDTO> findByCustomerID(String customerID);

}