package com.claycorp.nexstore.api.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class OrderItemVo {
	
	private String orderItemId;
	private String productId;
	private RefOrderItemStatusCodesVo orderItemStatusCode;
	private Long orderItemQuantity;
	private PriceVo orderItemPrice;
	private Long rmaNumber;
	private String rmaIssuedBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonDeserialize(using=LocalDateTimeDeserializer.class)
	@JsonSerialize(using=LocalDateTimeSerializer.class)
	private LocalDateTime rmaIssuedDate;
	private String otherOrderItemDetails;
	
	public OrderItemVo() {
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public OrderItemVo setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
		return this;
	}

	public String getProductId() {
		return productId;
	}

	public OrderItemVo setProductId(String productId) {
		this.productId = productId;
		return this;
	}

	public RefOrderItemStatusCodesVo getOrderItemStatusCode() {
		return orderItemStatusCode;
	}

	public OrderItemVo setOrderItemStatusCode(RefOrderItemStatusCodesVo orderItemStatusCode) {
		this.orderItemStatusCode = orderItemStatusCode;
		return this;
	}

	public Long getOrderItemQuantity() {
		return orderItemQuantity;
	}

	public OrderItemVo setOrderItemQuantity(Long orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
		return this;
	}

	public PriceVo getOrderItemPrice() {
		return orderItemPrice;
	}

	public OrderItemVo setOrderItemPrice(PriceVo orderItemPrice) {
		this.orderItemPrice = orderItemPrice;
		return this;
	}

	public Long getRmaNumber() {
		return rmaNumber;
	}

	public OrderItemVo setRmaNumber(Long rmaNumber) {
		this.rmaNumber = rmaNumber;
		return this;
	}

	public String getRmaIssuedBy() {
		return rmaIssuedBy;
	}

	public OrderItemVo setRmaIssuedBy(String rmaIssuedBy) {
		this.rmaIssuedBy = rmaIssuedBy;
		return this;
	}

	public LocalDateTime getRmaIssuedDate() {
		return rmaIssuedDate;
	}

	public OrderItemVo setRmaIssuedDate(LocalDateTime rmaIssuedDate) {
		this.rmaIssuedDate = rmaIssuedDate;
		return this;
	}

	public String getOtherOrderItemDetails() {
		return otherOrderItemDetails;
	}

	public OrderItemVo setOtherOrderItemDetails(String otherOrderItemDetails) {
		this.otherOrderItemDetails = otherOrderItemDetails;
		return this;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", productId=" + productId + ", orderItemStatusCode="
				+ orderItemStatusCode + ", orderItemQuantity=" + orderItemQuantity + ", orderItemPrice="
				+ orderItemPrice + ", rmaNumber=" + rmaNumber + ", rmaIssuedBy=" + rmaIssuedBy + ", rmaIssuedDate="
				+ rmaIssuedDate + ", otherOrderItemDetails=" + otherOrderItemDetails + "]";
	}
}
