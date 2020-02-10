package com.nisum.exchange;

import org.springframework.web.reactive.function.client.WebClient;

import com.nisum.domain.Order;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ExchangeTest {

	public static void main(String[] args) {

		String baseUrl = "http://localhost:8883";
		String uri = "order-details";
		
		Mono<Order> mono = WebClient.create(baseUrl).get().uri(uri).exchange().flatMap(clientResponse -> {
			
			System.out.println("==== Status Code " + clientResponse.rawStatusCode());
			
			return clientResponse.bodyToMono(Order.class);
		});
		
		Order order = mono.block();
		System.out.println(order);
		
	}

}
