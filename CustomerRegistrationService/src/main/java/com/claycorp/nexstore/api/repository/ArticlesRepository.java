package com.claycorp.nexstore.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.claycorp.nexstore.api.model.Articles;

@Repository
public interface ArticlesRepository extends MongoRepository<Articles, String>{

	
}
