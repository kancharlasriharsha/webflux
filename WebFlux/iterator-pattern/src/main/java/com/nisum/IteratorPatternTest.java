package com.nisum;

public class IteratorPatternTest 
{
    public static void main( String[] args )
    {
        IOrderCollection orderCollection = new OrderCollectionImpl();
        orderCollection.addOrder(new Order("order1", "Received"));
        orderCollection.addOrder(new Order("order2", "Received"));
        orderCollection.addOrder(new Order("order3", "Received"));
        orderCollection.addOrder(new Order("order4", "Completed"));
        orderCollection.addOrder(new Order("order5", "Completed"));
        orderCollection.addOrder(new Order("order6", "Completed"));

        IOrderIterator iterator = orderCollection.iterator();
        
        while(iterator.hasNext()) {
        	// Pull Data
        	Order order = iterator.next();
        	System.out.println(order.getId()+"==="+order.getStatus());
        }

    }
}
