package com.nisum.domain;

import java.util.List;

public class Order {

	private String orderId;
	private List<Address> addressList;
	
	

	public Order() {
		super();
	}

	public Order(String orderId, List<Address> addressList) {
		super();
		this.orderId = orderId;
		this.addressList = addressList;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", addressList=" + addressList + "]";
	}

	
}
