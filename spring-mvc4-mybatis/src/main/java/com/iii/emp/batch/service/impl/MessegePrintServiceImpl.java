package com.iii.emp.batch.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.iii.emp.batch.service.MessegePrintService;

@Service("messegePrintService")
public class MessegePrintServiceImpl implements MessegePrintService {

	@Override
	public String printMessege() {
		// TODO Auto-generated method stub
		return "jobEmp2 run application.getBean(MessegePrintService)...and use service" + "(" + new Date() + ")";
	}

}
