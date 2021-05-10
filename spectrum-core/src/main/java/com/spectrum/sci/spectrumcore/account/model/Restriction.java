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
public class Restriction {
	@JsonProperty(required=false)
	private ReferenceDataType type ;
	@JsonProperty(required=false)
	private String indicator ;
}
