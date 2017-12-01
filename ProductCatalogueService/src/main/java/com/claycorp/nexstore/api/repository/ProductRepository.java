package com.claycorp.nexstore.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.claycorp.nexstore.api.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

}
