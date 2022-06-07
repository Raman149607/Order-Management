package com.order.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.order.api.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String>{
	
	@Query("{'orderLines.addresses.zipCode':?0}")
	List<Order> findByPinCode(int zipCode);

}
