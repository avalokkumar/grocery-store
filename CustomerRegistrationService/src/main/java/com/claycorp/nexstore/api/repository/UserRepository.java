package com.claycorp.nexstore.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.claycorp.nexstore.api.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
}