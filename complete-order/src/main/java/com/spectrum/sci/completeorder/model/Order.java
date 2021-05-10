package com.spectrum.sci.completeorder.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {
	private String orderId;
	private String errorMessage;
	private String successMessage;
	private String result;
}
