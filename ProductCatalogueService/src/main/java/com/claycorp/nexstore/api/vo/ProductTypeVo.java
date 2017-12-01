package com.claycorp.nexstore.api.vo;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonClassDescription("ProductType")
public class ProductTypeVo {

	@JsonProperty("typeCode")
	private String typeCode;
	
	@JsonProperty("parentTypeCode")
	private String parentTypeCode;
	
	@JsonProperty("typeDescription")
	private String typeDescription;

	public String getTypeCode() {
		return typeCode;
	}

	public ProductTypeVo setTypeCode(String typeCode) {
		this.typeCode = typeCode;
		return this;
	}

	public String getParentTypeCode() {
		return parentTypeCode;
	}

	public ProductTypeVo setParentTypeCode(String parentTypeCode) {
		this.parentTypeCode = parentTypeCode;
		return this;
	}

	public String getTypeDescription() {
		return typeDescription;
	}

	public ProductTypeVo setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
		return this;
	}

	@Override
	public String toString() {
		return "ProductTypeVo [typeCode=" + typeCode + ", parentTypeCode=" + parentTypeCode + ", typeDescription="
				+ typeDescription + "]";
	}	
}
