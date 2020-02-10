package com.nisum.operators.filter;

import com.nisum.domain.Address;
import com.nisum.util.SubscriberUtil;

import reactor.core.publisher.Flux;

public class FilteringSequence {

	public static void main(String[] args) {

//		filter();
		distinct();
		
	}

	public static void filter() {
		Flux.range(1, 25).filter(n -> n % 2 == 0).subscribe(SubscriberUtil.getSubscriber());
	}

	public static void distinct() {
		Flux.just(new Address("Kothaguda"), new Address("Madhapur"), new Address("Madhapur"), new Address("Ameerpet"),
				new Address("Ameerpet")).distinct().subscribe(SubscriberUtil.getAddrSubscriber());
	}

}
