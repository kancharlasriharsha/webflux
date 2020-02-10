package com.nisum.subscribers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.nisum.domain.Order;

public class OrderSubscriber implements Subscriber<Order> {

	@Override
	public void onSubscribe(Subscription s) {
		s.request(25);
		System.out.println("Subscribed ==== ");
	}

	@Override
	public void onNext(Order t) {
		System.out.println("============== Order Details =============");
		System.out.println(t);
	}

	@Override
	public void onError(Throwable t) {
		System.out.println("Received onError event");
		
	}

	@Override
	public void onComplete() {
		System.out.println("Received onComplete event");
	}

}
