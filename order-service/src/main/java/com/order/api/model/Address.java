package com.order.api.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "address")
public class Address {

	@Min(value = 6, message = "pincode should be at least 6 digits")
	private int zipCode;
	@NotEmpty
	private String state;
	@NotEmpty
	private String country;

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
