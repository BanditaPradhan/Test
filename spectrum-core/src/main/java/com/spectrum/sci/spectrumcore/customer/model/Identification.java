package com.spectrum.sci.spectrumcore.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(Include.NON_NULL)
public class Identification {
	@JsonProperty(required=false)
	private String taxIdentifier;
	@JsonProperty(required=false)
	private String taxType;
	@JsonProperty(required=false)
	private String birthdate;
	@JsonProperty(required=false)
	private String driversLicenseNumber;
	@JsonProperty(required=false)
	private String driversLicenseState;
}
