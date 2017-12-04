package com.claycorp.nexstore.api.service.impl;

import static org.zalando.problem.Status.BAD_REQUEST;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zalando.problem.Problem;
import org.zalando.problem.ThrowableProblem;

import com.claycorp.nexstore.api.exception.InvalidProductException;
import com.claycorp.nexstore.api.exception.UpdateFailureException;
import com.claycorp.nexstore.api.repository.ProductRepository;
import com.claycorp.nexstore.api.service.ProductCatalogueService;
import com.claycorp.nexstore.api.util.ProductCatalogueMapper;
import com.claycorp.nexstore.api.vo.ProductVo;

@Service
public class ProductCatalogueServiceImpl implements ProductCatalogueService {

	private static final String SUCCESS = "Success";

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private ProductCatalogueMapper mapper;

	@Override
	public List<ProductVo> getAllProductDetails() {
		return mapper.mapProductToProductVo(productRepo.findAll());
	}

	@Override
	public List<ProductVo> addProductDetails(ProductVo productRequest) {
		return Arrays
				.asList(mapper.mapProductToProductVo(productRepo.save(mapper.mapProductVoToProduct(productRequest))));
	}

	@Override
	public List<ProductVo> updateProductDetails(ProductVo productRequest) throws UpdateFailureException {
		if (null == productRequest.getId() || productRequest.getId().isEmpty()) {
			throw new UpdateFailureException(Arrays.asList(getUpdateFailureProblem()));
		}
		return Arrays
				.asList(mapper.mapProductToProductVo(productRepo.save(mapper.mapProductVoToProduct(productRequest))));
	}

	@Override
	public List<ProductVo> findProductDetails(String productId) {
		return Arrays.asList(mapper.mapProductToProductVo(productRepo.findOne(productId)));
	}

	@Override
	public List<String> deleteProductDetails(String productId) throws InvalidProductException {
		if (null == productRepo.findOne(productId)) {
			throw new InvalidProductException(Arrays.asList(getInvalidProductException()));
		}
		productRepo.delete(productId);
		return Arrays.asList(SUCCESS);
	}

	private ThrowableProblem getInvalidProductException() {
		return Problem.builder().withType(URI.create("/api/dev/claycorp/api/v1/products")).withStatus(BAD_REQUEST)
				.with("code", "ER32").with("message", "Invalid Product Id provided").build();
	}

	private ThrowableProblem getUpdateFailureProblem() {
		return Problem.builder().withType(URI.create("/api/dev/claycorp/api/v1/products")).withStatus(BAD_REQUEST)
				.with("code", "ER31").with("message", "Product Id is not provided in request").build();
	}
}