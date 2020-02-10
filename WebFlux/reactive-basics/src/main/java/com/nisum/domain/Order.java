package com.nisum.domain;

import java.util.List;

public class Order {

	private String orderId;
	private List<Item> items;
	private Address address;

	public Order() {
		super();
	}

	public Order(String orderId, List<Item> items, Address address) {
		super();
		this.orderId = orderId;
		this.items = items;
		this.address = address;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", items=" + items + ", address=" + address + "]";
	}
	

}
