package com.nisum.operators.create.mono;

import java.util.Optional;

import com.nisum.util.SubscriberUtil;

import reactor.core.publisher.Mono;

public class CreatingMono {

	public static void main(String[] args) throws InterruptedException {

		Mono<Integer> mono = null;

//		mono = justWithSomeValues();
		mono = justByCallingAMethod();
//		mono = fromRunnable();
//		mono = justOrEmptyWithOptional(true);
//		mono = justOrEmptyWithOptional(false);
//		mono = justOrEmptyWithValue(10);
//		mono = justOrEmptyWithValue(null);
//		mono = fromCallable();
//		mono = Mono.empty();

		System.out.println("==== Before subscribe ====");
		
		mono.subscribe(SubscriberUtil.getSubscriber());
		
	}

	public static Mono<Integer> justWithSomeValues() {
		return Mono.just(1);
	}

	public static Mono<Integer> justByCallingAMethod() {
		return Mono.just(getData());
	}

	public static Mono<Integer> fromRunnable() {
		
		return Mono.fromRunnable(() -> {
			try {
				Thread.sleep(1000 * 5L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("==== End Of run method ====");
		});
	}

	public static Mono<Integer> justOrEmptyWithOptional(boolean flag) {
		return flag ? Mono.justOrEmpty(Optional.of(1)) : Mono.justOrEmpty(Optional.empty());
	}

	public static Mono<Integer> justOrEmptyWithValue(Integer value) {
		return Mono.justOrEmpty(value);
	}

	public static Mono<Integer> fromCallable() {
		return Mono.fromCallable(() -> {
			System.out.println("==== Getting data from Callable ====");
			return 20;
		});
	}

	public static int getData() {
		System.out.println("===== Into Method that prepares data ====");
		return 1;
	}

}
