package com.claycorp.nexstore.api.v1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claycorp.nexstore.api.v1.model.Articles;
import com.claycorp.nexstore.api.v1.repository.ArticlesRepository;

@RestController
@RequestMapping(path="/claycorp/api/v1")
public class CustomerRegistrationController {
	
	@Autowired
	private ArticlesRepository articleRepo;

	@GetMapping(path="/customers")
	public ResponseEntity<String> getAllCustomerDetail(){
		return ResponseEntity.ok().body("Hello Clay");
	}
	
	
	@GetMapping(path="/articles")
	public ResponseEntity<List<Articles>> getAllArticles(){
		List<Articles> articles = articleRepo.findAll();
		return ResponseEntity.ok().body(articles);
	}
}
