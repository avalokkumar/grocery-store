package com.claycorp.nexstore.api.mock;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.claycorp.nexstore.api.vo.OrderItemVo;
import com.claycorp.nexstore.api.vo.OrderVo;
import com.claycorp.nexstore.api.vo.PriceVo;
import com.claycorp.nexstore.api.vo.RefOrderItemStatusCodesVo;
import com.claycorp.nexstore.api.vo.RefOrderStatusCodesVo;
import com.claycorp.nexstore.api.vo.ShipmentItemsVo;
import com.claycorp.nexstore.api.vo.ShipmentsVo;

@Service
public class MockResponseBuilder {

	public ShipmentsVo buildMockShipment() {
		ShipmentsVo shipmentVo = new ShipmentsVo();
		OrderVo orderVo = buildOrderVo();
		OrderItemVo orderItemVo = buildOrderItemVo();
		orderVo.setOrderDetails(Arrays.asList(orderItemVo));
		
		ShipmentItemsVo shipmentItemsVo = buildShipmentItemsVo();
		
		shipmentVo.setShipmentId("asdas3yhr2hih2h4234sad").setOrder(orderVo)
				.setInvoiceNumber(Long.valueOf(23423424))
				.setShipmentTrackingNumber(Long.valueOf(32425425))
				.setShipmentDate(LocalDateTime.now())
				.setOtherShipmentDetails("Something")
				.setShipmentItems(Arrays.asList(shipmentItemsVo));

		return shipmentVo;
	}

	private ShipmentItemsVo buildShipmentItemsVo() {
		ShipmentItemsVo shipmentItemVo = new ShipmentItemsVo();
		shipmentItemVo.setOrderItemVo(buildOrderItemVo())
					  .setShipmentId("3242ewr2ew24fdfsf2");
		return shipmentItemVo;
	}

	private OrderItemVo buildOrderItemVo() {
		OrderItemVo orderItemVo = new OrderItemVo();
		orderItemVo.setOrderItemId("ahadst327ga732yhdafd")
				   .setOrderItemPrice(new PriceVo("INR", Double.valueOf(342432)))
				   .setOrderItemQuantity(Long.valueOf(3))
				   .setOrderItemStatusCode(new RefOrderItemStatusCodesVo("ST12", "In Progress"))
				   .setProductId("adsa3242d23adda31dsa")
				   .setOtherOrderItemDetails("Something else")
				   .setRmaNumber(Long.valueOf(32423424))
				   .setRmaIssuedBy("Clayman")
				   .setRmaIssuedDate(LocalDateTime.now());
		return orderItemVo;
	}

	private OrderVo buildOrderVo() {
		OrderVo orderVo = new OrderVo();
		orderVo.setId("gh32y4ui2uhhiu2das")
			   .setStatusCode(new RefOrderStatusCodesVo("ST32", "Some Status"))
			   .setDateOfOrderPlaced(LocalDateTime.now())
			   .setOrderDetails(Arrays.asList(buildOrderItemVo()));
		return orderVo;
	}

	/*
	 * private Address buildAddressMock() { Address address = new Address();
	 * address.setAddress1("Church Stree1").setAddress2("Stree2").
	 * setLandmark("Park plaza").setPinCode("3424234"); return address; }
	 */
}
