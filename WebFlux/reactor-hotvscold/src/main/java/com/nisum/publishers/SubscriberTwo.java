package com.nisum.publishers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class SubscriberTwo implements Subscriber<String> {
	
	public void onSubscribe(Subscription s) {
		s.request(6);
		System.out.println("Received onSubscribe event");
	}

	public void onNext(String t) {
		System.out.println("2_SubscriberTwo : Received onNext event with value " + t);
	}

	public void onError(Throwable t) {
		System.out.println("Received onError event");
	}

	public void onComplete() {
		System.out.println("Received onComplete event");
	}
}
