package com.claycorp.nexstore.api.service.impl;

import static org.zalando.problem.Status.BAD_REQUEST;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zalando.problem.Problem;
import org.zalando.problem.ThrowableProblem;

import com.claycorp.nexstore.api.exception.InvalidShipmentException;
import com.claycorp.nexstore.api.exception.UpdateFailureException;
import com.claycorp.nexstore.api.model.Shipments;
import com.claycorp.nexstore.api.repository.ShipmentRepository;
import com.claycorp.nexstore.api.service.ShipmentService;
import com.claycorp.nexstore.api.util.ShipmentMapper;
import com.claycorp.nexstore.api.vo.ShipmentsVo;

@Service
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	private ShipmentRepository shipmentRepo;

	@Autowired
	private ShipmentMapper mapper;

	@Override
	public List<ShipmentsVo> getAllShipmentDetails() {
		return mapper.mapShipmentsToShipmentsVo(shipmentRepo.findAll());
	}

	@Override
	public List<ShipmentsVo> addShipmentDetails(ShipmentsVo shipmentRequest) {
		return mapper.mapShipmentsToShipmentsVo(
				Arrays.asList(shipmentRepo.save(mapper.mapShipmentsVoToShipments(shipmentRequest))));
	}

	@Override
	public List<ShipmentsVo> updateShipmentDetails(ShipmentsVo shipmentRequest) throws UpdateFailureException {
		String shipmentId = shipmentRequest.getShipmentId();
		if (null == shipmentId || shipmentId.isEmpty()) {
			throw new UpdateFailureException(Arrays.asList(getUpdateFailureProblem()));
		}
		return Arrays.asList(
				mapper.mapShipmentsToShipmentsVo(shipmentRepo.save(mapper.mapShipmentsVoToShipments(shipmentRequest))));
	}

	@Override
	public List<ShipmentsVo> findShipmentDetails(String shipmentId) throws InvalidShipmentException {
		if (null == shipmentRepo.findOne(shipmentId)) {
			throw new InvalidShipmentException(Arrays.asList(getInvalidShipmentException()));
		}
		return Arrays.asList(mapper.mapShipmentsToShipmentsVo(shipmentRepo.findOne(shipmentId)));
	}

	@Override
	public void deleteShipmentDetails(String shipmentId) throws InvalidShipmentException {
		Shipments shipments = shipmentRepo.findOne(shipmentId);
		if (null == shipments) {
			throw new InvalidShipmentException(Arrays.asList(getInvalidShipmentException()));
		}
		shipmentRepo.delete(shipments);
	}

	private ThrowableProblem getInvalidShipmentException() {
		return Problem.builder().withType(URI.create("/api/dev/claycorp/api/v1/products")).withStatus(BAD_REQUEST)
				.with("code", "ER32").with("message", "Invalid Shipment Id provided").build();
	}

	private ThrowableProblem getUpdateFailureProblem() {
		return Problem.builder().withType(URI.create("/api/dev/claycorp/api/v1/products")).withStatus(BAD_REQUEST)
				.with("code", "ER31").with("message", "Shipment Id is not provided in request").build();
	}
}