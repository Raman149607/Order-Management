package com.order.api.model;

import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orderCollection")
public class OrderDto extends Order {

	@Id
	private ObjectId id;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
}
