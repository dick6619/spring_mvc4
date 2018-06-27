package com.iii.emp.batch.job001;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.iii.emp.domain.PrintMessege;

public class JobEmp extends QuartzJobBean {

	private PrintMessege printMessege;

	public void setPrintMessege(PrintMessege printMessege) {
		this.printMessege = printMessege;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println(printMessege.getDate());
	}

}
