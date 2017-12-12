package com.claycorp.nexstore.api.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShipmentItemsVo {

	@JsonProperty("shippedOrderItem")
	private String shipmentId;
	private OrderItemVo orderItemVo;

	public ShipmentItemsVo() {
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public ShipmentItemsVo setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
		return this;
	}

	public OrderItemVo getOrderItemVo() {
		return orderItemVo;
	}

	public ShipmentItemsVo setOrderItemVo(OrderItemVo orderItemVo) {
		this.orderItemVo = orderItemVo;
		return this;
	}

	@Override
	public String toString() {
		return "ShipmentItemsVo [shipmentId=" + shipmentId + ", orderItemVo=" + orderItemVo + "]";
	}
}
