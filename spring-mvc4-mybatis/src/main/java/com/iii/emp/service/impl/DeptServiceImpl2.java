package com.iii.emp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iii.emp.domain.DeptVO;
import com.iii.emp.service.DeptService;

@Service("deptServiceImpl2")
@Transactional
public class DeptServiceImpl2 implements DeptService {

	@Override
	public List<DeptVO> getDepts() {
		// TODO Auto-generated method stub
		return null;
	}

}
