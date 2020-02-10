package com.nisum;

public class ObserverThree implements Observer {
	
	@Override
	public void update(String message) {
		System.out.println("ObserverThree Recieved Notification with message " + message);
	}
	
}
