package com.nisum.urivariables;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import com.nisum.domain.Order;

import reactor.core.publisher.Mono;

public class UriVariablesBuilderTest {
	public static void main(String[] args) {
		
		// http://localhost:8883/order/order-11

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("orderId", "order-11-uribuilder");

		String endPoint = "order/{orderId}";

		Mono<Order> mono = WebClient.create("http://localhost:8883").get()
				.uri(uriBuilder -> buildUri(uriBuilder, endPoint, uriVariables)).retrieve().bodyToMono(Order.class);

		Order order = mono.block();
		System.out.println(order);

	}

	public static URI buildUri(UriBuilder uriBuilder, String uri, Map<String, String> uriVariables) {
		
		UriBuilder builder = uriBuilder.path(uri);

		if (uriVariables != null) {
			return builder.build(uriVariables);
		}
		
		return builder.build();
	}
}
