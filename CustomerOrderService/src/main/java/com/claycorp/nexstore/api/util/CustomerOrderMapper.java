package com.claycorp.nexstore.api.util;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.claycorp.nexstore.api.model.Order;
import com.claycorp.nexstore.api.model.OrderItem;
import com.claycorp.nexstore.api.model.Price;
import com.claycorp.nexstore.api.model.RefOrderItemStatusCodes;
import com.claycorp.nexstore.api.model.RefOrderStatusCodes;
import com.claycorp.nexstore.api.vo.OrderItemVo;
import com.claycorp.nexstore.api.vo.OrderVo;
import com.claycorp.nexstore.api.vo.PriceVo;
import com.claycorp.nexstore.api.vo.RefOrderItemStatusCodesVo;
import com.claycorp.nexstore.api.vo.RefOrderStatusCodesVo;

@Service
public class CustomerOrderMapper {

	public OrderVo mapOrderToOrderVo(Order order) {

		OrderVo orderVo = new OrderVo();
		RefOrderStatusCodesVo statusCodeVo = new RefOrderStatusCodesVo();
		statusCodeVo.setOrderStatusCodeVo(order.getStatusCode().getOrderStatusCode())
				.setOrderStatusDescriptionVo(order.getStatusCode().getOrderStatusDescription());
		orderVo.setOrderDetailsVo(mapOrderItemToOrderItemVo(order.getOrderDetails())).setOrderId(order.getId())
				.setOrderStatusCodeVo(statusCodeVo).setDateOfOrderPlaced(order.getDateOfOrderPlaced());
		return orderVo;
	}

	public List<OrderItemVo> mapOrderItemToOrderItemVo(List<OrderItem> orderItems) {
		return orderItems.stream().filter(Objects::nonNull).map(this::mapOrderItemToOrderItemVo)
				.collect(Collectors.toList());
	}

	private OrderItemVo mapOrderItemToOrderItemVo(OrderItem orderItem) {
		OrderItemVo orderItemVo = new OrderItemVo();
		RefOrderItemStatusCodesVo itemStatusCodeVo = new RefOrderItemStatusCodesVo();
		itemStatusCodeVo.setOrderItemStatusCodeVo(orderItem.getOrderItemStatusCode().getOrderItemStatusCode())
				.setOrderItemStatusDescriptionVo(orderItem.getOrderItemStatusCode().getOrderItemStatusDescription());
		PriceVo priceVo = new PriceVo();
		priceVo.setAmountVo(orderItem.getOrderItemPrice().getAmount())
				.setCurrencyVo(orderItem.getOrderItemPrice().getCurrency());
		orderItemVo.setOrderItemId(orderItem.getOrderItemId()).setProductId(orderItem.getProductId())
				.setItemStatusCodeVo(itemStatusCodeVo).setItemQuantity(orderItem.getOrderItemQuantity())
				.setItemPriceVo(priceVo).setRmaNumber(orderItem.getRmaNumber())
				.setRmaIssuedBy(orderItem.getRmaIssuedBy()).setRmaIssuedDate(orderItem.getRmaIssuedDate())
				.setOtherOrderItemDetails(orderItem.getOtherOrderItemDetails());

		return orderItemVo;
	}

	public List<OrderVo> mapOrderToOrderVo(List<Order> order) {
		return order.stream().filter(Objects::nonNull).map(this::mapOrderToOrderVo).collect(Collectors.toList());
	}

	public Order mapOrderVoToOrder(OrderVo orderVo) {
		Order order = new Order();
		RefOrderStatusCodes statusCode = new RefOrderStatusCodes();
		statusCode.setOrderStatusCode(orderVo.getOrderStatusCodeVo().getOrderStatusCodeVo())
				.setOrderStatusDescription(orderVo.getOrderStatusCodeVo().getOrderStatusDescriptionVo());
		order.setId(orderVo.getOrderId()).setOrderDetails(mapOrderItemVoToOrderItem(orderVo.getOrderDetailsVo()))
				.setStatusCode(statusCode).setDateOfOrderPlaced(orderVo.getDateOfOrderPlaced());
		return order;
	}

	public List<OrderItem> mapOrderItemVoToOrderItem(List<OrderItemVo> orderItemsVo) {
		return orderItemsVo.stream().filter(Objects::nonNull).map(this::mapOrderItemVoToOrderItem)
				.collect(Collectors.toList());
	}

	private OrderItem mapOrderItemVoToOrderItem(OrderItemVo orderItemVo) {
		OrderItem orderItem = new OrderItem();
		RefOrderItemStatusCodes orderStatusCode = new RefOrderItemStatusCodes();
		Price itemPrice = new Price();
		itemPrice.setAmount(orderItemVo.getItemPriceVo().getAmountVo())
				.setCurrency(orderItemVo.getItemPriceVo().getCurrencyVo());
		orderStatusCode.setOrderItemStatusCode(orderItemVo.getItemStatusCodeVo().getOrderItemStatusCodeVo())
				.setOrderItemStatusDescription(orderItemVo.getItemStatusCodeVo().getOrderItemStatusDescriptionVo());
		orderItem.setOrderItemId(orderItemVo.getOrderItemId()).setProductId(orderItemVo.getProductId())
				.setOrderItemStatusCode(orderStatusCode).setOrderItemPrice(itemPrice)
				.setOrderItemQuantity(orderItemVo.getItemQuantity()).setRmaNumber(orderItemVo.getRmaNumber())
				.setRmaIssuedBy(orderItemVo.getRmaIssuedBy()).setRmaIssuedDate(orderItemVo.getRmaIssuedDate())
				.setOtherOrderItemDetails(orderItemVo.getOtherOrderItemDetails());

		return orderItem;
	}

	public List<Order> mapOrderVoToOrder(List<OrderVo> ordersVo) {
		return ordersVo.stream().filter(Objects::nonNull).map(this::mapOrderVoToOrder).collect(Collectors.toList());
	}
}
