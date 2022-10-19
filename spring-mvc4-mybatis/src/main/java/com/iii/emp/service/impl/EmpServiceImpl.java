package com.iii.emp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iii.emp.dao.EmpDAO;
import com.iii.emp.domain.EmpVO;
import com.iii.emp.enumeration.EmpError;
import com.iii.emp.service.EmpService;
import com.iii.framework.core.exception.ServiceException;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

	//private static Logger logger = Logger.getLogger(EmpServiceImpl.class);

	@Resource
	private EmpDAO empDAO;

	@Override
	public int addEmp(EmpVO eParam) {
		if (eParam == null) {
			throw new ServiceException(EmpError.PARAM_ERROR);
		}
		int success = empDAO.insert(eParam);
		if (success != 1) {
			throw new ServiceException(EmpError.INSERT_ERROR);
		}
		return success;

	}

	@Override
	public EmpVO getEmp(EmpVO eParam) {
		if (eParam == null) {
			throw new ServiceException(EmpError.PARAM_ERROR);
		}
		return empDAO.getEmp(eParam);
	}

	@Override
	public List<EmpVO> getEmps() {
		return empDAO.getEmps();
	}

	@Override
	public int updateEmp(EmpVO eParam) {
		if (eParam == null) {
			throw new ServiceException(EmpError.PARAM_ERROR);
		}
		int success = empDAO.update(eParam);
		if (success != 1) {
			throw new ServiceException(EmpError.UPDATE_ERROR);
		}
		return success;
	}

	@Override
	public int delete(EmpVO eParam) {
		if (eParam == null) {
			throw new ServiceException(EmpError.PARAM_ERROR);
		}
		int success = empDAO.delete(eParam);
		if (success != 1) {
			throw new ServiceException(EmpError.DELETE_ERROR);
		}
		return success;
	}

	@Override
	public List<EmpVO> getEmpBySqlLike(EmpVO eParam) {
		if (eParam == null || StringUtils.isBlank(eParam.getEname())) {
			throw new ServiceException(EmpError.PARAM_ERROR);
		}
		return empDAO.getEmpBySqlLike(eParam);
	}
}
