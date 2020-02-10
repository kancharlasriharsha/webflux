package com.nisum.webclient;

import java.time.Duration;

import org.springframework.web.reactive.function.client.WebClient;

import com.nisum.domain.Order;

import reactor.core.publisher.Flux;

public class WebClientTest {
	public static void main(String[] args) throws InterruptedException {
		Flux<Order> orders = WebClient.create("http://localhost:8883/order-list/reactive").get().retrieve().bodyToFlux(Order.class).timeout(Duration.ofMillis(1000*100));
		orders.subscribe(new OrderSubscriber());
		Thread.sleep(1000*100);
	}
}
