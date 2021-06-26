//package com.northwind.northwind.config;
//
//import java.util.Collection;
//import java.util.Collections;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//import com.mongodb.ConnectionString;
//import com.mongodb.MongoClientSettings;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//
//@Configuration
//@EnableMongoRepositories(basePackages = "com.northwind.northwind.repository")
//public class MongoConfig extends AbstractMongoClientConfiguration {
//
//	@Override
//	protected String getDatabaseName() {
//		   return "Northwind";
//	}
// 
// 
//    @Override
//    public MongoClient mongoClient() {
//        ConnectionString connectionString = new ConnectionString("mongodb://mongoadmin:123Mongo@127.0.0.1:28017/Northwind?authSource=admin");
//        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//            .applyConnectionString(connectionString)
//            .build();
//        
//        return MongoClients.create(mongoClientSettings);
//    }
// 
//    @Override
//    public Collection getMappingBasePackages() {
//        return Collections.singleton("com.northwind.northwind");
//    }
//}