package com.nisum.operators.error;

import com.nisum.util.SubscriberUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ErrorOperators {

	public static void main(String[] args) {
		
		errorEvent();

//		Fallback value example 
//		onErrorReturnWithTryCatch();
//		onErrorReturn();
//		onErrorReturnWithPredicate();

//		onErrorResumeTryCatch();
//		onErrorResume();
//		onErrorResumeWithPredicate();

		throwBusinessExceptionWithTryCatch();
		throwBusinessExceptionUsingError();

		onErrorMapForBusinessException();

	}

	public static void errorEvent() {

		Flux.just(1, 2, 3, 4).map(n -> {
				if (n == 2)
					throw new RuntimeException("Sample Message");
				return n;
			})
			.onErrorMap(ex -> new RuntimeException("Modified"))

			.onErrorReturn(10)

			.onErrorResume(ex -> {
				return Flux.just(50, 60, 70);
			})

			.subscribe(SubscriberUtil.getSubscriber());

	}

	private static void onErrorMapForBusinessException() {
		Mono<String> myMono = Mono.just("myMessage").map(myMessage -> getFromExternalService(myMessage, true))
//				We are converting the existing runtime exception to MyBusinessException 	
				.onErrorMap(runtimeEx -> new MyBusinessException());
		myMono.subscribe(null,
				exception -> System.out.println("throwBusinessExceptionUsingError -- " + exception.getMessage()));
	}

	private static void throwBusinessExceptionWithTryCatch() {
		try {
			getBusinessException("myMessage");
		} catch (MyBusinessException exception) {
			System.out.println("throwBusinessExceptionWithTryCatch -- " + exception.getMessage());
		}
	}

	private static void throwBusinessExceptionUsingError() {
		Mono<String> myMono = Mono.just("myMessage").map(myMessage -> getFromExternalService(myMessage, true))
//			We are converting the existing runtime exception to MyBusinessException 	
				.onErrorResume(runtimeEx -> Mono.error(new MyBusinessException()));
		myMono.subscribe(null,
				exception -> System.out.println("throwBusinessExceptionUsingError -- " + exception.getMessage()));
	}

	private static String getBusinessException(String myMessage) {

		String myString = "empty";
		try {
			myString = getFromExternalService("My message", true);
		} catch (Exception e) {
			throw new MyBusinessException();
		}
		return myString;

	}

// Return the publisher..
	private static void onErrorResume() {
		String key = "on-resume-invocation";
		Mono.just(key).map(message -> getFromExternalService(message, true))
				.onErrorResume(exception -> Mono.just(getFromLocalCache(key))).subscribe(System.out::println);
	}

	private static void onErrorResumeWithPredicate() {
		String key = "on-resume-invocation-with-predicate";
		Mono.just(key).map(message -> getFromExternalService(message, true))
				.onErrorResume(ArithmeticException.class, exception -> Mono.just(getFromLocalCache(key)))
				.onErrorResume(RuntimeException.class, exception -> Mono.just(getFromLocalCache(key)))
				.subscribe(System.out::println);
	}

	private static void onErrorResumeTryCatch() {
		String message = "try-catch-invocation";
		try {
			message = getFromExternalService(message, true);
		} catch (Exception e) {
			message = getFromLocalCache(message);
		}
		System.out.println(message);

	}

	private static String getFromLocalCache(String message) {
		return message + " -- The Data is coming from local cache..";
	}

	private static String getFromExternalService(String message, boolean isThrowException) {
		if (isThrowException) {
			throw new RuntimeException("Error in retrieving the data from external service");
		}
		return "The message is from external service";
	}

	private static String onErrorReturnWithTryCatch() {
		String myFallbackValue = "";
		try {
			throwErrorOnSix(6);
		} catch (Throwable error) {
			myFallbackValue = "onErrorReturnWithTryCatch -- Oops! some thing happen...";
		}
		return myFallbackValue;
	}

	// Return the Object
	private static void onErrorReturn() {
		Flux<String> fluxMessage = Flux.range(0, 7).map(ErrorOperators::throwErrorOnSix)
				.onErrorReturn("onErrorReturn -- Oops! some thing happen...");
		fluxMessage.subscribe(System.out::println);
	}

	private static void onErrorReturnWithPredicate() {
		Flux<String> fluxMessage = Flux.range(0, 7).map(ErrorOperators::throwErrorOnSix)
				.onErrorReturn(ArithmeticException.class,
						"onErrorReturnWithPredicate Arthematic-- Oops! some thing happen...")
				.onErrorReturn(RuntimeException.class,
						"onErrorReturnWithPredicate Runtime-- Oops! some thing happen...");
		fluxMessage.subscribe(System.out::println);
	}

	private static String throwErrorOnSix(int count) {
		if (count == 6) {
			throw new RuntimeException("Some random exception");
		}
		return "Everything-Working-Fine";
	}

}
