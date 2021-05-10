package com.spectrum.sci.completeorder.processor;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.spectrum.sci.base.model.OrderResponse;


public class OrderReader implements ItemReader<OrderResponse>{
	
	private static final Logger log = LoggerFactory.getLogger(OrderReader.class);

	private final String apiUrl;
	private final RestTemplate restTemplate;
	
	private OrderResponse orderResponse;
	
	@Autowired
	private String orderId;
	
	private String userName;
	private String password;

	
	public OrderReader(String apiUrl, String userName, String password, RestTemplate restTemplate, String orderId) {
		this.apiUrl = apiUrl;
		this.restTemplate = restTemplate;
		this.orderId = orderId;
		this.userName = userName;
		this.password = password;
	}
	
	private boolean orderisNotInitialized() {
		return this.orderResponse == null;
	}
	
	private OrderResponse fetchOrderDataFromApi(String orderId) {
		 log.info("orderId = " + orderId);
		 log.info("apiUrl = " + apiUrl); 
		 log.info("userName = " + userName);
		 
		 HttpHeaders headers  = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		 headers.setBasicAuth(userName, password);
		 
		 HttpEntity<String> requestEntity =
				 new HttpEntity<String>(orderId, headers);
		 
		 log.info("requestEntity = " + requestEntity.getBody());
		 
		 ResponseEntity<OrderResponse> response = 
				  restTemplate.exchange(apiUrl,HttpMethod.POST, requestEntity,OrderResponse.class);
		 
		 log.info("response = " + response.toString());
		 
	     OrderResponse orderResponse = response.getBody();
	     return orderResponse;
	}
	
	@Override
	public OrderResponse read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (orderisNotInitialized()) {
			orderResponse = fetchOrderDataFromApi(orderId);
		}
		
		return orderResponse;
	}

}
