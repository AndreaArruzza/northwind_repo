package com.northwind.northwind.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.northwind.northwind.model.Pippo;

public interface PippoRepository extends MongoRepository<Pippo, String>  {

}
