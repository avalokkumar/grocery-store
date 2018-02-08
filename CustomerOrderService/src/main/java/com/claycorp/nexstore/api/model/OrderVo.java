package com.claycorp.nexstore.api.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@JsonClassDescription("Order")
public class OrderVo {
	
	@JsonProperty("orderId")
	private String orderId;
	@JsonProperty("orderStatusCode")
	private RefOrderStatusCodesVo orderStatusCodeVo;
	@JsonProperty("dateOfOrderPlaced")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonDeserialize(using=LocalDateTimeDeserializer.class)
	@JsonSerialize(using=LocalDateTimeSerializer.class)
	private LocalDateTime dateOfOrderPlaced;
	@JsonProperty("orderDetails")
	private List<OrderItemVo> orderDetailsVo;
	
	public OrderVo() {
	}

	public String getOrderId() {
		return orderId;
	}

	public OrderVo setOrderId(String orderId) {
		this.orderId = orderId;
		return this;
	}
	
	public RefOrderStatusCodesVo getOrderStatusCodeVo() {
		return orderStatusCodeVo;
	}

	public OrderVo setOrderStatusCodeVo(RefOrderStatusCodesVo orderStatusCodeVo) {
		this.orderStatusCodeVo = orderStatusCodeVo;
		return this;
	}

	public LocalDateTime getDateOfOrderPlaced() {
		return dateOfOrderPlaced;
	}

	public OrderVo setDateOfOrderPlaced(LocalDateTime dateOfOrderPlaced) {
		this.dateOfOrderPlaced = dateOfOrderPlaced;
		return this;
	}

	public List<OrderItemVo> getOrderDetailsVo() {
		return orderDetailsVo;
	}

	public OrderVo setOrderDetailsVo(List<OrderItemVo> orderDetailsVo) {
		this.orderDetailsVo = orderDetailsVo;
		return this;
	}

	@Override
	public String toString() {
		return "OrderVo [orderId=" + orderId + ", orderStatusCodeVo=" + orderStatusCodeVo + ", dateOfOrderPlaced="
				+ dateOfOrderPlaced + ", orderDetailsVo=" + orderDetailsVo + "]";
	}

}
