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
public class Address {
	@JsonProperty(required=false)
	private String line1;
	@JsonProperty(required=false)
	private String line2;
	@JsonProperty(required=false)
	private String city;
	@JsonProperty(required=false)
	private String state;
	@JsonProperty(required=false)
	private String postalCode;
}
