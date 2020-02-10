package com.nisum;

import java.util.ArrayList;
import java.util.List;

public class OrderCollectionImpl implements IOrderCollection{
	
	private List<Order> orderList = new ArrayList<>();

	public void addOrder(Order order) {
		this.orderList.add(order);
	}

	public void removeOrder(Order order) {
		this.orderList.remove(order);
	}

	public IOrderIterator iterator() {
		return new OrderIteratorImpl(orderList);
	}
	
	private class OrderIteratorImpl implements IOrderIterator {
		
		private int position;
		private List<Order> orderList;
		
		public OrderIteratorImpl(List<Order> orderList) {
			this.orderList =orderList;
		}

		@Override
		public boolean hasNext() {
			return position<orderList.size();
		}

		@Override
		public Order next() {
			Order order = orderList.get(position);
			position = position+1;
			return order;
		}
		
	}

}
