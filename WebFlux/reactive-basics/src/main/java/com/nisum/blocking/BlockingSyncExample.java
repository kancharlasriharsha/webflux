package com.nisum.blocking;

import org.springframework.web.client.RestTemplate;

import com.nisum.domain.Order;

public class BlockingSyncExample {

	public static void main(String[] args) {

		final String uri = "http://localhost:8883/order-details";
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Before Calling REST service in synchronus approach");
		
		// Blocking Code
		Order order = restTemplate.getForObject(uri, Order.class);
		
		System.out.println("After Calling REST service in synchronus approach");

		System.out.println(order);
		
	}

}
