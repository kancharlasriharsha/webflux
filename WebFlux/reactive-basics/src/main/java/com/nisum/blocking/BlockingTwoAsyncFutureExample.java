package com.nisum.blocking;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.web.client.RestTemplate;

import com.nisum.domain.Order;
import com.nisum.domain.OrderStatus;

public class BlockingTwoAsyncFutureExample {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		System.out.println("main-start -- "+Thread.currentThread().getName());


		System.out.println("Before REST Call -1");

		CompletableFuture<Order> completableFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("REST CALL 1 -- "+Thread.currentThread().getName());
			final String uri = "http://localhost:8883/order-details";
			RestTemplate restTemplate = new RestTemplate();
			Order order = restTemplate.getForObject(uri, Order.class);
			System.out.println(order);
			return order;
		});
		
		System.out.println("After REST Call - 1");
		System.out.println("Before REST Call -2");

		CompletableFuture<OrderStatus> completableFutureOrderStatus = completableFuture.thenApply(order -> {
			System.out.println("REST CALL 2 -- "+Thread.currentThread().getName());
			final String uri = "http://localhost:8883/order-status/"+order.getOrderId();
			RestTemplate restTemplate = new RestTemplate();
			OrderStatus orderStatus = restTemplate.getForObject(uri, OrderStatus.class);
			System.out.println(orderStatus);
			return orderStatus;
		});
		
		System.out.println("After REST Call - 2");
		
		OrderStatus orderStatus = completableFutureOrderStatus.get();
		System.out.println(orderStatus);
		System.out.println("------End Of Main Method-----------");
		System.out.println("main-end -- "+Thread.currentThread().getName());


	}
}
