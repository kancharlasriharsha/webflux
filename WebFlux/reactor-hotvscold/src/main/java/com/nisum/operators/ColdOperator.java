package com.nisum.operators;

import com.nisum.publishers.SubscriberOne;

import reactor.core.publisher.Mono;

public class ColdOperator {
	public static void main(String[] args) {
		Mono<String> mono = Mono.fromSupplier(DataUtil::getData);
		System.out.println("Before Subscription");
		mono.subscribe(new SubscriberOne());
	}
}
