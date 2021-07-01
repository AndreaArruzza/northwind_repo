package com.northwind.northwind.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.northwind.northwind.model.User;

public interface UserMongoRepository extends MongoRepository<User, String>  {

}
