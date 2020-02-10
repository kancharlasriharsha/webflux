package com.nisum.domain;

public class Item {

	private String itemId;
	private int quantity;
	private int price;

	public Item() {
		super();
	}

	public Item(String itemId, int quantity, int price) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
