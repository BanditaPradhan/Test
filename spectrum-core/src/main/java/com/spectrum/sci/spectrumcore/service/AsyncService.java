package com.spectrum.sci.spectrumcore.service;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spectrum.sci.spectrumcore.account.model.AccountRequest;
import com.spectrum.sci.spectrumcore.account.model.AccountResponse;
import com.spectrum.sci.spectrumcore.config.ApplicationPropertyReader;
import com.spectrum.sci.spectrumcore.customer.model.CustomerRequest;
import com.spectrum.sci.spectrumcore.customer.model.CustomerResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AsyncService {
	
	@Autowired
	RestTemplate restTemplate;

	@Async("asyncExecutor")
	public CompletableFuture<CustomerResponse> getCustomerServiceAsync(CustomerRequest customerRequest) throws InterruptedException {

		 log.info("At GetCustomer ..." );
		 HttpHeaders headers  = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	     
		 HttpEntity<CustomerRequest> requestEntity =
				 new HttpEntity<>(customerRequest, headers);
		 
		 log.debug("Request = " + customerRequest.toString());	
		 log.debug("requestEntity = " + requestEntity.getBody().getGetCustomerRequest().toString());
		
		 CustomerResponse response = 
				 restTemplate.exchange(ApplicationPropertyReader.spcCustomerUrl, HttpMethod.POST, requestEntity,CustomerResponse.class).getBody();
		 Thread.sleep(1000L);
		 
		 return CompletableFuture.completedFuture(response);
	}

	@Async("asyncExecutor")
	public CompletableFuture<AccountResponse> getAccountServiceAsync(AccountRequest accountRequest) throws InterruptedException {
		 
		 log.info("At GetAccount..." );
		 HttpHeaders headers  = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	     
		 HttpEntity<AccountRequest> requestEntity =
				 new HttpEntity<>(accountRequest, headers);
		 
		 log.debug("Request = " + accountRequest.toString());	
		 log.debug("requestEntity = " + requestEntity.getBody().getGetAccountRequest().toString());
		
		 AccountResponse response = 
				 restTemplate.exchange(ApplicationPropertyReader.spcAccountUrl, HttpMethod.POST, requestEntity,AccountResponse.class).getBody();
		 Thread.sleep(1000L);
		 
		 return CompletableFuture.completedFuture(response); 
	}

}
