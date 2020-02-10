package com.nisum.operators;

import com.nisum.publishers.SubscriberOne;

import reactor.core.publisher.Mono;

public class HotOperator {

	public static void main(String[] args) {
		Mono<String> mono = Mono.just(DataUtil.getData());
		System.out.println("Before Subscription");
		mono.subscribe(new SubscriberOne());
	}


}
