package com.claycorp.nexstore.api.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@JsonClassDescription("OrderItem")
public class OrderItemVo {

	@JsonProperty("orderItemId")
	private String orderItemId;
	@JsonProperty("productId")
	private String productId;
	@JsonProperty("itemStatusCode")
	private RefOrderItemStatusCodesVo itemStatusCodeVo;
	@JsonProperty("itemQuantity")
	private Long itemQuantity;
	@JsonProperty("itemPrice")
	private PriceVo itemPriceVo;
	@JsonProperty("rmaNumber")
	private Long rmaNumber;
	@JsonProperty("rmaIssuedBy")
	private String rmaIssuedBy;
	@JsonProperty("rmaIssuedDate")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonDeserialize(using=LocalDateTimeDeserializer.class)
	@JsonSerialize(using=LocalDateTimeSerializer.class)
	private LocalDateTime rmaIssuedDate;
	@JsonProperty("otherOrderItemDetails")
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

	public RefOrderItemStatusCodesVo getItemStatusCodeVo() {
		return itemStatusCodeVo;
	}

	public OrderItemVo setItemStatusCodeVo(RefOrderItemStatusCodesVo itemStatusCodeVo) {
		this.itemStatusCodeVo = itemStatusCodeVo;
		return this;
	}

	public Long getItemQuantity() {
		return itemQuantity;
	}

	public OrderItemVo setItemQuantity(Long itemQuantity) {
		this.itemQuantity = itemQuantity;
		return this;
	}

	public PriceVo getItemPriceVo() {
		return itemPriceVo;
	}

	public OrderItemVo setItemPriceVo(PriceVo itemPriceVo) {
		this.itemPriceVo = itemPriceVo;
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
		return "OrderItemVo [orderItemId=" + orderItemId + ", productId=" + productId + ", itemStatusCodeVo="
				+ itemStatusCodeVo + ", itemQuantity=" + itemQuantity + ", itemPriceVo=" + itemPriceVo + ", rmaNumber="
				+ rmaNumber + ", rmaIssuedBy=" + rmaIssuedBy + ", rmaIssuedDate=" + rmaIssuedDate
				+ ", otherOrderItemDetails=" + otherOrderItemDetails + "]";
	}
}
