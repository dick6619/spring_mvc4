package com.iii.emp.batch.job001;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

// 簡易批次任務
public class JobEmp001Tasklet implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// (Map) jobDataMap.get("batchJobParameters")
	// jobDataMap.getLongValue("jobScheduleId")
}
