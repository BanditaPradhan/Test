package com.spectrum.sci.completeorder.listener;

import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

import com.spectrum.sci.completeorder.config.DatabaseToCsvFileJobConfig;
import com.spectrum.sci.completeorder.config.SuccessfulOrdersToCsvFileJobConfig;

@Component
public class JobCompletionNotificationListner extends JobExecutionListenerSupport {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(JobCompletionNotificationListner.class);
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		log.info("In afterJob ...");
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
				DatabaseToCsvFileJobConfig databaseToCsvFileJobConfig = new DatabaseToCsvFileJobConfig();
				SuccessfulOrdersToCsvFileJobConfig successfulOrdersToCsvFileJobConfig = new SuccessfulOrdersToCsvFileJobConfig();
		} 
	}
}
