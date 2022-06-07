package com.order.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.api.model.Order;
import com.order.api.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public Order saveOrderDetails(Order order) {
		return orderRepository.insert(order);
	}

	public Optional<Order> orderDetailsById(String id) {
		return orderRepository.findById(id);
	}

	public List<Order> orderDetailsByZipCode(int zipCode) {
		return orderRepository.findByPinCode(zipCode);
	}

}
