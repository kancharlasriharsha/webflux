package com.nisum.headers;

import org.springframework.web.reactive.function.client.WebClient;

import com.nisum.domain.Order;

import reactor.core.publisher.Mono;

public class HeadersTest {

	public static void main(String[] args) {

		// http://localhost:8883/order/header
		String endPoint = "order/header";

		Mono<Order> mono = WebClient.create("http://localhost:8883")
					.get()
					.uri(endPoint)
					.header("orderId", "order-12-header")
					.retrieve().bodyToMono(Order.class);;

		Order order = mono.block();
		System.out.println(order);

	}
	
}
