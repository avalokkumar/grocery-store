package com.claycorp.nexstore.api.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonClassDescription("RefOrderStatusCodes")
public class RefOrderStatusCodesVo {
	
	@JsonProperty("orderStatusCode")
	private String orderStatusCodeVo;
	@JsonProperty("orderStatusDescription")
	private String orderStatusDescriptionVo;
	
	public RefOrderStatusCodesVo() {
	}

	public String getOrderStatusCodeVo() {
		return orderStatusCodeVo;
	}

	public RefOrderStatusCodesVo setOrderStatusCodeVo(String orderStatusCodeVo) {
		this.orderStatusCodeVo = orderStatusCodeVo;
		return this;
	}

	public String getOrderStatusDescriptionVo() {
		return orderStatusDescriptionVo;
	}

	public RefOrderStatusCodesVo setOrderStatusDescriptionVo(String orderStatusDescriptionVo) {
		this.orderStatusDescriptionVo = orderStatusDescriptionVo;
		return this;
	}

	@Override
	public String toString() {
		return "RefOrderStatusCodesVo [orderStatusCodeVo=" + orderStatusCodeVo + ", orderStatusDescriptionVo="
				+ orderStatusDescriptionVo + "]";
	}
}
