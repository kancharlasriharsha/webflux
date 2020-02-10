package com.nisum;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import reactor.core.publisher.Mono;
import reactor.util.function.Tuple3;

public class App {
	public static void main(String[] args) throws InterruptedException {

		
		
		Mono<List<Item>> items = Mono.fromSupplier(() -> {
			
			System.out.println("-------- into supplier");
			final String uri = "http://localhost:8883/items";
			RestTemplate restTemplate = new RestTemplate();
			return Arrays.asList(restTemplate.getForObject(uri, Item[].class));
		});
		
		System.out.println("----- Calling second service");
		
		Mono<Address> address = Mono.fromSupplier(() -> {
			final String uri = "http://localhost:8883/address";
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForObject(uri, Address.class);
		});
		
		Mono<OrderDetails> orderDetails = Mono.fromSupplier(() -> {
			final String uri = "http://localhost:8883/ord-dtls";
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForObject(uri, OrderDetails.class);
		});
		

		Mono<Tuple3<OrderDetails, Address, List<Item>>> zip = Mono.zip(orderDetails, address, items);
		
		Mono<Order> order = zip.map(mapper -> {
			OrderDetails od = mapper.getT1();
			Address ad = mapper.getT2();
			List<Item> its = mapper.getT3();
			return new Order(od.getOrderId(), its, ad);
		});

		order.subscribe(new OrderSubscriber());

	}
}
