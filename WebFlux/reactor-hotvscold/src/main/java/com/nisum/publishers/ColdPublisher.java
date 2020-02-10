package com.nisum.publishers;

import reactor.core.publisher.Flux;

public class ColdPublisher {

	public static void main(String[] args) {

		Flux<String> weeks = Flux.just("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");

		weeks = weeks.map(str -> "_" + str);
		System.out.println("===== Before SubscriberOne ========");
		weeks.subscribe(new SubscriberOne());

		weeks = weeks.map(str -> str + "_");
		System.out.println("===== Before SubscriberTwo =======");
		weeks.subscribe(new SubscriberTwo());

	}
}
