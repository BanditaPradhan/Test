package com.spectrum.sci.spectrumcore.customer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(Include.NON_NULL)
public class GetCustomerRequest {
	private String systemID;
	@JsonProperty(required=false)
	private String uCAN;
	@JsonProperty(required=false)
	private String divisionID;	
	private String accountNumber;
	@JsonProperty(required=false)
	private String customerNumber;
	@JsonProperty(required=false)
	private String soloAccountNumber;

}
