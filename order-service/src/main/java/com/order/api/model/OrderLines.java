package com.order.api.model;

import java.util.Date;
import java.util.List;

public class OrderLines {

	private int id;
	private Item items;
	private Date eta;
	private OrderLinesStatus statusLine;
	private List<Address> addresses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getItems() {
		return items;
	}

	public void setItems(Item items) {
		this.items = items;
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

}
