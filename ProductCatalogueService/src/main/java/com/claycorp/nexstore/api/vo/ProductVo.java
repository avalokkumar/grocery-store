package com.claycorp.nexstore.api.vo;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonClassDescription("Product")
public class ProductVo {

	@JsonProperty("productId")
	private String id;
	
	@JsonProperty("productType")
	private ProductTypeVo productTypeVo;
	
	@JsonProperty("returnMerchandiseAuthorizationNr")
	private String returnMerchandiseAuthorizationNr;
	
	@JsonProperty("productName")
	private String name;
	
	@JsonProperty("price")
	private PriceVo priceVo;
	
	@JsonProperty("color")
	private String color;
	
	@JsonProperty("size")
	private String size;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("otherProductDetails")
	private String otherProductDetails;

	
	public String getId() {
		return id;
	}

	public ProductVo setId(String id) {
		this.id = id;
		return this;
	}

	public ProductTypeVo getProductTypeVo() {
		return productTypeVo;
	}

	public ProductVo setProductTypeVo(ProductTypeVo productTypeVo) {
		this.productTypeVo = productTypeVo;
		return this;
	}

	public String getReturnMerchandiseAuthorizationNr() {
		return returnMerchandiseAuthorizationNr;
	}

	public ProductVo setReturnMerchandiseAuthorizationNr(String returnMerchandiseAuthorizationNr) {
		this.returnMerchandiseAuthorizationNr = returnMerchandiseAuthorizationNr;
		return this;
	}

	public String getName() {
		return name;
	}

	public ProductVo setName(String name) {
		this.name = name;
		return this;
	}

	
	public String getColor() {
		return color;
	}

	public ProductVo setColor(String color) {
		this.color = color;
		return this;
	}

	public String getSize() {
		return size;
	}

	public ProductVo setSize(String size) {
		this.size = size;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public ProductVo setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getOtherProductDetails() {
		return otherProductDetails;
	}

	public ProductVo setOtherProductDetails(String otherProductDetails) {
		this.otherProductDetails = otherProductDetails;
		return this;
	}

	public PriceVo getPriceVo() {
		return priceVo;
	}

	public ProductVo setPriceVo(PriceVo priceVo) {
		this.priceVo = priceVo;
		return this;
	}

	@Override
	public String toString() {
		return "ProductVo [id=" + id + ", productTypeVo=" + productTypeVo + ", returnMerchandiseAuthorizationNr="
				+ returnMerchandiseAuthorizationNr + ", name=" + name + ", priceVo=" + priceVo + ", color=" + color
				+ ", size=" + size + ", description=" + description + ", otherProductDetails=" + otherProductDetails
				+ "]";
	}
}
