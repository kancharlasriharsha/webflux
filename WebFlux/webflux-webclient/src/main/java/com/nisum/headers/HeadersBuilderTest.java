package com.nisum.headers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import com.nisum.domain.Order;

import reactor.core.publisher.Mono;

public class HeadersBuilderTest {

	public static void main(String[] args) {

		// http://localhost:8883/order/header

		Map<String, List<String>> headersMap = new HashMap<>();
		buildHeaderMap("orderId", "order-13-header-builder", headersMap);

		MultiValueMap<String, String> multiValueHeaderMap = new LinkedMultiValueMap<>(headersMap);

		String endPoint = "order/header";

		Mono<Order> mono = WebClient.create("http://localhost:8883")
					.get()
					.uri(endPoint)
					
					.headers(headersConsumer -> {
							headersConsumer.addAll(multiValueHeaderMap);
						})
					
					.retrieve().bodyToMono(Order.class);;


		Order order = mono.block();
		System.out.println(order);

	}
	

	public static void buildHeaderMap(String headerName, String headerValue, Map<String, List<String>> headerMap) {
		List<String> orderIds = new ArrayList<>();
		orderIds.add(headerValue);
		headerMap.put(headerName, orderIds);
	}

}
