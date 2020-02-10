package com.nisum.operators.transform;

import java.util.Arrays;
import java.util.List;

import com.nisum.domain.Address;
import com.nisum.domain.Order;
import com.nisum.util.SubscriberUtil;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

public class TransformingPublisher {

	protected static List<Order> orders = Arrays.asList(
			new Order("order1", Arrays.asList(new Address("Kothaguda"), new Address("Madhapur"))),
			new Order("order2", Arrays.asList(new Address("Ameerpet"), new Address("Secunderabad"))));

	public static void main(String[] args) {
		
//		map();
//		flatMap();
//		concatWith();
//		concat();
//		zip();
//		zipWith();
		
	}

	public static void map() {
		Flux<Order> strFlux = Flux.fromIterable(orders);
		Flux<String> intFlux = strFlux.map(order -> order.getOrderId());
		intFlux.subscribe(SubscriberUtil.getStrSubscriber());
	}

	public static void flatMap() {
		Flux<Order> strFlux = Flux.fromIterable(orders);
		Flux<Address> intFlux = strFlux.flatMap(order -> Flux.fromIterable(order.getAddressList()));
		intFlux.subscribe(SubscriberUtil.getAddrSubscriber());
	}

	public static void concatWith() {
		Flux<Integer> flux1 = Flux.just(1, 2, 3, 4, 5);
		Flux<Integer> flux2 = Flux.just(6, 7, 8, 9, 10);
		flux2.concatWith(flux1).subscribe(SubscriberUtil.getSubscriber());
	}

	public static void concat() {
		Flux<Integer> flux1 = Flux.just(1, 2, 3, 4, 5);
		Flux<Integer> flux2 = Flux.just(6, 7, 8, 9, 10);
		Flux.concat(flux1, flux2).subscribe(SubscriberUtil.getSubscriber());
	}

	public static void zip() {
		Flux<Integer> flux1 = Flux.just(1, 2, 3).map(n -> n * 2);
		Flux<String> flux2 = Flux.just("One", "Two", "Three", "Four");
		
		Flux<Tuple2<Integer, String>> tuple = Flux.zip(flux1, flux2);
		
		Flux.zip(flux1, flux2).doOnNext(t -> {
			System.out.println(t.getT1() + "--------" + t.getT2());
		}).subscribe();
	}

	public static void zipWith() {
		Flux<Integer> flux1 = Flux.just(1, 2, 3).map(n -> n * 2);
		Flux<String> flux2 = Flux.just("One", "Two", "Three");
		flux2.zipWith(flux1).doOnNext(t -> {
			System.out.println(t.getT1() + "--------" + t.getT2());
		}).subscribe();
	}

	public static void error() {
		
		Flux.just(1, 2, 3, 4).map(n -> {
			if (n == 2)
				throw new RuntimeException("Sample Message");
			return n;
		})
		
		.onErrorMap(ex-> new RuntimeException("Modified"))
		
		.onErrorReturn(10)
		
		.onErrorResume(ex -> {
			return Flux.just(50, 60, 70);
		})
		
		.subscribe(SubscriberUtil.getSubscriber());
		
	}
}
