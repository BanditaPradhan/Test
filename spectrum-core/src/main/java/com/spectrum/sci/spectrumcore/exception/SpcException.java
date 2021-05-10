package com.spectrum.sci.spectrumcore.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SpcException extends RuntimeException{
	public SpcException(String message) {
		super(message);
	}
	
	public SpcException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public SpcException(Throwable cause) {
		super(cause);
	}
	
}
