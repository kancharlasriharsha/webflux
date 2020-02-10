package com.nisum.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.domain.Address;
import com.nisum.domain.Item;
import com.nisum.domain.Order;
import com.nisum.domain.OrderDetails;
import com.nisum.domain.OrderStatus;
import com.nisum.repo.OrderRepo;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@RestController
public class OrderController {

	@GetMapping(value = "order-details", produces = MediaType.APPLICATION_JSON_VALUE)
	public Order getOrder() throws InterruptedException {
		System.out.println("Received Request for Order Details");
		//Thread.sleep(1000 * 20);
		return OrderRepo.getOrder();
	}

	@GetMapping(value = "order-status/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderStatus getOrderStatus(@PathVariable String orderId) {
		System.out.println("Received Request for Order Status");
		return new OrderStatus(orderId, "Success");
	}

	@GetMapping(value = "order-list/blocking", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Order> getOrderList() throws InterruptedException {
		
		System.out.println("Received Request for Orders - Blocking");

		List<Order> orderList = new ArrayList<>();
		for (int i = 1; i <= 15; i++) {
			orderList.add(OrderRepo.getOrderById("order" + i));
		}
		Thread.sleep(1000 * 30);
		return orderList;
	}

	@GetMapping(value = "order-list/reactive", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Order> getOrderFlux() throws InterruptedException {
		
		System.out.println("Received Request for Orders - Reactive");

		List<Order> orderList = new ArrayList<>();
		for (int i = 1; i <= 15; i++) {
			orderList.add(OrderRepo.getOrderById("order-" + i));
		}
		return Flux.fromIterable(orderList).delayElements(Duration.ofMillis(1000*2), Schedulers.newSingle("order"));
	}
	
	
	@GetMapping(value = "items", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getItemList() throws InterruptedException {
		System.out.println("Received Request for Items");
		Thread.sleep(1000*5);
		return OrderRepo.getItems();
	}
	
	@GetMapping(value = "address", produces = MediaType.APPLICATION_JSON_VALUE)
	public Address getAddress() throws InterruptedException {
		System.out.println("Received Request for Address");
		Thread.sleep(1000*4);
		return OrderRepo.getAddress();
	}
	
	@GetMapping(value = "ord-dtls", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDetails getOrderDetails() throws InterruptedException {
		System.out.println("Received Request for Order Details");
		Thread.sleep(1000*3);
		return OrderRepo.getOrderDetails();
	}
	
	@GetMapping(value = "order", produces = MediaType.APPLICATION_JSON_VALUE)
	public Order getOrderQP(@RequestParam String orderId) {
		
		System.out.println("==== Received Query Param : "+orderId+" =====");
		return OrderRepo.getOrderById(orderId);
	}
	
	@GetMapping(value = "order/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Order getOrderUP(@PathVariable String orderId) {
		System.out.println("==== Received Path(Url) Param : "+orderId+" =====");
		return OrderRepo.getOrderById(orderId);
	}
	
	
	@PostMapping(value = "order/body", produces = MediaType.APPLICATION_JSON_VALUE)
	public Order getOrderBody(@RequestBody OrderDetails orderDetails) {
		System.out.println("==== Received Body : "+orderDetails.getOrderId()+" =====");
		return OrderRepo.getOrderById(orderDetails.getOrderId());
	}
	
	
	@GetMapping(value = "order/header", produces = MediaType.APPLICATION_JSON_VALUE)
	public Order getOrderHeader( @RequestHeader HttpHeaders headers) {
		String orderId = headers.getFirst("orderId");
		System.out.println("==== Received Header  : "+orderId+" =====");
		return OrderRepo.getOrderById(orderId);
	}
}
