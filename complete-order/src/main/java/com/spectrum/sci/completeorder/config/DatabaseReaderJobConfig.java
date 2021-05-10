package com.spectrum.sci.completeorder.config;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.spectrum.sci.completeorder.model.Order;
import com.spectrum.sci.completeorder.repository.OrderIdRepository;

@Configuration
public class DatabaseReaderJobConfig {

	   @Autowired
	   OrderIdRepository orderIdRepository;
	   	   
	   @Bean	
	   public JdbcCursorItemReader<Order> itemReader(DataSource dataSource) {
		   return new JdbcCursorItemReaderBuilder<Order>()
				      .name("cursorItemReader")
				      .dataSource(dataSource)
				      .sql(orderIdRepository.getOrderIds())
				      .rowMapper(new BeanPropertyRowMapper<>(Order.class))
				      .build();
		   
	   }
}
