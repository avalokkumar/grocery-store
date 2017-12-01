package com.claycorp.nexstore.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.claycorp.nexstore.api.exception.InvalidProductException;
import com.claycorp.nexstore.api.exception.UpdateFailureException;
import com.claycorp.nexstore.api.vo.ProductVo;

@Service
public interface ProductCatalogueService {

	List<ProductVo> getAllProductDetails();
	
	List<ProductVo> addProductDetails(ProductVo productRequest);
	
	List<ProductVo> updateProductDetails(ProductVo productRequest) throws UpdateFailureException;
	
	List<ProductVo> findProductDetails(String productId) throws InvalidProductException;
	
	List<String> deleteProductDetails(String productId) throws InvalidProductException;
}
