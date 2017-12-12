package com.claycorp.nexstore.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.claycorp.nexstore.api.exception.InvalidShipmentException;
import com.claycorp.nexstore.api.exception.UpdateFailureException;
import com.claycorp.nexstore.api.vo.ShipmentsVo;

@Service
public interface ShipmentService {

	List<ShipmentsVo> getAllShipmentDetails();

	List<ShipmentsVo> addShipmentDetails(ShipmentsVo shipmentRequest);

	List<ShipmentsVo> updateShipmentDetails(ShipmentsVo shipmentRequest) throws UpdateFailureException;

	List<ShipmentsVo> findShipmentDetails(String shipmentId) throws InvalidShipmentException;

	void deleteShipmentDetails(String shipmentId) throws InvalidShipmentException;
}
