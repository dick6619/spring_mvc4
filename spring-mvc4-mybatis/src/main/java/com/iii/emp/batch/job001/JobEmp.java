package com.iii.emp.batch.job001;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.iii.emp.batch.service.MessegePrintService;
import com.iii.emp.domain.PrintMessege;

//@DisallowConcurrentExecution
public class JobEmp extends QuartzJobBean {
    // 取得 jobDataMap中的設定名稱(哪一個batchJob)
	private String jobID;
	// 用jobDataMap注入的實例(setPrintMessege)
	private PrintMessege printMessege;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println(printMessege.getDate());
		// 取得jobData
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		jobID = jobDataMap.getString("jobID");
		
		try {
			ApplicationContext applicationContext = (ApplicationContext) context.getScheduler().getContext()
					.get("applicationContext");
			// getJobID，而所有的實例都是一種JOB，與spring-batch結合。需再修正
			// 用applicationContext.getBean()得到的實例
			MessegePrintService messegePrintService = (MessegePrintService) applicationContext.getBean(jobID);
			System.out.println(messegePrintService.getMessege());
		} catch (Exception e) {
			//
		}
	}

	public void setPrintMessege(PrintMessege printMessege) {
		this.printMessege = printMessege;
	}

}
