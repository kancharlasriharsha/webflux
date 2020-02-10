package com.nisum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.domain.Order;
import com.nisum.service.OrderService;

import reactor.core.publisher.Mono;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping(value = "get-order", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Order> getOrder() {
		
		System.out.println("Controller - S.O.P - 1");
		
		Mono<Order> mono = orderService.getOrder().map(order -> {
			System.out.println("Controller - S.O.P - 2");
			return order;
		});
		
		System.out.println("Controller - S.O.P - 3");
		return mono;
	}
}
