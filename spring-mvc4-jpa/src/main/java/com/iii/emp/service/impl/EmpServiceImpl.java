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

	// private static Logger logger = Logger.getLogger(EmpServiceImpl.class);

	@Resource
//	@Autowired
//	@Qualifier("name")
	private EmpDAO empDAO;

	@Override
	public void addEmp(EmpVO eParam) {
		if (eParam == null) {
			throw new ServiceException(EmpError.PARAM_ERROR);
		}
		empDAO.insert(eParam);
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
	public EmpVO updateEmp(EmpVO eParam) {
		if (eParam == null) {
			throw new ServiceException(EmpError.PARAM_ERROR);
		}
		return empDAO.update(eParam);
	}

	@Override
	public void delete(EmpVO eParam) {
		if (eParam == null) {
			throw new ServiceException(EmpError.PARAM_ERROR);
		}
		empDAO.delete(eParam);

	}

	@Override
	public List<EmpVO> getEmpBySqlLike(EmpVO eParam) {
		if (eParam == null || StringUtils.isBlank(eParam.getEname())) {
			throw new ServiceException(EmpError.PARAM_ERROR);
		}
		return empDAO.getEmpBySqlLike(eParam);
	}
}
