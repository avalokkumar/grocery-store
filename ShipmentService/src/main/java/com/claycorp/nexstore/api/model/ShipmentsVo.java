package com.claycorp.nexstore.api.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class ShipmentsVo {

	private String shipmentId;
	private OrderVo order;
	private Long invoiceNumber;
	private Long shipmentTrackingNumber;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonDeserialize(using=LocalDateTimeDeserializer.class)
	@JsonSerialize(using=LocalDateTimeSerializer.class)
	private LocalDateTime shipmentDate;
	private String otherShipmentDetails;
	private List<ShipmentItemsVo> shipmentItems;

	public ShipmentsVo() {
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public ShipmentsVo setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
		return this;
	}

	public OrderVo getOrder() {
		return order;
	}

	public ShipmentsVo setOrder(OrderVo order) {
		this.order = order;
		return this;
	}

	public Long getInvoiceNumber() {
		return invoiceNumber;
	}

	public ShipmentsVo setInvoiceNumber(Long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
		return this;
	}

	public Long getShipmentTrackingNumber() {
		return shipmentTrackingNumber;
	}

	public ShipmentsVo setShipmentTrackingNumber(Long shipmentTrackingNumber) {
		this.shipmentTrackingNumber = shipmentTrackingNumber;
		return this;
	}

	public LocalDateTime getShipmentDate() {
		return shipmentDate;
	}

	public ShipmentsVo setShipmentDate(LocalDateTime shipmentDate) {
		this.shipmentDate = shipmentDate;
		return this;
	}

	public String getOtherShipmentDetails() {
		return otherShipmentDetails;
	}

	public ShipmentsVo setOtherShipmentDetails(String otherShipmentDetails) {
		this.otherShipmentDetails = otherShipmentDetails;
		return this;
	}

	public List<ShipmentItemsVo> getShipmentItems() {
		return shipmentItems;
	}

	public ShipmentsVo setShipmentItems(List<ShipmentItemsVo> shipmentItems) {
		this.shipmentItems = shipmentItems;
		return this;
	}

	@Override
	public String toString() {
		return "Shipments [shipmentId=" + shipmentId + ", order=" + order + ", invoiceNumber=" + invoiceNumber
				+ ", shipmentTrackingNumber=" + shipmentTrackingNumber + ", shipmentDate=" + shipmentDate
				+ ", otherShipmentDetails=" + otherShipmentDetails + ", shipmentItems=" + shipmentItems + "]";
	}

}
