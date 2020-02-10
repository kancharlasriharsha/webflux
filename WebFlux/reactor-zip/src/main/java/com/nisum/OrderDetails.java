package com.nisum;

public class OrderDetails {
	
	private String orderId;
	private String status;

	public OrderDetails() {
		super();
	}

	public OrderDetails(String orderId, String status) {
		super();
		this.orderId = orderId;
		this.status = status;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
