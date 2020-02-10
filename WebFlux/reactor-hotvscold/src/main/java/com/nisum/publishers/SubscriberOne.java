package com.nisum.publishers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class SubscriberOne implements Subscriber<String> {

	
	public void onSubscribe(Subscription s) {
		s.request(2);
		System.out.println("Received onSubscribe event");
	}

	public void onNext(String t) {
		System.out.println("1_SubscriberOne : Received onNext event with value "+t);
	}

	public void onError(Throwable t) {
		System.out.println("Received onError event");
	}

	public void onComplete() {
		System.out.println("Received onComplete event");
	}

}
