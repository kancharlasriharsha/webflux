package com.nisum;

public class ObserverTwo implements Observer {
	
	@Override
	public void update(String message) {
		System.out.println("ObserverTwo Recieved Notification with message " + message);
	}
	
}
