package com.order.api.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "item")
public class Item {

	@NotBlank
	private String itemName;
	@Min(value = 0, message = "price should not be negative")
	private float price;
	@Min(value = 0, message = "qunatity should not be negative and can be 0 as out of stock")
	private int quantity;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
