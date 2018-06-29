package com.iii.emp.batch.job001;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.iii.emp.batch.service.CoreBatchService;

//@DisallowConcurrentExecution
public class JobEmp3 extends QuartzJobBean {

	private String jobID;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// 取得jobData
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		// 取得 jobDataMap中的key(serviceID)
		jobID = jobDataMap.getString("jobID");
		try {
			ApplicationContext applicationContext = (ApplicationContext) context.getScheduler().getContext()
					.get("applicationContext");
			// coreBatchService
			CoreBatchService coreBatchService = (CoreBatchService) applicationContext.getBean("coreBatchService");
			Job job = (Job) applicationContext.getBean(jobID);
			coreBatchService.startJob(job, BatchUtil.getJobParameters(jobDataMap));
		} catch (Exception e) {
			//
			System.out.println(e);
		}
	}

}
