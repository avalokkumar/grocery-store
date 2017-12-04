package com.claycorp.nexstore.api.service.impl;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import static org.zalando.problem.Status.BAD_REQUEST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zalando.problem.Problem;
import org.zalando.problem.ThrowableProblem;

import com.claycorp.nexstore.api.exception.InvalidOrderException;
import com.claycorp.nexstore.api.model.Order;
import com.claycorp.nexstore.api.repository.OrderRepository;
import com.claycorp.nexstore.api.service.CustomerOrderService;
import com.claycorp.nexstore.api.util.CustomerOrderMapper;
import com.claycorp.nexstore.api.vo.OrderVo;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private CustomerOrderMapper mapper;

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
			throw new InvalidOrderException(Arrays.asList(getUpdateFailureException()));
		}
		return Arrays.asList(mapper.mapOrderToOrderVo(orderRepo.save(mapper.mapOrderVoToOrder(orderRequest))));
	}

	@Override
	public void deleteOrderDetails(String orderId) throws InvalidOrderException {
		Order order = orderRepo.findOne(orderId);
		if (null == orderId) {
			throw new InvalidOrderException(Arrays.asList(getInvalidOrderException()));
		}
		orderRepo.delete(order);
	}

	private ThrowableProblem getInvalidOrderException() {
		return Problem.builder().withType(URI.create("/api/dev/claycorp/api/v1/orders")).withStatus(BAD_REQUEST)
				.with("code", "ER32").with("message", "Order Id is not provided in the request").build();
	}

	private ThrowableProblem getUpdateFailureException() {
		return Problem.builder().withType(URI.create("/api/dev/claycorp/api/v1/orders")).withStatus(BAD_REQUEST)
				.with("code", "ER31").with("message", "Invalid Order Id provided").build();
	}
}
