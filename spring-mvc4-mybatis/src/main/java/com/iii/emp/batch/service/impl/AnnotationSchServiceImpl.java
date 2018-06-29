package com.iii.emp.batch.service.impl;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.iii.emp.batch.service.AnnotationSchService;

@Service
public class AnnotationSchServiceImpl implements AnnotationSchService {
	
	@Scheduled(cron="0 50 * * * ?")
	@Override
	public void printMessege() {
		System.out.println("annotation @Scheduled cron(" + new Date() + ")");
		
	}

}
