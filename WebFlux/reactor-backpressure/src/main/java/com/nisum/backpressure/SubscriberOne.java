package com.nisum.backpressure;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class SubscriberOne implements Subscriber<String>{

	public void onSubscribe(Subscription s) {
		s.request(4);
		System.out.println("Received onSubscribe event");		
	}

	public void onNext(String t) {
		System.out.println("Received onNext event");
		
	}

	public void onError(Throwable t) {
		System.out.println("Received onError event");
		
	}

	public void onComplete() {
		System.out.println("Received onComplete event");
	}

	
}
