package com.nisum.thread;

import org.springframework.web.client.RestTemplate;

import com.nisum.domain.Order;

public class ServiceThread extends Thread{
	
	String uri;
	RestTemplate restTemplate;
	
	public ServiceThread(String uri, RestTemplate restTemplate) {
		super();
		this.uri = uri;
		this.restTemplate = restTemplate;
	}


	@Override
	public void run() {
		Order order = restTemplate.getForObject(uri, Order.class);
		System.out.println(order);
	}

}
