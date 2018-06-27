package com.iii.emp.batch.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.iii.emp.batch.service.MessegePrintService;

@Service
public class MessegePrintServiceImpl implements MessegePrintService {

	@Override
	public String getMessege() {
		// TODO Auto-generated method stub
		return "MessegePrintService" + "(" + new Date() + ")";
	}

}
