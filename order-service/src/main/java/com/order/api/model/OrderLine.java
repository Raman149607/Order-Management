package com.order.api.model;

import java.util.Date;
import java.util.List;

public class OrderLine {

	private int id;
	private List<Item> items;
	private Date eta;
	private OrderLinesStatus statusLine;
	private List<Address> addresses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
