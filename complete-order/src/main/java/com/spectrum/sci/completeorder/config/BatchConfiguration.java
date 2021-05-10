package com.spectrum.sci.completeorder.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spectrum.sci.completeorder.Exception.OrderBatchException;
import com.spectrum.sci.completeorder.listener.JobCompletionNotificationListner;
import com.spectrum.sci.completeorder.model.Order;
import com.spectrum.sci.completeorder.processor.OrderClassifier;
import com.spectrum.sci.completeorder.processor.OrderProcessor;
import com.spectrum.sci.completeorder.repository.OrderRowMapper;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration  {
	
  @Autowired
  public JobBuilderFactory jobBuilderFactory;
  
  @Autowired
  public StepBuilderFactory stepBuilderFactory;
  
  @Autowired
  private DatabaseReaderJobConfig databaseReaderJobConfig;
  
  @Autowired
  private DatabaseToCsvFileJobConfig databaseToCsvFileJobConfig;
  
  @Autowired
  SuccessfulOrdersToCsvFileJobConfig successfulOrdersToCsvFileJobConfig;
  
  @Autowired
  @Qualifier("packDataSource")
  private DataSource packDataSource;
   

  @Bean
  public ItemReader<Order> reader(){
   try {	  
	JdbcCursorItemReader<Order> itemReader = databaseReaderJobConfig.itemReader(packDataSource);
	itemReader.setRowMapper(new OrderRowMapper());	
	return itemReader ;
	} catch (UnexpectedInputException e) {
		throw new OrderBatchException("Invalid Input..." + e.getMessage());
	} catch (ParseException e) {
		throw new OrderBatchException("Parsing error..." + e.getMessage());
	} catch (NonTransientResourceException e) {
		throw new OrderBatchException("NonTransientReasource error..." + e.getMessage());
	} catch (Exception e) {
		throw new OrderBatchException("Unknown Read error..." + e.getMessage());
	}
  }
  
  @Bean
  public OrderProcessor processor() {
	  return new OrderProcessor();
  }
  
  @Bean
  public ClassifierCompositeItemWriter<Order> classifierBillerOrderCompositeItemWriter() throws Exception {
      ClassifierCompositeItemWriter<Order> compositeItemWriter = new ClassifierCompositeItemWriter<>();
      compositeItemWriter.setClassifier(new OrderClassifier(successfulOrdersToCsvFileJobConfig.successfulDatabaseCsvItemWriter(), databaseToCsvFileJobConfig.databaseCsvItemWriter()));
      return compositeItemWriter;
  }
  
  @Bean
  public Job importJobOrder(JobCompletionNotificationListner listener, Step step1) {
	  return jobBuilderFactory.get("importJobOrder")
			  .incrementer(new RunIdIncrementer())
			  .listener(listener)
			  .flow(step1)
			  .end()
			  .build(); 
  } 
  
  @Bean(name="step1")
  public Step step1() throws Exception{
	return stepBuilderFactory.get("step1")			 
				  .<Order, Order> chunk(10)
				  .reader((ItemReader<? extends Order>) reader())
				  .processor(processor())
				  .writer(classifierBillerOrderCompositeItemWriter())
				  .stream(successfulOrdersToCsvFileJobConfig.successfulDatabaseCsvItemWriter())
				  .stream(databaseToCsvFileJobConfig.databaseCsvItemWriter())
				  .build();
  }
  

}
