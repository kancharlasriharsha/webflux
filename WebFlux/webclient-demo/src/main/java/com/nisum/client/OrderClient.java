package com.nisum.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.nisum.domain.Order;

import reactor.core.publisher.Mono;

@Component
public class OrderClient {

	public Mono<Order> getOrder() {
		
		System.out.println("Client - S.O.P - 1");

		Mono<Order> mono = WebClient.create("http://localhost:8883").get().uri("order-details").retrieve().bodyToMono(Order.class)
				.map(order -> {
					System.out.println("Client - S.O.P - 2");
					return order;
				});
		
		System.out.println("Client - S.O.P - 3");

		return mono;
	}
}
