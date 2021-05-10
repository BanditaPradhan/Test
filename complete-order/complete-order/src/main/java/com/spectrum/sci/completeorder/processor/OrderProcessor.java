package com.spectrum.sci.completeorder.processor;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.spectrum.sci.base.model.OrderResponse;
import com.spectrum.sci.completeorder.model.Order;

public class OrderProcessor implements ItemProcessor<Order, Order>{
	
	private static final Logger log = LoggerFactory.getLogger("OrderProcessor.class");
	
	@Value("${osm.service.url}")
	private String orderUrl; 
	
	@Value("${osm.service.username}")
	private String userName;
	
	@Value("${osm.service.password}")
	private String password;
		
	@Autowired
	RestTemplate restTemplate;

	@Override
	public Order process(Order order) throws Exception {	 
		  log.info("Entering process with orderId = " + order.getOrderId() );
		  OrderReader osmReader = new OrderReader(orderUrl, userName, password, restTemplate, order.getOrderId());	
		  OrderResponse orderResponse = osmReader.read();	 
			  
		  if (orderResponse.getResult() != null) {
			  log.info("result = " + orderResponse.getResult());
			  if (orderResponse.getResult().equals("SUCCESS") ) {
				  order.setSuccessMessage(orderResponse.getSuccessMessage()); 
			  } else if (orderResponse.getResult().equals("FAILED") ) {
				  log.info("Error Message = " + orderResponse.getErrorMessage());				 
				  order.setErrorMessage(orderResponse.getErrorMessage());
			  } 
		  } else {
			  order.setErrorMessage("Result is null - please check");
		  }
		  order.setOrderId(orderResponse.getOrderId());
		  order.setResult(orderResponse.getResult());
		  return order;
	}

	

}
