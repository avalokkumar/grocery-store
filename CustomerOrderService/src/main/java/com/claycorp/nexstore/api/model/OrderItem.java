package com.claycorp.nexstore.api.model;

import java.time.LocalDateTime;

import javax.persistence.Convert;

import org.springframework.data.mongodb.core.mapping.Document;

import com.claycorp.nexstore.api.util.LocalDateTimeConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Document
public class OrderItem {
	
	private String orderItemId;
	private String productId;
	private RefOrderItemStatusCodes orderItemStatusCode;
	private Long orderItemQuantity;
	private Price orderItemPrice;
	private Long rmaNumber;
	private String rmaIssuedBy;
	@JsonDeserialize(using=LocalDateDeserializer.class)
	@JsonSerialize(using=LocalDateTimeSerializer.class)
	private LocalDateTime rmaIssuedDate;
	private String otherOrderItemDetails;
	
	public OrderItem() {
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public OrderItem setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
		return this;
	}

	public String getProductId() {
		return productId;
	}

	public OrderItem setProductId(String productId) {
		this.productId = productId;
		return this;
	}

	public RefOrderItemStatusCodes getOrderItemStatusCode() {
		return orderItemStatusCode;
	}

	public OrderItem setOrderItemStatusCode(RefOrderItemStatusCodes orderItemStatusCode) {
		this.orderItemStatusCode = orderItemStatusCode;
		return this;
	}

	public Long getOrderItemQuantity() {
		return orderItemQuantity;
	}

	public OrderItem setOrderItemQuantity(Long orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
		return this;
	}

	public Price getOrderItemPrice() {
		return orderItemPrice;
	}

	public OrderItem setOrderItemPrice(Price orderItemPrice) {
		this.orderItemPrice = orderItemPrice;
		return this;
	}

	public Long getRmaNumber() {
		return rmaNumber;
	}

	public OrderItem setRmaNumber(Long rmaNumber) {
		this.rmaNumber = rmaNumber;
		return this;
	}

	public String getRmaIssuedBy() {
		return rmaIssuedBy;
	}

	public OrderItem setRmaIssuedBy(String rmaIssuedBy) {
		this.rmaIssuedBy = rmaIssuedBy;
		return this;
	}

	public LocalDateTime getRmaIssuedDate() {
		return rmaIssuedDate;
	}

	public OrderItem setRmaIssuedDate(LocalDateTime rmaIssuedDate) {
		this.rmaIssuedDate = rmaIssuedDate;
		return this;
	}

	public String getOtherOrderItemDetails() {
		return otherOrderItemDetails;
	}

	public OrderItem setOtherOrderItemDetails(String otherOrderItemDetails) {
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
