package com.nisum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.client.OrderClient;
import com.nisum.domain.Order;

import reactor.core.publisher.Mono;

@Service
public class OrderService {

	@Autowired
	private OrderClient orderClient;

	public Mono<Order> getOrder() {

		System.out.println("Service - S.O.P - 1");

		Mono<Order> mono = orderClient.getOrder().map(order -> {
			System.out.println("Service - S.O.P - 2");

			return order;
		});
		
		System.out.println("Service - S.O.P - 3");
		return mono;
	}
}
