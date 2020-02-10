package com.nisum.backpressure;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class SubscriberTwo implements Subscriber<String>{
	
	private Subscription local;
	public void onSubscribe(Subscription s) {
		this.local = s;
		s.request(1);
		System.out.println("Received onSubscribe event");		
	}

	public void onNext(String t) {
		System.out.println("Received onNext event with data "+t);
		System.out.println("Taking time processing");
		try {
			Thread.sleep(1000*2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		local.request(1);
	}

	public void onError(Throwable t) {
		System.out.println("Received onError event");
		
	}

	public void onComplete() {
		System.out.println("Received onComplete event");
	}
}
