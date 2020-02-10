package com.nisum;

public class Test 
{
    public static void main( String[] args )
    {
    	
    	// We can consider this as Subject
        MessagePublisher publisher = new MessagePublisher();
        
        Observer observerOne = new ObserverOne();
        Observer observerTwo = new ObserverTwo();
        Observer observerThree = new ObserverThree();

        publisher.registerObserver(observerOne);
        publisher.registerObserver(observerTwo);
        
        // Push Data
        // Whenever subject tweets observer needs to be notified
        publisher.notifyObserver("Notification1");
        publisher.notifyObserver("Notification2");
        
        publisher.registerObserver(observerThree);
        publisher.notifyObserver("Notification3");
        
    }
}
