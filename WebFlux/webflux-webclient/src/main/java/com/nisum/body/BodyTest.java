package com.nisum.body;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.nisum.domain.Order;
import com.nisum.domain.OrderDetails;

import reactor.core.publisher.Mono;

public class BodyTest {
	public static void main(String[] args) {
		
		String baseUrl = "http://localhost:8883";
		String uri = "order/body";
		
		OrderDetails orderDetails = new OrderDetails("order-1-body", "completed");
		
		Mono<Order> mono = WebClient.create(baseUrl).post().uri(uri)
				.body(BodyInserters.fromObject(orderDetails)).retrieve().bodyToMono(Order.class);

		Order order = mono.block();
		
		System.out.println(order);
	}
}
