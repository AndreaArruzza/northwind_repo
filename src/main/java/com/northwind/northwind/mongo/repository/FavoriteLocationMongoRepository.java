package com.northwind.northwind.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.northwind.northwind.model.FavoriteLocation;

public interface FavoriteLocationMongoRepository extends MongoRepository<FavoriteLocation, String>  {
	@Query("{ 'CustomerID' : ?0 }")
	List<FavoriteLocation> findFavoriteLocation(String customerID);

}
