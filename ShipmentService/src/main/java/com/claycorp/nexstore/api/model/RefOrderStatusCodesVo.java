package com.claycorp.nexstore.api.model;

public class RefOrderStatusCodesVo {

	private String orderStatusCode;
	private String orderStatusDescription;

	public RefOrderStatusCodesVo() {
	}

	public RefOrderStatusCodesVo(String orderStatusCode, String orderStatusDescription) {
		super();
		this.orderStatusCode = orderStatusCode;
		this.orderStatusDescription = orderStatusDescription;
	}

	public String getOrderStatusCode() {
		return orderStatusCode;
	}

	public RefOrderStatusCodesVo setOrderStatusCode(String orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
		return this;
	}

	public String getOrderStatusDescription() {
		return orderStatusDescription;
	}

	public RefOrderStatusCodesVo setOrderStatusDescription(String orderStatusDescription) {
		this.orderStatusDescription = orderStatusDescription;
		return this;
	}

	@Override
	public String toString() {
		return "RefOrderStatusCodes [orderStatusCode=" + orderStatusCode + ", orderStatusDescription="
				+ orderStatusDescription + "]";
	}
}
