package com.claycorp.nexstore.api.rest;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.claycorp.nexstore.api.exception.GlobalBaseException;
import com.claycorp.nexstore.api.mock.MockResponseBuilder;
import com.claycorp.nexstore.api.model.CustomResponse;
import com.claycorp.nexstore.api.service.CustomerOrderService;
import com.claycorp.nexstore.api.util.ResponseBuilder;
import com.claycorp.nexstore.api.vo.OrderVo;

@Controller
@RequestMapping(path = "/claycorp/api/v1", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerOrderController {

	@Autowired
	private ResponseBuilder<OrderVo> responseBuilder;

	@Autowired
	private CustomerOrderService customerOrderService;

	@Autowired
	private MockResponseBuilder mockBuilder;

	@GetMapping("/orders")
	public ResponseEntity<CustomResponse<OrderVo>> getAllOrderDetail() {
		return ResponseEntity.ok().body(
				responseBuilder.buildResponse(customerOrderService.getAllOrderDetails(), Collections.emptyList()));
	}

	@PostMapping("/orders")
	public ResponseEntity<CustomResponse<OrderVo>> addOrderDetails(@RequestBody OrderVo orderRequest) {

		return ResponseEntity.created(URI.create("/api/dev/claycorp/api/v1/orders")).body(responseBuilder
				.buildResponse(customerOrderService.addOrderDetails(orderRequest), Collections.emptyList()));
	}

	@PutMapping("/orders")
	public ResponseEntity<CustomResponse<OrderVo>> updateOrderDetails(@RequestBody OrderVo orderRequest)
			throws GlobalBaseException {

		return ResponseEntity.ok().body(responseBuilder
				.buildResponse(customerOrderService.updateOrderDetails(orderRequest), Collections.emptyList()));
	}

	@GetMapping("/orders/{orderId}")
	public ResponseEntity<CustomResponse<OrderVo>> findOneOrderDetails(@PathVariable(value = "orderId") String orderId)
			throws GlobalBaseException {

		return ResponseEntity.ok().body(
				responseBuilder.buildResponse(customerOrderService.findOrderDetails(orderId), Collections.emptyList()));
	}

	@DeleteMapping("/orders/{orderId}")
	public ResponseEntity<?> deleteOrderDetails(@PathVariable(value = "orderId") String orderId)
			throws GlobalBaseException {
		customerOrderService.deleteOrderDetails(orderId);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/orders/mock")
	public ResponseEntity<CustomResponse<OrderVo>> findMockOrderDetails() throws GlobalBaseException {

		return ResponseEntity.ok().body(
				responseBuilder.buildResponse(Arrays.asList(mockBuilder.buildMockOrder()), Collections.emptyList()));
	}
}