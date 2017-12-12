package com.claycorp.nexstore.api.model;

public class RefOrderStatusCodes {
	
	private String orderStatusCode;
	private String orderStatusDescription;
	
	public RefOrderStatusCodes() {
	}

	public String getOrderStatusCode() {
		return orderStatusCode;
	}

	public RefOrderStatusCodes setOrderStatusCode(String orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
		return this;
	}

	public String getOrderStatusDescription() {
		return orderStatusDescription;
	}

	public RefOrderStatusCodes setOrderStatusDescription(String orderStatusDescription) {
		this.orderStatusDescription = orderStatusDescription;
		return this;
	}

	@Override
	public String toString() {
		return "RefOrderStatusCodes [orderStatusCode=" + orderStatusCode + ", orderStatusDescription="
				+ orderStatusDescription + "]";
	}
}
