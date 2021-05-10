package com.spectrum.sci.spectrumcore.controllers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spectrum.sci.spectrumcore.account.model.AccountRequest;
import com.spectrum.sci.spectrumcore.account.model.AccountResponse;
import com.spectrum.sci.spectrumcore.account.model.GetAccountRequest;
import com.spectrum.sci.spectrumcore.customer.model.CustomerRequest;
import com.spectrum.sci.spectrumcore.customer.model.CustomerResponse;
import com.spectrum.sci.spectrumcore.customer.model.GetCustomerRequest;
import com.spectrum.sci.spectrumcore.model.AsyncSpectrumCore;
import com.spectrum.sci.spectrumcore.service.AsyncService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AsyncController {
	
	@Autowired
	AsyncService asyncService;
	
	@GetMapping("/testAsync") 
	public AsyncSpectrumCore getCustomerAccount(@RequestParam("systemID") String systemID,
			 									@RequestParam("divisionID") String divisionID,
			 									@RequestParam("accountNumber") String accountNumber
			) throws InterruptedException, ExecutionException {
		
		log.info("At GetCustomerAccount..." );
				
		CustomerRequest customerRequest = new CustomerRequest();		
		GetCustomerRequest getCustomerRequest = new GetCustomerRequest();
		getCustomerRequest.setSystemID(systemID);
		getCustomerRequest.setDivisionID(divisionID);
		getCustomerRequest.setAccountNumber(accountNumber);
		customerRequest.setGetCustomerRequest(getCustomerRequest);
		
		CompletableFuture<CustomerResponse> customerResponse = asyncService.getCustomerServiceAsync(customerRequest);
		
		AccountRequest accountRequest = new AccountRequest();		
		GetAccountRequest getGetAccountRequest = new GetAccountRequest();
		getGetAccountRequest.setSystemID(systemID);
		getGetAccountRequest.setDivisionID(divisionID);
		getGetAccountRequest.setAccountNumber(accountNumber);
		accountRequest.setGetAccountRequest(getGetAccountRequest);
		
		CompletableFuture<AccountResponse> accountResponse = asyncService.getAccountServiceAsync(accountRequest);
		
		CompletableFuture.allOf(customerResponse, accountResponse).join();
		
		CustomerResponse finalCustomerResponse = customerResponse.get();
		AccountResponse finalAccountResponse = accountResponse.get();
		
		log.info("customer response = " + customerResponse.get() );
		log.info("Account response = " + accountResponse.get() );
		
		AsyncSpectrumCore asyncSpectrumCore = new AsyncSpectrumCore();
		asyncSpectrumCore.setAccountResponse(finalAccountResponse);
		asyncSpectrumCore.setCustomerResponse(finalCustomerResponse);
		
		return asyncSpectrumCore;
	}

}
