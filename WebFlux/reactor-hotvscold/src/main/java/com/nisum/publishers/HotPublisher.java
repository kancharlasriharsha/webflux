package com.nisum.publishers;

import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;

public class HotPublisher {
	public static void main(String[] args) {
		
		DirectProcessor<String> hotSource = DirectProcessor.create();
		
		Flux<String> hotFlux = hotSource.map(String::toUpperCase);	
		
		hotFlux = hotSource.map(str->"_"+str);		
		
		hotSource.onNext("Sunday");
		hotSource.onNext("Monday");
		
		hotFlux.subscribe(new SubscriberOne());
		
		hotSource.onNext("Tuesday");
		hotSource.onNext("Wednessday");
		
		hotFlux.subscribe(new SubscriberTwo());
		
		hotSource.onNext("Thursday");
		hotSource.onNext("Friday");
		hotSource.onNext("Saturday");
	}
}
