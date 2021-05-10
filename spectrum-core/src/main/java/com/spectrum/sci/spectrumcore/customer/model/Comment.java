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
public class Comment {
	@JsonProperty(required=false)
	private String commentIndex;
	@JsonProperty(required=false)
	private String commentText;
}
