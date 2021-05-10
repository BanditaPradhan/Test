package com.spectrum.sci.completeorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan("com.spectrum.sci.completeorder")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CompleteOrderApplication {
     
	public static void main(String[] args) {
		SpringApplication.run(CompleteOrderApplication.class, args);
	}
	
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	} 

}
