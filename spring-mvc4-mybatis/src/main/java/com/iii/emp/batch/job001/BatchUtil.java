package com.iii.emp.batch.job001;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;

public class BatchUtil {
	
	public static JobParameters getJobParameters(Map<String, Object> parameters) {
		JobParametersBuilder builder = new JobParametersBuilder();
		
		for (Entry<String, Object> entry : parameters.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value instanceof String) {
				builder.addString(key, (String) value);
			} else if (value instanceof Float || value instanceof Double) {
				builder.addDouble(key, ((Number) value).doubleValue());
			} else if (value instanceof Integer || value instanceof Long) {
				builder.addLong(key, ((Number) value).longValue());
			} else if (value instanceof Date) {
				builder.addDate(key, (Date) value);
			} else {
				// JobDataMap contains values which are not job parameters
				// (ignoring)
			}
		}
		//need unique job parameter to rerun the completed job
		builder.addDate("run date", new Date());
		return builder.toJobParameters();
	}

}
