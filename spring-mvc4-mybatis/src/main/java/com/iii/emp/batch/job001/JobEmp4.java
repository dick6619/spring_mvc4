package com.iii.emp.batch.job001;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.iii.framework.core.springbatch.quartz.BatchUtil;
import com.iii.framework.core.springbatch.service.CoreBatchService;

@DisallowConcurrentExecution
public class JobEmp4 extends QuartzJobBean {

	// 一概放致jobDataMap, 直接取。或是加入set方法
	private String jobID;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
    private CoreBatchService coreBatchService;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// 取得jobData...放入batch-job所需參數
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		// 取得 jobDataMap中的key(jobID)
//		jobID = jobDataMap.getString("jobID");
		try {
			Job job = (Job) applicationContext.getBean(jobID);
			coreBatchService.startJob(job, BatchUtil.getJobParameters(jobDataMap));
		} catch (Exception e) {
			//
		}
	}

	public void setJobID(String jobID) {
		this.jobID = jobID;
	}

	
	

}
