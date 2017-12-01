package com.claycorp.nexstore.api.rest;

import java.net.URI;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.claycorp.nexstore.api.exception.GlobalBaseException;
import com.claycorp.nexstore.api.model.CustomResponse;
import com.claycorp.nexstore.api.service.ProductCatalogueService;
import com.claycorp.nexstore.api.util.ResponseBuilder;
import com.claycorp.nexstore.api.vo.ProductVo;

@Controller
@RequestMapping(path = "/claycorp/api/v1", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
						produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProductCatalogueController {

	@Autowired
	private ResponseBuilder<ProductVo> responseBuilder;
	
	@Autowired
	private ProductCatalogueService productRegistrationService;

	@GetMapping(path = "/products")
	public ResponseEntity<CustomResponse<ProductVo>> getAllProductDetail() {
		return ResponseEntity.ok().body(responseBuilder.buildResponse(productRegistrationService.getAllProductDetails(),
				Collections.emptyList()));
	}

	@PostMapping("/products")
	public ResponseEntity<CustomResponse<ProductVo>> addProductDetails(@RequestBody ProductVo productRequest) {

		return ResponseEntity.created(URI.create("/api/dev/claycorp/api/v1/products")).body(responseBuilder
				.buildResponse(productRegistrationService.addProductDetails(productRequest), Collections.emptyList()));
	}

	@PutMapping("/products")
	public ResponseEntity<CustomResponse<ProductVo>> updateProductDetails(@RequestBody ProductVo productRequest)
			throws GlobalBaseException {

		return ResponseEntity.ok().body(responseBuilder
				.buildResponse(productRegistrationService.updateProductDetails(productRequest), Collections.emptyList()));
	}

	@GetMapping("/products/{productId}")
	public ResponseEntity<CustomResponse<ProductVo>> findOneProductDetails(
			@PathVariable(value = "productId") String productId) throws GlobalBaseException {

		return ResponseEntity.ok().body(responseBuilder
				.buildResponse(productRegistrationService.findProductDetails(productId), Collections.emptyList()));
	}

	@DeleteMapping("/products/{productId}")
	public ResponseEntity<?> deleteProductDetails(@PathVariable(value = "productId") String productId)
			throws GlobalBaseException {
		productRegistrationService.deleteProductDetails(productId);
		return ResponseEntity.noContent().build();
	}
}