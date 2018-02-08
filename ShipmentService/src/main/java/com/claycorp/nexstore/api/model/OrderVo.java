package com.claycorp.nexstore.api.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Document
public class OrderVo {

	private String id;
	private RefOrderStatusCodesVo statusCode;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime dateOfOrderPlaced;
	private List<OrderItemVo> orderDetails;

	public OrderVo() {
	}

	public String getId() {
		return id;
	}

	public OrderVo setId(String id) {
		this.id = id;
		return this;
	}

	public RefOrderStatusCodesVo getStatusCode() {
		return statusCode;
	}

	public OrderVo setStatusCode(RefOrderStatusCodesVo statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	public LocalDateTime getDateOfOrderPlaced() {
		return dateOfOrderPlaced;
	}

	public OrderVo setDateOfOrderPlaced(LocalDateTime dateOfOrderPlaced) {
		this.dateOfOrderPlaced = dateOfOrderPlaced;
		return this;
	}

	public List<OrderItemVo> getOrderDetails() {
		return orderDetails;
	}

	public OrderVo setOrderDetails(List<OrderItemVo> orderDetails) {
		this.orderDetails = orderDetails;
		return this;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", statusCode=" + statusCode + ", dateOfOrderPlaced=" + dateOfOrderPlaced
				+ ", orderDetails=" + orderDetails + "]";
	}

}
