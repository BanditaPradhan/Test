package com.spectrum.sci.completeorder.processor;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

public class OrderWriter implements FlatFileHeaderCallback{
	
	private final String header;
	
	public OrderWriter(String header) {
		this.header = header;
	}

	@Override
	public void writeHeader(Writer writer) throws IOException {
		writer.write(header);
		
	}
}
