package com.claycorp.nexstore.api.vo;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonClassDescription("RefOrderItemStatusCodes")
public class RefOrderItemStatusCodesVo {

	@JsonProperty("orderItemStatusCode")
	private String orderItemStatusCodeVo;
	@JsonProperty("orderItemStatusDescription")
	private String orderItemStatusDescriptionVo; //Create and ENUM
	
	public RefOrderItemStatusCodesVo() {
	}

	public String getOrderItemStatusCodeVo() {
		return orderItemStatusCodeVo;
	}

	public RefOrderItemStatusCodesVo setOrderItemStatusCodeVo(String orderItemStatusCodeVo) {
		this.orderItemStatusCodeVo = orderItemStatusCodeVo;
		return this;
	}

	public String getOrderItemStatusDescriptionVo() {
		return orderItemStatusDescriptionVo;
	}

	public RefOrderItemStatusCodesVo setOrderItemStatusDescriptionVo(String orderItemStatusDescriptionVo) {
		this.orderItemStatusDescriptionVo = orderItemStatusDescriptionVo;
		return this;
	}

	@Override
	public String toString() {
		return "RefOrderItemStatusCodesVo [orderItemStatusCodeVo=" + orderItemStatusCodeVo
				+ ", orderItemStatusDescriptionVo=" + orderItemStatusDescriptionVo + "]";
	}
}
