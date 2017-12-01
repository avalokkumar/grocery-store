package com.claycorp.nexstore.api.util;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.claycorp.nexstore.api.model.Price;
import com.claycorp.nexstore.api.model.Product;
import com.claycorp.nexstore.api.model.ProductType;
import com.claycorp.nexstore.api.vo.PriceVo;
import com.claycorp.nexstore.api.vo.ProductTypeVo;
import com.claycorp.nexstore.api.vo.ProductVo;

@Service
public class ProductCatalogueMapper {

	public ProductVo mapProductToProductVo(Product product) {

		ProductVo productVo = new ProductVo();
		ProductTypeVo productTypeVo = new ProductTypeVo();
		ProductType productType = product.getProductType();
		productTypeVo.setTypeCode(productType.getProductTypeCode()).setParentTypeCode(productType.getProductTypeCode())
				.setTypeDescription(productType.getProductTypeDescription());

		productVo.setId(product.getId()).setProductTypeVo(productTypeVo)
				.setReturnMerchandiseAuthorizationNr(product.getReturnMerchandiseAuthorizationNr())
				.setName(product.getProductName()).setPriceVo(new PriceVo(product.getProductPrice()))
				.setColor(product.getProductColor()).setSize(product.getProductSize())
				.setDescription(product.getProductDescription())
				.setOtherProductDetails(product.getOtherProductDetails());
		return productVo;
	}

	public List<ProductVo> mapProductToProductVo(List<Product> products) {
		return products.stream().filter(Objects::nonNull).map(this::mapProductToProductVo).collect(Collectors.toList());
	}

	public Product mapProductVoToProduct(ProductVo productVo) {

		Product product = new Product();
		ProductTypeVo productTypeVo = productVo.getProductTypeVo();
		ProductType productType = new ProductType();
		productType.setProductTypeCode(productTypeVo.getTypeCode())
				.setParentProductTypeCode(productTypeVo.getParentTypeCode())
				.setProductTypeDescription(productTypeVo.getTypeDescription());

		product.setId(productVo.getId()).setProductType(productType).setProductName(productVo.getName())
				.setReturnMerchandiseAuthorizationNr(productVo.getReturnMerchandiseAuthorizationNr())
				.setProductPrice(new Price(productVo.getPriceVo())).setProductColor(productVo.getColor())
				.setProductSize(productVo.getSize()).setProductDescription(productVo.getDescription())
				.setOtherProductDetails(productVo.getOtherProductDetails());
		return product;
	}

	public List<Product> mapProductVoToProduct(List<ProductVo> products) {
		return products.stream().filter(Objects::nonNull).map(this::mapProductVoToProduct).collect(Collectors.toList());
	}
}
