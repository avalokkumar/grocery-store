package com.claycorp.nexstore.api.rest;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.client.RestTemplate;

import com.claycorp.nexstore.api.exception.GlobalBaseException;
import com.claycorp.nexstore.api.mock.MockResponseBuilder;
import com.claycorp.nexstore.api.model.CustomResponse;
import com.claycorp.nexstore.api.model.OrderVo;
import com.claycorp.nexstore.api.service.CustomerOrderService;
import com.claycorp.nexstore.api.util.ResponseBuilder;

@Controller
@RequestMapping(path = "/claycorp/v1")
public class CustomerOrderController {

	private final Logger logger = LoggerFactory.getLogger(CustomerOrderController.class);

	@Autowired
	private ResponseBuilder<OrderVo> responseBuilder;

	@Autowired
	private CustomerOrderService customerOrderService;

	@Autowired
	private MockResponseBuilder mockBuilder;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/execute")
	public ResponseEntity<String> someMethod() {
		logger.info("Inside execute method");
		return ResponseEntity.ok().body(this.restTemplate
				.getForObject("http://customer-registration-service/api/dev/claycorp/v1/serviceinfo", String.class));
	}

	@GetMapping("/orders")
	public ResponseEntity<CustomResponse<OrderVo>> getAllOrderDetail() {

		logger.debug("Entering Customer Order Service");
		// UserVo user = restTemplate.getForObject(CUSTOMER_URL, UserVo.class);
		// logger.info("User details {}", user);
		return ResponseEntity.ok().body(
				responseBuilder.buildResponse(customerOrderService.getAllOrderDetails(), Collections.emptyList()));
	}

	@GetMapping(path = "/orders/{orderId}")
	public ResponseEntity<CustomResponse<OrderVo>> findOneOrderDetails(@PathVariable(value = "orderId") String orderId)
			throws GlobalBaseException {

		return ResponseEntity.ok().body(
				responseBuilder.buildResponse(customerOrderService.findOrderDetails(orderId), Collections.emptyList()));
	}

	@PostMapping(path = "/orders", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CustomResponse<OrderVo>> addOrderDetails(@RequestBody OrderVo orderRequest) {

		return ResponseEntity.created(URI.create("/api/dev/claycorp/api/v1/orders")).body(responseBuilder
				.buildResponse(customerOrderService.addOrderDetails(orderRequest), Collections.emptyList()));
	}

	@PutMapping(path = "/orders", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CustomResponse<OrderVo>> updateOrderDetails(@RequestBody OrderVo orderRequest)
			throws GlobalBaseException {

		return ResponseEntity.ok().body(responseBuilder
				.buildResponse(customerOrderService.updateOrderDetails(orderRequest), Collections.emptyList()));
	}

	@DeleteMapping("/orders/{orderId}")
	public ResponseEntity<?> deleteOrderDetails(@PathVariable(value = "orderId") String orderId)
			throws GlobalBaseException {
		customerOrderService.deleteOrderDetails(orderId);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/orders/mock")
	public ResponseEntity<CustomResponse<OrderVo>> findMockOrderDetails() {

		return ResponseEntity.ok().body(
				responseBuilder.buildResponse(Arrays.asList(mockBuilder.buildMockOrder()), Collections.emptyList()));
	}
}