package com.nisum;

public interface IOrderCollection {

	public void addOrder(Order c);
	public void removeOrder(Order c);
	public IOrderIterator iterator();

}
