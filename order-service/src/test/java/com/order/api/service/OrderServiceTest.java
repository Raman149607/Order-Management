package com.order.api.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.order.api.model.Order;
import com.order.api.repository.OrderRepository;

class OrderServiceTest {
	
	@Mock
	Order order;
	
	@Mock
	OrderRepository orderRepository;
	
	@InjectMocks
	OrderService orderService;

	@Test
	void testSaveOrderDetails() {
		when(orderRepository.insert(order)).thenReturn(order);
		Order saveOrderDetails = orderService.saveOrderDetails(order);
		assertNotNull(saveOrderDetails);
		
	}

	@Test
	void testOrderDetailsById() {
	}

	@Test
	void testOrderDetailsByZipCode() {
	}

}
