package com.claycorp.nexstore.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	@Id
	private String id;
	private ProductType productType;
	private String returnMerchandiseAuthorizationNr;
	private String productName;
	private Price productPrice;
	private String productColor;
	private String productSize;
	private String productDescription;
	private String otherProductDetails;

	public Product() {
	}
	
	public String getId() {
		return id;
	}

	public Product setId(String id) {
		this.id = id;
		return this;
	}

	public ProductType getProductType() {
		return productType;
	}

	public Product setProductType(ProductType productType) {
		this.productType = productType;
		return this;
	}

	public String getReturnMerchandiseAuthorizationNr() {
		return returnMerchandiseAuthorizationNr;
	}

	public Product setReturnMerchandiseAuthorizationNr(String returnMerchandiseAuthorizationNr) {
		this.returnMerchandiseAuthorizationNr = returnMerchandiseAuthorizationNr;
		return this;
	}

	public String getProductName() {
		return productName;
	}

	public Product setProductName(String productName) {
		this.productName = productName;
		return this;
	}

	public Price getProductPrice() {
		return productPrice;
	}

	public Product setProductPrice(Price productPrice) {
		this.productPrice = productPrice;
		return this;
	}

	public String getProductColor() {
		return productColor;
	}

	public Product setProductColor(String productColor) {
		this.productColor = productColor;
		return this;
	}

	public String getProductSize() {
		return productSize;
	}

	public Product setProductSize(String productSize) {
		this.productSize = productSize;
		return this;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public Product setProductDescription(String productDescription) {
		this.productDescription = productDescription;
		return this;
	}

	public String getOtherProductDetails() {
		return otherProductDetails;
	}

	public Product setOtherProductDetails(String otherProductDetails) {
		this.otherProductDetails = otherProductDetails;
		return this;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productType=" + productType + ", returnMerchandiseAuthorizationNr="
				+ returnMerchandiseAuthorizationNr + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productColor=" + productColor + ", productSize=" + productSize + ", productDescription="
				+ productDescription + ", otherProductDetails=" + otherProductDetails + "]";
	}

}
