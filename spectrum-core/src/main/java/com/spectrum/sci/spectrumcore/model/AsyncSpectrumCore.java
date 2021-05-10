package com.spectrum.sci.spectrumcore.model;

import com.spectrum.sci.spectrumcore.account.model.AccountResponse;
import com.spectrum.sci.spectrumcore.customer.model.CustomerResponse;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AsyncSpectrumCore {
	
	private CustomerResponse customerResponse;
	private AccountResponse accountResponse;

}
