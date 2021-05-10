package com.spectrum.sci.completeorder.config;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.spectrum.sci.completeorder.model.Order;

@Configuration
public class DatabaseToCsvFileJobConfig {
	
	@Bean
	public FlatFileItemWriter<Order> databaseCsvItemWriter() {
		return  new FlatFileItemWriterBuilder<Order>()
	           			.name("itemWriter")
	           			.headerCallback(new FailedBillerOrderHeaderCallBack())
	           			.resource(new FileSystemResource("/tmp/FailedOrderIdForCompletion.csv"))
	           			.lineAggregator(new PassThroughLineAggregator<Order>())
	           			.build();
	}

}
