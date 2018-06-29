package com.iii.emp.batch.service.impl;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iii.emp.batch.service.CoreBatchService;
@Service("coreBatchService")
public class CoreBatchServiceImpl implements CoreBatchService {

	@Autowired
	private JobLauncher jobLauncher;

	@Override
	public void startJob(Job job, JobParameters jobParameters) {
		// TODO Auto-generated method stub
		try {
			jobLauncher.run(job, jobParameters);
		} catch (JobExecutionException e) {
			//
		}

	}
}
