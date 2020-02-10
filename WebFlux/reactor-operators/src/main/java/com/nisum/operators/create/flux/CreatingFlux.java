package com.nisum.operators.create.flux;

import java.util.Arrays;
import java.util.List;

import com.nisum.util.SubscriberUtil;

import reactor.core.publisher.Flux;

public class CreatingFlux {
	
	public static void main(String[] args) throws InterruptedException {

		Flux<Integer> flux = null;

		flux = justWithSomeValues();
//		flux = justByCallingAMethod();
//		flux = fromArray();
//		flux = fromIterable();
//		flux = range();
		flux = fromStream();

		System.out.println("==== Before subscribe ====");
		flux.subscribe(SubscriberUtil.getSubscriber());

	}

	public static Flux<Integer> justWithSomeValues() {
		return Flux.just(1, 2, 3, 4, 5);
	}

	public static Flux<Integer> justByCallingAMethod() {
		return Flux.just(getData());
	}

	public static Flux<Integer> fromArray() {
		Integer[] data = new Integer[] { 11, 12, 13, 14, 15 };
		return Flux.fromArray(data);
	}

	public static Flux<Integer> fromIterable() {
		List<Integer> data = Arrays.asList(21, 22, 23, 24, 25);
		return Flux.fromIterable(data);
	}

	public static Flux<Integer> range() {
		return Flux.range(1, 20);
	}

	public static Flux<Integer> fromStream() {
		List<Integer> data = Arrays.asList(21, 22, 23, 24, 25);
		return Flux.fromStream(data.stream());
	}

	public static Integer[] getData() {
		System.out.println("===== Into Method that prepares data ====");
		return new Integer[] { 11, 12, 13, 14, 15 };
	}
}
