package com.spectrum.sci.spectrumcore.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@NoArgsConstructor
@Slf4j
public class ApplicationPropertyReader {
	
    public static String spcCustomerUrl;
    public static String spcAccountUrl;
    
	@Value("${spc.service.customerUrl}")
	public void setSpcCustomerUrl(String spcCustomerUrl) {
		ApplicationPropertyReader.spcCustomerUrl = spcCustomerUrl;
	}
	
	@Value("${spc.service.accountUrl}")
	public void setSpcAccountUrl(String spcAccountUrl) {
		ApplicationPropertyReader.spcAccountUrl = spcAccountUrl;
	}

	@PostConstruct
	   public void init() {
	      log.info("spcCustomerUrl = " + spcCustomerUrl );
	      log.info("spcAccountUrl = " + spcAccountUrl );
	   } 

} 
