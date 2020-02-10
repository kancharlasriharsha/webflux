package com.nisum.webclient;

import org.springframework.web.reactive.function.client.WebClient;

import com.nisum.domain.Order;
import com.nisum.subscribers.OrderSubscriber;

import reactor.core.publisher.Flux;

public class WebClientTest {
	public static void main(String[] args) throws InterruptedException {
	
		String baseUrl = "http://localhost:8883";
		String uri = "order-list/reactive";
		WebClient webClient = WebClient.create(baseUrl);
		Flux<Order> orders = webClient.get().uri(uri).retrieve().bodyToFlux(Order.class);
		orders.subscribe(new OrderSubscriber());
		
		Thread.sleep(1000*100);
	}
}
