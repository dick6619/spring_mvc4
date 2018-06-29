package com.iii.emp.batch.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;

public interface CoreBatchService {
	
	void startJob(Job job, JobParameters jobParameters);

}
