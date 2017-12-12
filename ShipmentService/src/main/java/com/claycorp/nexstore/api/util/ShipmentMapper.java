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
import com.claycorp.nexstore.api.model.ShipmentItems;
import com.claycorp.nexstore.api.model.Shipments;
import com.claycorp.nexstore.api.vo.OrderItemVo;
import com.claycorp.nexstore.api.vo.OrderVo;
import com.claycorp.nexstore.api.vo.PriceVo;
import com.claycorp.nexstore.api.vo.RefOrderItemStatusCodesVo;
import com.claycorp.nexstore.api.vo.RefOrderStatusCodesVo;
import com.claycorp.nexstore.api.vo.ShipmentItemsVo;
import com.claycorp.nexstore.api.vo.ShipmentsVo;

@Service
public class ShipmentMapper {

	public ShipmentsVo mapShipmentsToShipmentsVo(Shipments shipments) {

		ShipmentsVo shipmentVo = new ShipmentsVo();
		OrderVo orderVo = new OrderVo();
		Order order = shipments.getOrder();
		RefOrderStatusCodesVo statusCodeVo = new RefOrderStatusCodesVo();
		statusCodeVo.setOrderStatusCode(order.getStatusCode().getOrderStatusCode())
				.setOrderStatusDescription(order.getStatusCode().getOrderStatusDescription());
		orderVo.setOrderDetails(mapOrderItemToOrderItemVo(order.getOrderDetails())).setId(order.getId())
				.setStatusCode(statusCodeVo).setDateOfOrderPlaced(order.getDateOfOrderPlaced());

		shipmentVo.setShipmentId(shipments.getId()).setOrder(orderVo)
				.setInvoiceNumber(shipments.getInvoiceNumber())
				.setShipmentTrackingNumber(shipments.getShipmentTrackingNumber())
				.setShipmentDate(shipments.getShipmentDate())
				.setOtherShipmentDetails(shipments.getOtherShipmentDetails())
				.setShipmentItems(mapShipmentVoItems(shipments.getShipmentItems()));

		return shipmentVo;
	}

	public List<ShipmentItemsVo> mapShipmentVoItems(List<ShipmentItems> shipmentItems) {
		return shipmentItems.stream().filter(Objects::nonNull).map(this::mapShipmentItemToShipmentItemVo)
				.collect(Collectors.toList());
	}

	private ShipmentItemsVo mapShipmentItemToShipmentItemVo(ShipmentItems shipmentItem) {
		OrderItemVo orderItemVo = new OrderItemVo();
		OrderItem orderItem = shipmentItem.getOrderItem();
		RefOrderItemStatusCodesVo orderItemStatusCodeVo = new RefOrderItemStatusCodesVo();
		orderItemStatusCodeVo.setOrderItemStatusCode(orderItem.getOrderItemStatusCode().getOrderItemStatusCode())
				.setOrderItemStatusDescription(orderItem.getOrderItemStatusCode().getOrderItemStatusDescription());
		PriceVo priceVo = new PriceVo();
		priceVo.setAmount(orderItem.getOrderItemPrice().getAmount())
				.setCurrency(orderItem.getOrderItemPrice().getCurrency());
		orderItemVo.setOrderItemId(orderItem.getOrderItemId()).setProductId(orderItem.getProductId())
				.setOrderItemPrice(priceVo).setOrderItemStatusCode(orderItemStatusCodeVo)
				.setOrderItemQuantity(orderItem.getOrderItemQuantity())
				.setOtherOrderItemDetails(orderItem.getOtherOrderItemDetails())
				.setRmaIssuedBy(orderItem.getRmaIssuedBy()).setRmaNumber(orderItem.getRmaNumber())
				.setRmaIssuedDate(orderItem.getRmaIssuedDate());
		ShipmentItemsVo shipmentItemVo = new ShipmentItemsVo();
		shipmentItemVo.setShipmentId(shipmentItem.getShipmentId()).setOrderItemVo(orderItemVo);
		return shipmentItemVo;
	}

	private List<OrderItemVo> mapOrderItemToOrderItemVo(List<OrderItem> orderItems) {
		return orderItems.stream().filter(Objects::nonNull).map(this::mapOrderItemToOrderItemVo)
				.collect(Collectors.toList());
	}

	private OrderItemVo mapOrderItemToOrderItemVo(OrderItem orderItem) {
		OrderItemVo orderItemVo = new OrderItemVo();
		RefOrderItemStatusCodesVo itemStatusCodeVo = new RefOrderItemStatusCodesVo();
		itemStatusCodeVo.setOrderItemStatusCode(orderItem.getOrderItemStatusCode().getOrderItemStatusCode())
				.setOrderItemStatusDescription(orderItem.getOrderItemStatusCode().getOrderItemStatusDescription());
		PriceVo priceVo = new PriceVo();
		priceVo.setAmount(orderItem.getOrderItemPrice().getAmount())
				.setCurrency(orderItem.getOrderItemPrice().getCurrency());
		orderItemVo.setOrderItemId(orderItem.getOrderItemId()).setProductId(orderItem.getProductId())
				.setOrderItemStatusCode(itemStatusCodeVo).setOrderItemQuantity(orderItem.getOrderItemQuantity())
				.setOrderItemPrice(priceVo).setRmaNumber(orderItem.getRmaNumber())
				.setRmaIssuedBy(orderItem.getRmaIssuedBy()).setRmaIssuedDate(orderItem.getRmaIssuedDate())
				.setOtherOrderItemDetails(orderItem.getOtherOrderItemDetails());

		return orderItemVo;
	}

