package com.spectrum.sci.completeorder.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderBatchException extends RuntimeException {
   
	public OrderBatchException(String message) {
		super(message);
	}
	
	public OrderBatchException(String message, Throwable cause) {
		super(message,cause);
	}
	
	public OrderBatchException(Throwable cause) {
	    super(cause);
	}
	
}
