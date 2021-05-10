package com.spectrum.sci.completeorder.db.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PackDataBaseConfig {
	
	@Bean(name="packDataSource")
	public DataSource packDataSource(
			@Value("${pack.database.driver.class}") String packDbDriverClassName,
			@Value("${pack.database.url}") String packDbUrl,
			@Value("${pack.database.username}") String packDbUsername,
			@Value("${pack.database.password}") String packDbPassword
			) {
		
		DataSource ds = DataSourceBuilder.create()
				      .driverClassName(packDbDriverClassName)
				      .url(packDbUrl)
				      .username(packDbUsername)
				      .password(packDbPassword)
				      .build();
		
		/*
		com.zaxxer.hikari.HikariDataSource hikariDs = new com.zaxxer.hikari.HikariDataSource();
		hikariDs.setDataSource(ds);
		hikariDs.setConnectionTestQuery("select 1 from dual"); */
	
		return ds;
	}
}
