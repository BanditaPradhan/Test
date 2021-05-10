package com.spectrum.sci.completeorder.config;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

public class FailedBillerOrderHeaderCallBack implements FlatFileHeaderCallback{

	@Override
	public void writeHeader(Writer writer) throws IOException {
		writer.write("OrderId," + "ErrorMessage");
		
	}

}
