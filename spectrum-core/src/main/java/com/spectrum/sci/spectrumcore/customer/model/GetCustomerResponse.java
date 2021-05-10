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
public class GetCustomerResponse {
	@JsonProperty(required=false)
	private Customer customer;
	@JsonProperty(required=false)
	private String uCAN;
	@JsonProperty(required=false)
	private String sourceSystemTimeZone;
}
