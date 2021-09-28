package com.spectrum.sci.spectrumcore.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Getter
@Setter
@ToString
@Slf4j
public class ApplicationPropertyReader {
	
    @Value("${spc.service.customerUrl}")
    private String spcCustomerUrl;
	
    @Value("${spc.service.accountUrl}")
    private String spcAccountUrl;
   
    @PostConstruct
    public void init() {
      log.info("spcCustomerUrl = " + spcCustomerUrl );
      log.info("spcAccountUrl = " + spcAccountUrl );
    } 

} 
