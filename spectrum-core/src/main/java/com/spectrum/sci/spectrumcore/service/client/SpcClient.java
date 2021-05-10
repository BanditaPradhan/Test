package com.spectrum.sci.spectrumcore.service.client;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.spectrum.sci.spectrumcore.account.model.AccountRequest;
import com.spectrum.sci.spectrumcore.account.model.AccountResponse;
import com.spectrum.sci.spectrumcore.config.ApplicationPropertyReader;
import com.spectrum.sci.spectrumcore.customer.model.CustomerRequest;
import com.spectrum.sci.spectrumcore.customer.model.CustomerResponse;
import com.spectrum.sci.spectrumcore.exception.SpcException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SpcClient {
	
	@Autowired
	RestTemplate restTemplate;
	

	public ResponseEntity<CustomerResponse> getCustomerClient(CustomerRequest customerRequest) { 
		log.info("Entering getCustomerClient..." );		
		try {			 
			 HttpHeaders headers  = new HttpHeaders();
			 headers.setContentType(MediaType.APPLICATION_JSON);
			 headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		     
			 HttpEntity<CustomerRequest> requestEntity =
					 new HttpEntity<>(customerRequest, headers);
			 
			 log.debug("Request = " + customerRequest.toString());	
			 log.debug("requestEntity = " + requestEntity.getBody().getGetCustomerRequest().toString());
    		
			 ResponseEntity<CustomerResponse> response = 
					 restTemplate.exchange(ApplicationPropertyReader.spcCustomerUrl, HttpMethod.POST, requestEntity,CustomerResponse.class);
			 
			 if (response.getStatusCode() == HttpStatus.OK) {
				    log.debug("Post Created");
				    log.debug(response.getBody().toString());
			} else {
				    log.debug("Request Failed");
				    log.debug(response.getStatusCode().toString());
			}	
			 return response; 
		} catch( Exception e) {
			throw new SpcException("Error in SPC getCustomerClient  " + e.getMessage(), e);
		}
	 }

	public ResponseEntity<AccountResponse> getAccountClient(AccountRequest accountRequest) {
		log.info("Entering getAccountClient..." );		
		try {
			 
			 HttpHeaders headers  = new HttpHeaders();
			 headers.setContentType(MediaType.APPLICATION_JSON);
			 headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		     
			 HttpEntity<AccountRequest> requestEntity =
					 new HttpEntity<>(accountRequest, headers);
			 
			 log.debug("Request = " + accountRequest.toString());	
			 log.debug("requestEntity = " + requestEntity.getBody().getGetAccountRequest().toString());
    		
			 ResponseEntity<AccountResponse> response = 
					 restTemplate.exchange(ApplicationPropertyReader.spcAccountUrl, HttpMethod.POST, requestEntity,AccountResponse.class);
			 
			 if (response.getStatusCode() == HttpStatus.OK) {
				    log.debug("Post Created");
				    log.debug(response.getBody().toString());
			} else {
				    log.debug("Request Failed");
				    log.debug(response.getStatusCode().toString());
			}	
			 return response; 
		} catch( Exception e) {
			throw new SpcException("Error in SPC getAccountClient  " + e.getMessage(), e);
		}
	}
}
