package com.claycorp.nexstore.api.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Document
public class Order {

	private String id;
	private RefOrderStatusCodes statusCode;
	
	@JsonDeserialize(using=LocalDateDeserializer.class)
	@JsonSerialize(using=LocalDateTimeSerializer.class)
	private LocalDateTime dateOfOrderPlaced;
	private List<OrderItem> orderDetails;

	public Order() {
	}

	public String getId() {
		return id;
	}

	public Order setId(String id) {
		this.id = id;
		return this;
	}

	public RefOrderStatusCodes getStatusCode() {
		return statusCode;
	}

	public Order setStatusCode(RefOrderStatusCodes statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	public LocalDateTime getDateOfOrderPlaced() {
		return dateOfOrderPlaced;
	}

	public Order setDateOfOrderPlaced(LocalDateTime dateOfOrderPlaced) {
		this.dateOfOrderPlaced = dateOfOrderPlaced;
		return this;
	}

	public List<OrderItem> getOrderDetails() {
		return orderDetails;
	}

	public Order setOrderDetails(List<OrderItem> orderDetails) {
		this.orderDetails = orderDetails;
		return this;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", statusCode=" + statusCode + ", dateOfOrderPlaced=" + dateOfOrderPlaced
				+ ", orderDetails=" + orderDetails + "]";
	}

}
