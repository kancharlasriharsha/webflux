package com.nisum.util;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.nisum.domain.Address;

public class SubscriberUtil {

	public static Subscriber<Integer> getSubscriber() {

		return new Subscriber<Integer>() {

			@Override
			public void onSubscribe(Subscription s) {
				s.request(1000);
				System.out.println("==== Received onSubscribe event/notification ====");
			}

			@Override
			public void onNext(Integer t) {
				//sleep();
				System.out.println(String.format("==== Received onNext event/notification with value %d ====", t));
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("==== Received Error event/notification ===="+t.getMessage());

			}

			@Override
			public void onComplete() {
//				System.out.print(10/0);
				System.out.println("==== Received onComplete event/notification ====");
			}

			private void sleep() {
				try {
					Thread.sleep(1000 * 2L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
	}

	public static Subscriber<String> getStrSubscriber() {

		return new Subscriber<String>() {

			@Override
			public void onSubscribe(Subscription s) {
				s.request(1000);
				System.out.println("**** Received onSubscribe event/notification ****");
			}

			@Override
			public void onNext(String t) {
				System.out.println(String.format("**** Received onNext event/notification with value %s ****", t));

			}

			@Override
			public void onError(Throwable t) {
				System.out.println("**** Received Error event/notification ****");

			}

			@Override
			public void onComplete() {
				System.out.println("**** Received onComplete event/notification ****");
			}

		};
	}
	
	public static Subscriber<Address> getAddrSubscriber() {
		return new Subscriber<Address>() {

			@Override
			public void onSubscribe(Subscription s) {
				s.request(1000);
				System.out.println("$$$$ Received onSubscribe event/notification $$$$");				
			}

			@Override
			public void onNext(Address t) {
				System.out.println(String.format("$$$$ Received onNext event/notification with value %s $$$$", t.getAddress()));
				
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("$$$$ Received Error event/notification $$$$");
			}

			@Override
			public void onComplete() {
				System.out.println("$$$$ Received onComplete event/notification $$$$");
			}
		};
	}
}
