package com.spectrum.sci.completeorder.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.classify.Classifier;

import com.spectrum.sci.completeorder.model.Order;

public class OrderClassifier implements Classifier<Order, ItemWriter<? super Order>> {
	
	private static final Logger log = LoggerFactory.getLogger("OrderClassifier.class");
 
    private static final long serialVersionUID = 1L;
     
    private ItemWriter<Order> successItemWriter;
    private ItemWriter<Order> failedItemWriter;
 
    public OrderClassifier(ItemWriter<Order> successItemWriter, ItemWriter<Order> failedItemWriter) {
        this.successItemWriter = successItemWriter;
        this.failedItemWriter = failedItemWriter;
    }
 
    @Override
    public ItemWriter<? super Order> classify(Order order) {  
    	    log.info("Order = " + order.toString());
    		return order.getResult().equals("SUCCESS") ? successItemWriter : failedItemWriter;
    }

}
