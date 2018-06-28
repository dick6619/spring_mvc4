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
		
		// jobDetailFactory
		JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
		
		// ~~~~~~~~~~~~~~~~~ create job ~~~~~~~~~~~~~~~~~~~~
		// name can not empty
		jobDetailFactory.setName("job");
		jobDetailFactory.setJobClass(QuartzJobSample1.class);
		// 可以放job內屬性成員的name， 但要有set方法注入。無法直接使用spring-autowired
		jobDetailFactory.setJobDataMap(new JobDataMap());
		jobDetailFactory.setDurability(true);
		// setJobDetail
		jobDetailFactory.afterPropertiesSet();
		// getJobDetail by factory
		JobDetail jobDetail = jobDetailFactory.getObject();
		
		// ~~~~~~~~~~~~~~~~~ create job1 ~~~~~~~~~~~~~~~~~~~~
		// name can not empty
		jobDetailFactory.setName("job1");
		jobDetailFactory.setJobClass(QuartzJobSample2.class);
		// 可以放job內屬性成員的name， 但要有set方法注入。無法直接使用spring-autowired
		jobDetailFactory.setJobDataMap(new JobDataMap());
		jobDetailFactory.setDurability(true);
		// setJobDetail
		jobDetailFactory.afterPropertiesSet();
		// getJobDetail by factory
		JobDetail jobDetail1 = jobDetailFactory.getObject();
		
		// CronTrigger
		CronTriggerFactoryBean triggerFactory = new CronTriggerFactoryBean();
		
		// ~~~~~~~~~~~ create trigger and bind jobDetail ~~~~~~~~~~~~
		// name can not empty
		triggerFactory.setName("trigger");
		triggerFactory.setJobDetail(jobDetail);
		triggerFactory.setCronExpression("0/3 * * * * ?");
		// 會把jobDetail給放進來
		triggerFactory.setJobDataMap(new JobDataMap());
		// setCronTrigger
		triggerFactory.afterPropertiesSet();
		// getCronTrigger
		Trigger trigger = triggerFactory.getObject();
		
		// ~~~~~~~~~~ create trigger1 and bind jobDetail1 ~~~~~~~~~~~
		// name can not empty
		triggerFactory.setName("trigger1");
		triggerFactory.setJobDetail(jobDetail1);
		triggerFactory.setCronExpression("0/10 * * * * ?");
		// 會把jobDetail給放進來
		triggerFactory.setJobDataMap(new JobDataMap());
		// setCronTrigger
		triggerFactory.afterPropertiesSet();
		// getCronTrigger
		Trigger trigger1 = triggerFactory.getObject();
		
		
		// ~~~~~~~~~~~~ 測試
		// jobDataMap如果沒set的話，同個factory產出的trigger內的map則參照同一個址，導致jobKey不一致
		// trigger的jobKey要跟detail的jobKey一致否則噴錯 
		System.out.println(trigger == trigger1);
		System.out.println(trigger.getJobDataMap() == trigger1.getJobDataMap());
		System.out.println(trigger.getJobKey() == trigger1.getJobKey());
		// 錯的，jobKey被後者蓋過
		JobDetail jobDetailInMap = (JobDetail) trigger.getJobDataMap().get("jobDetail");
		System.out.println("jobDetail key = " + jobDetailInMap.getKey());
		// 正確的
		System.out.println("trigger key = " + trigger.getJobKey());
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		// schedulerFactory
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setTriggers(trigger, trigger1);
		schedulerFactoryBean.setOverwriteExistingJobs(true);
		schedulerFactoryBean.afterPropertiesSet();
		schedulerFactoryBean.start();

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	}
}
