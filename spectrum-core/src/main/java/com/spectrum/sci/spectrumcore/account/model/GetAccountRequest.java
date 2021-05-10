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
public class GetAccountRequest {
	private String systemID;
	@JsonProperty(required=false)
	private String uCAN;
	@JsonProperty(required=false)
	private String divisionID;
	@JsonProperty(required=false)
	private String accountNumber;
	@JsonProperty(required=false)
	private String soloAccountNumber;
}
