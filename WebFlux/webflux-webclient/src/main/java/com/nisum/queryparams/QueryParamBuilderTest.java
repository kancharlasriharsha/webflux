package com.nisum.queryparams;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import com.nisum.domain.Order;

import reactor.core.publisher.Mono;

public class QueryParamBuilderTest {

	public static void main(String[] args) {

		// http://localhost:8883/order?orderId=order-10
		
		Map<String, List<String>> queryParamsMap = new HashMap<>();
		buildQueryParamMap("orderId", "order-10-queryparam-builder", queryParamsMap);
		
		String endPoint = "order";

		Mono<Order> mono = WebClient.create("http://localhost:8883")
					.get()
					.uri(uriBuilder -> buildUri(uriBuilder, endPoint, queryParamsMap))
					.retrieve()
					.bodyToMono(Order.class);
		
		Order order = mono.block();
		System.out.println(order);
	}

	public static URI buildUri(UriBuilder uriBuilder, String uri, Map<String, List<String>> queryParams) {
		
		UriBuilder builder = uriBuilder.path(uri);
		MultiValueMap<String, String> queryParamsMap = new LinkedMultiValueMap<>(queryParams);
		
		if (queryParams != null) {
			builder.queryParams(new LinkedMultiValueMap<>(queryParamsMap));
		}
		return builder.build();
	}
	
	public static void buildQueryParamMap(String queryParam, String value, Map<String, List<String>> queryParamsMap) {
		List<String> orderIds = new ArrayList<>();
		orderIds.add(value);
		queryParamsMap.put(queryParam, orderIds);
	}
}
