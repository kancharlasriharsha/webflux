package com.nisum;

import java.util.ArrayList;
import java.util.List;

public class MessagePublisher implements Observable {

	List<Observer> observers = new ArrayList<>();

	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void notifyObserver(String message) {
		
		for(Observer observer : observers) {
			observer.update(message);
		}
		
	}

}
