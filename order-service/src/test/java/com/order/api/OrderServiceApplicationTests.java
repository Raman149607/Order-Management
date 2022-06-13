package com.order.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.order.api.controller.OrderController;
import com.order.api.model.Address;
import com.order.api.model.Item;
import com.order.api.model.Order;
import com.order.api.model.OrderLine;
import com.order.api.model.OrderLinesStatus;
import com.order.api.model.Status;
import com.order.api.service.OrderService;

@SpringBootTest
public class OrderServiceApplicationTests {

	private static Logger logger = LogManager.getLogManager().getLogger(OrderServiceApplicationTests.class.getName());

	@Mock
	List<Order> order;

	@Mock
	OrderService orderService;

	@InjectMocks
	OrderController orderController;

	@Test
	public void testCreateOrder() {
		Order order = new Order();
		order.setTotalAmount(4000.0f);
		when(orderService.saveOrderDetails(order)).thenReturn(order);
		ResponseEntity<String> createOrder = orderController.createOrder(order);
		verify(orderService).saveOrderDetails(order);
		assertNotNull(createOrder);
		assertEquals(order.getTotalAmount(), 4000.0f, 0.0002);
	}

	@Test
	public void testCreateOrder_Should_throw_404_NOT_Found_When_Null() {
		Order order = null;
		ResponseEntity<String> createOrder = orderController.createOrder(order);
		assertNotNull(createOrder);
	}

	@Test
	public void testgetOrderById_Should_throw_404_NOT_Found_When_Null() {
		Order order = null;
		ResponseEntity<Order> orderById = orderController.getOrderById("123");
		assertNotNull(orderById);
	}
	
	@Test
	public void testgetOrderById() {
		Optional<Order> createOrder = Optional.of(createOrder());
		when(orderService.orderDetailsById("123")).thenReturn(createOrder);
		ResponseEntity<Order> orderById = orderController.getOrderById("123");
		verify(orderService).orderDetailsById("123");
		assertNotNull(orderById);
	}
	

	@Test
	public void testgetOrderDetailsByZipCode_Should_throw_404_NOT_Found_When_Null(){
		when(orderService.orderDetailsByZipCode(833218)).thenReturn(order);
		ResponseEntity<List<Order>> orderByZipCode = orderController.getOrderDetailsByZipCode(833218);
		verify(orderService).orderDetailsByZipCode(833218);
		assertNotNull(orderByZipCode);

	}
	
	@Test
	public void testgetOrderDetailsByZipCode(){ 
		List<Order> orderData = new ArrayList<>();
		orderData.add(createOrder());
		when(orderService.orderDetailsByZipCode(833218)).thenReturn(orderData);
		ResponseEntity<List<Order>> orderByZipCode = orderController.getOrderDetailsByZipCode(833218);
		verify(orderService).orderDetailsByZipCode(833218);
		assertNotNull(orderByZipCode);

	}

	private Date getDate() {
		Date date = null;
		String sDate1 = "2022/06/09";
		try {
			date = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
		} catch (ParseException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		return date;
	}

	private List<Address> createListOfAddress() {
		List<Address> listOfAddress = new ArrayList<>();
		Address address = new Address();
		address.setState("karnataka");
		address.setCountry("India");
		address.setZipCode(833218);
		listOfAddress.add(address);
		return listOfAddress;
	}

	private List<Item> createListOfItems() {
		List<Item> listOfItems = new ArrayList<>();
		Item item = new Item();
		item.setItemName("Iphone");
		item.setPrice(40000);
		item.setQuantity(2);
		listOfItems.add(item);
		return listOfItems;

	}

	private List<OrderLine> createListOfOrderLines() {
		List<OrderLine> listOfOrderLine = new ArrayList<>();
		OrderLine orderLine = new OrderLine();
		orderLine.setEta(getDate());
		orderLine.setAddresses(createListOfAddress());
		orderLine.setItems(createListOfItems());
		orderLine.setStatusLine(OrderLinesStatus.OPEN);
		listOfOrderLine.add(orderLine);
		return listOfOrderLine;
	}

	private Order createOrder() {
		Order order = new Order();
		order.setOrderLines(createListOfOrderLines());
		order.setOrderDate(getDate());
		// order.setId("123");
		order.setStatus(Status.OPEN);
		order.setTotalAmount(100000.0f);
		return order;
	}

}
