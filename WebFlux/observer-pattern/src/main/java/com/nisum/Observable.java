package com.nisum;

public interface Observable {
	public void registerObserver(Observer observer);
	public void notifyObserver(String message);
}
