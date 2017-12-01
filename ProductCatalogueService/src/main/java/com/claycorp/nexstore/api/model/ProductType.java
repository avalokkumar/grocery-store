package com.claycorp.nexstore.api.model;

public class ProductType {

	private String productTypeCode;
	
	private String parentProductTypeCode;
	
	private String productTypeDescription;

	public String getProductTypeCode() {
		return productTypeCode;
	}

	public ProductType setProductTypeCode(String productTypeCode) {
		this.productTypeCode = productTypeCode;
		return this;
	}

	public String getParentProductTypeCode() {
		return parentProductTypeCode;
	}

	public ProductType setParentProductTypeCode(String parentProductTypeCode) {
		this.parentProductTypeCode = parentProductTypeCode;
		return this;
	}

	public String getProductTypeDescription() {
		return productTypeDescription;
	}

	public ProductType setProductTypeDescription(String productTypeDescription) {
		this.productTypeDescription = productTypeDescription;
		return this;
	}

	@Override
	public String toString() {
		return "ProductType [productTypeCode=" + productTypeCode + ", parentProductTypeCode=" + parentProductTypeCode
				+ ", productTypeDescription=" + productTypeDescription + "]";
	}
}
