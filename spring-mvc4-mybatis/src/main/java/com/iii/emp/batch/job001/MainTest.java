package com.iii.emp.batch.job001;


import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

public class MainTest {
	public static void main(String[] args) throws Exception {
		
		/**jobDetail*/
		JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
		// name can not empty
		jobDetailFactory.setName("job");
		jobDetailFactory.setJobClass(QuartzJobSample1.class);
		jobDetailFactory.setDurability(true);
		// setJobDetail
		jobDetailFactory.afterPropertiesSet();
		// getJobDetail by factory
		JobDetail jobDetail = jobDetailFactory.getObject();
		
		//
		jobDetailFactory = new JobDetailFactoryBean();
		// name can not empty
		jobDetailFactory.setName("job1");
		jobDetailFactory.setJobClass(QuartzJobSample2.class);
		jobDetailFactory.setDurability(true);
		// setJobDetail
		jobDetailFactory.afterPropertiesSet();
		// getJobDetail by factory
		JobDetail jobDetail1 = jobDetailFactory.getObject();
		
		/**CronTrigger*/
		CronTriggerFactoryBean triggerFactory = new CronTriggerFactoryBean();
		// name can not empty
		triggerFactory.setName("trigger");
		triggerFactory.setJobDetail(jobDetail);
		triggerFactory.setCronExpression("0/3 * * * * ?");
		// setCronTrigger
		triggerFactory.afterPropertiesSet();
		// getCronTrigger
		Trigger trigger = triggerFactory.getObject();
		// 本以為不用重new直接在set就好．但trigger,及trigger1內的jobDataMap不處理set的話都參照同一個obj．在全域變數有先new出
		// 其餘的屬性變數沒有初始值必須set．原先的指定值雖在重新set後且指定給trigger1時．還是有被trigger參照．
		triggerFactory = new CronTriggerFactoryBean();
		// name can not empty
//		triggerFactory.setJobDataMap(new JobDataMap());
		triggerFactory.setName("trigger1");
		triggerFactory.setJobDetail(jobDetail1);
		triggerFactory.setCronExpression("0/10 * * * * ?");
		// setCronTrigger
		triggerFactory.afterPropertiesSet();
		// getCronTrigger
		Trigger trigger1 = triggerFactory.getObject();
		// ....... 這下面能發現jobDataMap參照同一個址，導致jobKey不一致
		System.out.println(trigger == trigger1);
		System.out.println(trigger.getJobDataMap() == trigger1.getJobDataMap());
		System.out.println(trigger.getJobKey() == trigger1.getJobKey());
		JobDetail jobDetailInMap = (JobDetail) trigger.getJobDataMap().get("jobDetail");
		// 錯的，變成新的
		System.out.println("jobDetail key = " + jobDetailInMap.getKey());
		// 正確的
		System.out.println("trigger key = " + trigger.getJobKey());
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setTriggers(trigger, trigger1);
		schedulerFactoryBean.setOverwriteExistingJobs(true);
		schedulerFactoryBean.afterPropertiesSet();
		schedulerFactoryBean.start();
//		Scheduler scheduler = schedulerFactoryBean.getObject();
//		scheduler.start();

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	}
}
