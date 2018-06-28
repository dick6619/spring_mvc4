package com.iii.emp.batch.job001;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.iii.emp.batch.service.MessegePrintService;

//@DisallowConcurrentExecution
public class JobEmp2 extends QuartzJobBean {
	
	private String serviceID;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// 取得jobData
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		// 取得 jobDataMap中的key(serviceID)
		serviceID = jobDataMap.getString("serviceID");
		try {
			ApplicationContext applicationContext = (ApplicationContext) context.getScheduler().getContext()
					.get("applicationContext");
			// 用applicationContext.getBean()得到的實例
			MessegePrintService messegePrintService = (MessegePrintService) applicationContext.getBean(serviceID);
			System.out.println(messegePrintService.printMessege());
		} catch (Exception e) {
			//
		}
	}

}
