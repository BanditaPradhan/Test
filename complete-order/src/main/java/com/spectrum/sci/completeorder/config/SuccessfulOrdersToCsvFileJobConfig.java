package com.spectrum.sci.completeorder.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.spectrum.sci.completeorder.model.Order;
import com.spectrum.sci.completeorder.processor.OrderWriter;

@Configuration
public class SuccessfulOrdersToCsvFileJobConfig {
	private static Logger log = LoggerFactory.getLogger("SuccessfulOrdersToCsvFileJobConfig.class");
	
	@Bean
	public FlatFileItemWriter<Order> successfulDatabaseCsvItemWriter() {
		log.info("Entering SuccessfulOrdersToCsvFileJobConfig...");
		FlatFileItemWriter<Order> csvFileWriter = new FlatFileItemWriter<>();
		
		String exportFileHeader = "OrderId";
		OrderWriter headerWriter = new OrderWriter(exportFileHeader);
		csvFileWriter.setHeaderCallback(headerWriter);
		
		String exportFilePath = "/tmp/SuccessOrderIdForCompletion.csv";
		csvFileWriter.setResource(new FileSystemResource(exportFilePath));
		
		LineAggregator<Order> lineAggregator = createOrderLineAggregator();
		csvFileWriter.setLineAggregator(lineAggregator);
		
		return csvFileWriter;
		
	}
	
	private LineAggregator<Order> createOrderLineAggregator() {
		log.info("Entering createOrderLineAggregator...");
		DelimitedLineAggregator<Order> lineAggregator = new DelimitedLineAggregator<>();
		lineAggregator.setDelimiter(";");
		
		FieldExtractor<Order> fieldExtractor = createOrderFieldExtractor();
		lineAggregator.setFieldExtractor(fieldExtractor);
		
		return lineAggregator;
	}
	
	private FieldExtractor<Order> createOrderFieldExtractor() {
		log.info("Entering createOrderFieldExtractor...");
		BeanWrapperFieldExtractor<Order> extractor = new BeanWrapperFieldExtractor<>();
		extractor.setNames(new String[] {"orderId"});
		return extractor;
	}
}