package com.claycorp.nexstore.api.model;

public class RefOrderItemStatusCodes {

	private String orderItemStatusCode;
	private String orderItemStatusDescription; //Create and ENUM
	
	public RefOrderItemStatusCodes() {
	}

	public String getOrderItemStatusCode() {
		return orderItemStatusCode;
	}

	public RefOrderItemStatusCodes setOrderItemStatusCode(String orderItemStatusCode) {
		this.orderItemStatusCode = orderItemStatusCode;
		return this;
	}

	public String getOrderItemStatusDescription() {
		return orderItemStatusDescription;
	}

	public RefOrderItemStatusCodes setOrderItemStatusDescription(String orderItemStatusDescription) {
		this.orderItemStatusDescription = orderItemStatusDescription;
		return this;
	}

	@Override
	public String toString() {
		return "RefOrderItemStatusCodes [orderItemStatusCode=" + orderItemStatusCode + ", orderItemStatusDescription="
				+ orderItemStatusDescription + "]";
	}
}
