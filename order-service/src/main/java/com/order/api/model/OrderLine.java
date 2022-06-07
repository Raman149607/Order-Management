package com.order.api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "orderline")
public class OrderLine {

	@Valid
	private List<Item> items;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date eta;
	@Enumerated(EnumType.STRING)
	private OrderLinesStatus statusLine;
	@Valid
	private List<Address> addresses;

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public OrderLinesStatus getStatusLine() {
		return statusLine;
	}

	public void setStatusLine(OrderLinesStatus statusLine) {
		this.statusLine = statusLine;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
