package com.order.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.api.model.Order;
import com.order.api.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/orderdetails")
	public ResponseEntity<String> createOrder(@Valid @RequestBody Order order) {

		try {
			orderService.saveOrderDetails(order);
			return ResponseEntity.status(HttpStatus.CREATED).body("OrderDetails Added Successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OrderDetails Cannot Be added");
		}
	}
	
	@GetMapping("/orderdetails/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") String id) {
		Optional<Order> orderData = orderService.orderDetailsById(id);
		if (orderData.isPresent()) {
			return new ResponseEntity<>(orderData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{zipCode}")
	public ResponseEntity<List<Order>> getOrderDetailsByZipCode(@PathVariable int zipCode) {
		
		List<Order> orderData = new ArrayList<>();
		orderService.orderDetailsByZipCode(zipCode).forEach(orderData::add);
		if (!orderData.isEmpty()) {
			return new ResponseEntity<>(orderData, HttpStatus.OK);

		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}
