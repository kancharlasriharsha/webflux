package com.nisum.blocking;

import org.springframework.web.client.RestTemplate;

import com.nisum.thread.ServiceThread;

public class BlockingAsyncExample {

	public static void main(String[] args) {
		
		final String uri = "http://localhost:8883/order-details";
		RestTemplate restTemplate = new RestTemplate();
		
		System.out.println("Before Calling REST service in asynchronus approach");
		
		new ServiceThread(uri,restTemplate).start();
		
		System.out.println("After Calling REST service in asynchronus approach");
	}

}
