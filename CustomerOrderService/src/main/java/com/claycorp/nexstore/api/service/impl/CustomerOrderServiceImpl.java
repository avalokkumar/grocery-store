package com.claycorp.nexstore.api.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claycorp.nexstore.api.entity.Order;
import com.claycorp.nexstore.api.exception.InvalidOrderException;
import com.claycorp.nexstore.api.model.OrderVo;
import com.claycorp.nexstore.api.repository.OrderRepository;
import com.claycorp.nexstore.api.service.CustomerOrderService;
import com.claycorp.nexstore.api.util.CustomerOrderMapper;
import com.claycorp.nexstore.api.util.ExceptionUtil;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private CustomerOrderMapper mapper;

	@Autowired
	private ExceptionUtil exceptionUtil;

	@Override
	public List<OrderVo> getAllOrderDetails() {
		return mapper.mapOrderToOrderVo(orderRepo.findAll());
	}

	@Override
	public List<OrderVo> findOrderDetails(String orderId) {
		return Arrays.asList(mapper.mapOrderToOrderVo(orderRepo.findOne(orderId)));
	}

	@Override
	public List<OrderVo> addOrderDetails(OrderVo orderRequest) {
		return Arrays.asList(mapper.mapOrderToOrderVo(orderRepo.save(mapper.mapOrderVoToOrder(orderRequest))));
	}

	@Override
	public List<OrderVo> updateOrderDetails(OrderVo orderRequest) throws InvalidOrderException {
		if (null == orderRequest.getOrderId() || orderRequest.getOrderId().isEmpty()) {
			throw new InvalidOrderException(Arrays.asList(exceptionUtil.getUpdateFailureException()));
		}
		
		return Collections
				.singletonList(mapper.mapOrderToOrderVo(orderRepo.save(mapper.mapOrderVoToOrder(orderRequest))));
	}

	@Override
	public void deleteOrderDetails(String orderId) throws InvalidOrderException {
		Order order = orderRepo.findOne(orderId);
		if (null == orderId) {
			throw new InvalidOrderException(Collections.singletonList(exceptionUtil.getInvalidOrderException()));
		}
		orderRepo.delete(order);
	}

}