	public List<ShipmentsVo> mapShipmentsToShipmentsVo(List<Shipments> shipmentList) {
		return shipmentList.stream().filter(Objects::nonNull).map(this::mapShipmentsToShipmentsVo)
				.collect(Collectors.toList());
	}

	// ----------------------------------------------------------------------------

	public Shipments mapShipmentsVoToShipments(ShipmentsVo shipmentsVo) {
		Shipments shipments = new Shipments();
		Order order = new Order();
		OrderVo orderVo = shipmentsVo.getOrder();
		RefOrderStatusCodes statusCodeVo = new RefOrderStatusCodes();
		statusCodeVo.setOrderStatusCode(orderVo.getStatusCode().getOrderStatusCode())
				.setOrderStatusDescription(orderVo.getStatusCode().getOrderStatusDescription());
		order.setOrderDetails(mapOrderItemVoToOrderItem(orderVo.getOrderDetails())).setId(orderVo.getId())
				.setStatusCode(statusCodeVo).setDateOfOrderPlaced(orderVo.getDateOfOrderPlaced());

		shipments.setId(shipmentsVo.getShipmentId()).setOrder(order)
				.setInvoiceNumber(shipmentsVo.getInvoiceNumber())
				.setShipmentTrackingNumber(shipmentsVo.getShipmentTrackingNumber())
				.setShipmentDate(shipmentsVo.getShipmentDate())
				.setOtherShipmentDetails(shipmentsVo.getOtherShipmentDetails())
				.setShipmentItems(mapShipmentItems(shipmentsVo.getShipmentItems()));

		return shipments;
	}

	public List<ShipmentItems> mapShipmentItems(List<ShipmentItemsVo> shipmentItemsVo) {
		return shipmentItemsVo.stream().filter(Objects::nonNull).map(this::mapShipmentItemToShipmentItemVo)
				.collect(Collectors.toList());
	}

	private ShipmentItems mapShipmentItemToShipmentItemVo(ShipmentItemsVo shipmentItemVo) {
		OrderItem orderItem = new OrderItem();
		OrderItemVo orderItemVo = shipmentItemVo.getOrderItemVo();
		RefOrderItemStatusCodes orderItemStatusCode = new RefOrderItemStatusCodes();
		orderItemStatusCode.setOrderItemStatusCode(orderItemVo.getOrderItemStatusCode().getOrderItemStatusCode())
				.setOrderItemStatusDescription(orderItemVo.getOrderItemStatusCode().getOrderItemStatusDescription());
		Price price = new Price();
		price.setAmount(orderItemVo.getOrderItemPrice().getAmount())
				.setCurrency(orderItemVo.getOrderItemPrice().getCurrency());
		orderItem.setOrderItemId(orderItemVo.getOrderItemId()).setProductId(orderItemVo.getProductId())
				.setOrderItemPrice(price).setOrderItemStatusCode(orderItemStatusCode)
				.setOrderItemQuantity(orderItemVo.getOrderItemQuantity())
				.setOtherOrderItemDetails(orderItemVo.getOtherOrderItemDetails())
				.setRmaIssuedBy(orderItemVo.getRmaIssuedBy()).setRmaNumber(orderItemVo.getRmaNumber())
				.setRmaIssuedDate(orderItemVo.getRmaIssuedDate());
		ShipmentItems shipmentItem = new ShipmentItems();

		shipmentItem.setShipmentId(shipmentItemVo.getShipmentId()).setOrderItem(orderItem);

		return shipmentItem;
	}

	private List<OrderItem> mapOrderItemVoToOrderItem(List<OrderItemVo> orderItemsVo) {
		return orderItemsVo.stream().filter(Objects::nonNull).map(this::mapOrderItemVoToOrderItem)
				.collect(Collectors.toList());
	}

	private OrderItem mapOrderItemVoToOrderItem(OrderItemVo orderItemVo) {
		OrderItem orderItem = new OrderItem();
		RefOrderItemStatusCodes itemStatusCode = new RefOrderItemStatusCodes();
		itemStatusCode.setOrderItemStatusCode(orderItemVo.getOrderItemStatusCode().getOrderItemStatusCode())
				.setOrderItemStatusDescription(orderItemVo.getOrderItemStatusCode().getOrderItemStatusDescription());
		Price price = new Price();
		price.setAmount(orderItemVo.getOrderItemPrice().getAmount())
				.setCurrency(orderItemVo.getOrderItemPrice().getCurrency());
		orderItem.setOrderItemId(orderItemVo.getOrderItemId()).setProductId(orderItemVo.getProductId())
				.setOrderItemStatusCode(itemStatusCode).setOrderItemQuantity(orderItemVo.getOrderItemQuantity())
				.setOrderItemPrice(price).setRmaNumber(orderItemVo.getRmaNumber())
				.setRmaIssuedBy(orderItemVo.getRmaIssuedBy()).setRmaIssuedDate(orderItemVo.getRmaIssuedDate())
				.setOtherOrderItemDetails(orderItemVo.getOtherOrderItemDetails());

		return orderItem;
	}

	public List<Shipments> mapShipmentsVoToShipments(List<ShipmentsVo> shipmentListVo) {
		return shipmentListVo.stream().filter(Objects::nonNull).map(this::mapShipmentsVoToShipments)
				.collect(Collectors.toList());
	}
}
