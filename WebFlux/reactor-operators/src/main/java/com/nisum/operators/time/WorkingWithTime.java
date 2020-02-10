package com.nisum.operators.time;

import java.time.Duration;

import com.nisum.util.SubscriberUtil;

import reactor.core.publisher.Flux;

public class WorkingWithTime {

	public static void main(String[] args) {
//		delay();
		timeout();
	}

	public static void delay() {
		Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5, 6, 7).delayElements(Duration.ofMillis(1000 * 1));
		flux.subscribe(SubscriberUtil.getSubscriber());
		System.out.println("====================");
		sleep();
	}

	public static void timeout() {
		Flux.just(1, 2, 3, 4, 5, 6, 7).map(n -> {
			
			try {
				Thread.sleep(1000*2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return n * 2;
		}).timeout(Duration.ofMillis(1000*4)).subscribe(SubscriberUtil.getSubscriber());
		
		sleep();
	}

	public static void sleep() {
		try {
			Thread.sleep(1000 * 60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
