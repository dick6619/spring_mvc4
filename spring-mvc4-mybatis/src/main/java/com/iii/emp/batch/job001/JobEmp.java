package com.iii.emp.batch.job001;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.iii.emp.domain.PrintMessege;

@DisallowConcurrentExecution
public class JobEmp extends QuartzJobBean {

	// 用jobDataMap注入的實例，需要set方法，且此物件需要實作Serializable
	private PrintMessege printMessege;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println(printMessege.getDate());
	}

	public void setPrintMessege(PrintMessege printMessege) {
		this.printMessege = printMessege;
	}

}
