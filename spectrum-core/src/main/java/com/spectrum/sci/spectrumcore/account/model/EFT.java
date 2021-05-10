package com.spectrum.sci.spectrumcore.account.model;

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
public class EFT {
	@JsonProperty(required=false)
	private String routingNumber ;
	@JsonProperty(required=false)
	private String accountNumber ;
	@JsonProperty(required=false)
	private String accountType ;
}
