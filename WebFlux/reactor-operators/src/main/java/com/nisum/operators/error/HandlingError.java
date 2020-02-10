package com.nisum.operators.error;

import com.nisum.util.SubscriberUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class HandlingError {

	public static void main(String[] args) {
		tryCatch();
//		error();
//		onErrorMap();
//		onErrorReturn();
//		onErrorResume();
	}

	
	public static void tryCatch() {
		Flux<Integer> flux = null;

		try {
			flux = Flux.just(1, 2, 3, 4).map(n -> {
				if (n == 2)
					throw new RuntimeException("ErrorMessage");
				return n;
			});
		} catch (Throwable t) {
			System.out.println("=== Into catch block");
		}
		flux.subscribe(SubscriberUtil.getSubscriber());
	}
	

	public static void error() {
		Mono<Integer> mono = Mono.error(new RuntimeException("ErrorMessage"));
		mono.subscribe(SubscriberUtil.getSubscriber());
	}

	public static void onErrorMap() {

		Flux.just(1, 2, 3, 4).map(n -> {
			if (n == 2)
				throw new RuntimeException("ErrorMessage");
			return n;
		}).onErrorMap(ex -> new RuntimeException("Modified-ErrorMessage")).subscribe(SubscriberUtil.getSubscriber());

	}

	public static void onErrorReturn() {

		Flux.just(1, 2, 3, 4).map(n -> {
			if (n == 2)
				throw new RuntimeException("ErrorMessage");
			return n;
		}).onErrorReturn(10).subscribe(SubscriberUtil.getSubscriber());

	}

	public static void onErrorResume() {

		Flux.just(1, 2, 3, 4).map(n -> {
			if (n == 2)
				throw new RuntimeException("ErrorMessage");
			return n;
		}).onErrorResume(ex -> {
			return Flux.just(50, 60, 70);
		}).subscribe(SubscriberUtil.getSubscriber());

	}
}
