package com.claycorp.nexstore.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.claycorp.nexstore.api.exception.InvalidOrderException;
import com.claycorp.nexstore.api.model.OrderVo;

@Service
public interface CustomerOrderService {

	List<OrderVo> getAllOrderDetails();

	List<OrderVo> findOrderDetails(String orderId);

	List<OrderVo> addOrderDetails(OrderVo orderRequest);

	List<OrderVo> updateOrderDetails(OrderVo orderRequest) throws InvalidOrderException;

	void deleteOrderDetails(String orderId) throws InvalidOrderException ;

}
