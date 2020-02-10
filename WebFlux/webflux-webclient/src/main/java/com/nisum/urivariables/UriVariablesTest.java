package com.nisum.urivariables;

import org.springframework.web.reactive.function.client.WebClient;

import com.nisum.domain.Order;

import reactor.core.publisher.Mono;

public class UriVariablesTest {
	
	public static void main(String[] args) {
		
		// http://localhost:8883/order/order-9
		
		String uriVariableValue = "order-9-urivariable";

		String endPoint = String.format("order/%s", uriVariableValue);
		
		System.out.println(endPoint);
		
		Mono<Order> mono = WebClient.create("http://localhost:8883").get().uri(endPoint).retrieve()
				.bodyToMono(Order.class);

		Order order = mono.block();
		System.out.println(order);
	}

}
