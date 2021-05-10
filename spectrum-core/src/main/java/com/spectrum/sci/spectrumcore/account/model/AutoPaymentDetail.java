package com.spectrum.sci.spectrumcore.account.model;

import java.util.ArrayList;

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
public class AutoPaymentDetail {
	@JsonProperty(required=false)
	private ReferenceDataType type;
	@JsonProperty(required=false)
	private ReferenceDataType status;
	@JsonProperty(required=false)
	private ArrayList<Restriction> restriction;
	@JsonProperty(required=false)
	private Card card;
	@JsonProperty(required=false)
	private EFT eft ;
}
