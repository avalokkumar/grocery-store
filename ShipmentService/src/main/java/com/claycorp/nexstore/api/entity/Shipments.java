package com.claycorp.nexstore.api.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Shipments {

	@Id
	private String id;
	private Order order;
	private Long invoiceNumber;
	private Long shipmentTrackingNumber;
	private LocalDateTime shipmentDate;
	private String otherShipmentDetails;
	private List<ShipmentItems> shipmentItems;

	public Shipments() {
	}

	public String getId() {
		return id;
	}

	public Shipments setId(String id) {
		this.id = id;
		return this;
	}

	public Order getOrder() {
		return order;
	}

	public Shipments setOrder(Order order) {
		this.order = order;
		return this;
	}

	public Long getInvoiceNumber() {
		return invoiceNumber;
	}

	public Shipments setInvoiceNumber(Long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
		return this;
	}

	public Long getShipmentTrackingNumber() {
		return shipmentTrackingNumber;
	}

	public Shipments setShipmentTrackingNumber(Long shipmentTrackingNumber) {
		this.shipmentTrackingNumber = shipmentTrackingNumber;
		return this;
	}

	public LocalDateTime getShipmentDate() {
		return shipmentDate;
	}

	public Shipments setShipmentDate(LocalDateTime shipmentDate) {
		this.shipmentDate = shipmentDate;
		return this;
	}

	public String getOtherShipmentDetails() {
		return otherShipmentDetails;
	}

	public Shipments setOtherShipmentDetails(String otherShipmentDetails) {
		this.otherShipmentDetails = otherShipmentDetails;
		return this;
	}

	public List<ShipmentItems> getShipmentItems() {
		return shipmentItems;
	}

	public Shipments setShipmentItems(List<ShipmentItems> shipmentItems) {
		this.shipmentItems = shipmentItems;
		return this;
	}

	@Override
	public String toString() {
		return "Shipments [id=" + id + ", order=" + order + ", invoiceNumber=" + invoiceNumber
				+ ", shipmentTrackingNumber=" + shipmentTrackingNumber + ", shipmentDate=" + shipmentDate
				+ ", otherShipmentDetails=" + otherShipmentDetails + ", shipmentItems=" + shipmentItems + "]";
	}

}
