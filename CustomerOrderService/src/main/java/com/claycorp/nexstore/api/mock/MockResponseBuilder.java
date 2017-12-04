package com.claycorp.nexstore.api.mock;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.claycorp.nexstore.api.vo.OrderItemVo;
import com.claycorp.nexstore.api.vo.OrderVo;
import com.claycorp.nexstore.api.vo.PriceVo;
import com.claycorp.nexstore.api.vo.RefOrderItemStatusCodesVo;
import com.claycorp.nexstore.api.vo.RefOrderStatusCodesVo;

@Service
public class MockResponseBuilder {

	public OrderVo buildMockOrder() {
		OrderVo orderVo = new OrderVo();
		RefOrderStatusCodesVo statusCodeVo = new RefOrderStatusCodesVo();
		statusCodeVo.setOrderStatusCodeVo("ST01")
				.setOrderStatusDescriptionVo("In Transit");
		orderVo.setOrderDetailsVo(Arrays.asList(buildOrderItemVo())).setOrderId("adasdyua32748hadasdad3")
				.setOrderStatusCodeVo(statusCodeVo).setDateOfOrderPlaced(LocalDateTime.now());
		return orderVo;
	}

	private OrderItemVo buildOrderItemVo() {
		OrderItemVo orderItemVo = new OrderItemVo();
		RefOrderItemStatusCodesVo itemStatusCodeVo = new RefOrderItemStatusCodesVo();
		itemStatusCodeVo.setOrderItemStatusCodeVo("ST22")
				.setOrderItemStatusDescriptionVo("Packaged");
		PriceVo priceVo = new PriceVo();
		priceVo.setAmountVo(Double.valueOf(3424))
				.setCurrencyVo("INR");
		orderItemVo.setOrderItemId("32af2e2dsa31dsd").setProductId("ad322e32d2d23dsad13ds")
				.setItemStatusCodeVo(itemStatusCodeVo).setItemQuantity(Long.valueOf(12))
				.setItemPriceVo(priceVo).setRmaNumber(Long.valueOf(131312345))
				.setRmaIssuedBy("Clayman").setRmaIssuedDate(LocalDateTime.now())
				.setOtherOrderItemDetails("Nothing as yet");

		return orderItemVo;
	}
	/*
	 * private Address buildAddressMock() { Address address = new Address();
	 * address.setAddress1("Church Stree1").setAddress2("Stree2").
	 * setLandmark("Park plaza").setPinCode("3424234"); return address; }
	 */
}
