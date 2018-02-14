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

import com.claycorp.nexstore.api.exception.GlobalBaseException;
import com.claycorp.nexstore.api.mock.MockResponseBuilder;
import com.claycorp.nexstore.api.model.CustomResponse;
import com.claycorp.nexstore.api.model.ShipmentsVo;
import com.claycorp.nexstore.api.service.ShipmentService;
import com.claycorp.nexstore.api.util.ResponseBuilder;

@Controller
@RequestMapping(path = "/claycorp/v1")
public class ShipmentController {
	
	private final Logger logger = LoggerFactory.getLogger(ShipmentController.class);
	
	@Autowired
	private ResponseBuilder<ShipmentsVo> responseBuilder;

	@Autowired
	private ShipmentService shipmentService;

	@Autowired
	private MockResponseBuilder mockBuilder;

	@GetMapping(path = "/shipments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CustomResponse<ShipmentsVo>> getAllProductDetail() {
		return ResponseEntity.ok()
				.body(responseBuilder.buildResponse(shipmentService.getAllShipmentDetails(), Collections.emptyList()));
	}

	@PostMapping(path = "/shipments", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CustomResponse<ShipmentsVo>> addProductDetails(@RequestBody ShipmentsVo productRequest) {

		return ResponseEntity.created(URI.create("/api/dev/claycorp/api/v1/shipments")).body(responseBuilder
				.buildResponse(shipmentService.addShipmentDetails(productRequest), Collections.emptyList()));
	}

	@PutMapping(path = "/shipments", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CustomResponse<ShipmentsVo>> updateProductDetails(@RequestBody ShipmentsVo productRequest)
			throws GlobalBaseException {

		return ResponseEntity.ok().body(responseBuilder
				.buildResponse(shipmentService.updateShipmentDetails(productRequest), Collections.emptyList()));
	}

	@GetMapping(path = "/shipments/{shipmentId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CustomResponse<ShipmentsVo>> findOneProductDetails(
			@PathVariable(value = "shipmentId") String shipmentId) throws GlobalBaseException {

		return ResponseEntity.ok().body(responseBuilder.buildResponse(shipmentService.findShipmentDetails(shipmentId),
				Collections.emptyList()));
	}

	@DeleteMapping(path = "/shipments/{shipmentId}")
	public ResponseEntity<?> deleteProductDetails(@PathVariable(value = "shipmentId") String shipmentId)
			throws GlobalBaseException {
		shipmentService.deleteShipmentDetails(shipmentId);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/shipments/mock")
	public ResponseEntity<CustomResponse<ShipmentsVo>> findMockOrderDetails() throws GlobalBaseException {

		return ResponseEntity.ok().body(
				responseBuilder.buildResponse(Arrays.asList(mockBuilder.buildMockShipment()), Collections.emptyList()));
	}
}