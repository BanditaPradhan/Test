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
public class Name {
	@JsonProperty(required=false)
	private String title;
	@JsonProperty(required=false)
	private ReferenceDataType salutation;
	@JsonProperty(required=false)
	private String companyName ;
	@JsonProperty(required=false)
	private String full;
	@JsonProperty(required=false)
	private String last;
	@JsonProperty(required=false)
	private String middle;
	@JsonProperty(required=false)
	private String first;
}
