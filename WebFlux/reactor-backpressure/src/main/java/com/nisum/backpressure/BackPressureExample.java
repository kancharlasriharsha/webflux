package com.nisum.backpressure;

import reactor.core.publisher.Flux;

public class BackPressureExample {
	public static void main(String[] args) {
		Flux<String> weeks = Flux.just("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
//		weeks.subscribe(new SubscriberOne());
		weeks.subscribe(new SubscriberTwo());		
	}
}
