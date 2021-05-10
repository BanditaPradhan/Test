package com.spectrum.sci.completeorder.config;

import org.springframework.batch.item.file.transform.LineAggregator;

public class PassThroughLineAggregator<Order> implements LineAggregator<Order> {

		@Override
		public String aggregate(Order order) {
			String orderResponse = order.toString();
			orderResponse = orderResponse.replaceAll("Order", "");
			orderResponse = orderResponse.replaceAll("orderId=", "");
			orderResponse = orderResponse.replaceAll("errorMessage=", "");
			orderResponse = orderResponse.replaceAll("successMessage=null", "");
			orderResponse = orderResponse.replaceAll("result=FAILED", "");
			orderResponse = orderResponse.replaceAll("\\(", "");
			orderResponse = orderResponse.replaceAll("\\)", "");			
			return orderResponse;
		}
		
		
}
