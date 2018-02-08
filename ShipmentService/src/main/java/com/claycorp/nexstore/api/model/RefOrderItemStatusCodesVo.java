package com.claycorp.nexstore.api.model;

public class RefOrderItemStatusCodesVo {

	private String orderItemStatusCode;
	private String orderItemStatusDescription; // Create and ENUM

	public RefOrderItemStatusCodesVo() {
	}

	public RefOrderItemStatusCodesVo(String orderItemStatusCode, String orderItemStatusDescription) {
		super();
		this.orderItemStatusCode = orderItemStatusCode;
		this.orderItemStatusDescription = orderItemStatusDescription;
	}

	public String getOrderItemStatusCode() {
		return orderItemStatusCode;
	}

	public RefOrderItemStatusCodesVo setOrderItemStatusCode(String orderItemStatusCode) {
		this.orderItemStatusCode = orderItemStatusCode;
		return this;
	}

	public String getOrderItemStatusDescription() {
		return orderItemStatusDescription;
	}

	public RefOrderItemStatusCodesVo setOrderItemStatusDescription(String orderItemStatusDescription) {
		this.orderItemStatusDescription = orderItemStatusDescription;
		return this;
	}

	@Override
	public String toString() {
		return "RefOrderItemStatusCodes [orderItemStatusCode=" + orderItemStatusCode + ", orderItemStatusDescription="
				+ orderItemStatusDescription + "]";
	}
}
