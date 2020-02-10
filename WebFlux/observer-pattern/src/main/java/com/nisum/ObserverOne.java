package com.nisum;

public class ObserverOne implements Observer{

	@Override
	public void update(String message) {
		System.out.println("ObserverOne Recieved Notification with message " + message);
	}

}
