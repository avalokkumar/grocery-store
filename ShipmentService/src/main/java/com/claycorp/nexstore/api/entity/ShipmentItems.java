package com.claycorp.nexstore.api.entity;

public class ShipmentItems {

	private String shipmentId;
	private OrderItem orderItem;

	public ShipmentItems() {
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public ShipmentItems setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
		return this;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public ShipmentItems setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
		return this;
	}

	@Override
	public String toString() {
		return "ShipmentItems [shipmentId=" + shipmentId + ", orderItem=" + orderItem + "]";
	}
}
