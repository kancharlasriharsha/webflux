package com.nisum.queryparams;

import org.springframework.web.reactive.function.client.WebClient;

import com.nisum.domain.Order;

import reactor.core.publisher.Mono;

public class QueryParamTest {
	public static void main(String[] args) {
		
		// http://localhost:8883/order?orderId=order-10

		String queryParamName = "orderId";
		String queryParamValue = "order-10-queryparam";

		String endPoint = String.format("order?%s=%s", queryParamName, queryParamValue);

		Mono<Order> mono = WebClient.create("http://localhost:8883").get().uri(endPoint).retrieve()
				.bodyToMono(Order.class);

		Order order = mono.block();
		System.out.println(order);
		
	}
}
