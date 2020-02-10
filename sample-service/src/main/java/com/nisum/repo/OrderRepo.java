package com.nisum.repo;

import java.util.ArrayList;
import java.util.List;

import com.nisum.domain.Address;
import com.nisum.domain.Item;
import com.nisum.domain.Order;
import com.nisum.domain.OrderDetails;

public class OrderRepo {
	
	public static Order getOrderById(String orderId) {
		return new Order(orderId, getItems(), getAddress());
	}
	
	public static Order getOrder() {
		return new Order("order1", getItems(), getAddress());
	}
	
	public static Address getAddress() {
		return new Address("Corner 29","Plot#16","TS","India","500084");
	}
	
	public static List<Item> getItems() {
		List<Item> items = new ArrayList<>();
		items.add(new Item("item1", 1, 10));
		items.add(new Item("item2", 2, 20));
		items.add(new Item("item3", 3, 30));
		items.add(new Item("item4", 4, 40));
		return items;
	}
	
	public static OrderDetails getOrderDetails() {
		return new OrderDetails("order-1", "Completed");
	}
	
}
