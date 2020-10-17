package com.iii.emp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iii.emp.domain.DeptVO;
import com.iii.emp.domain.EmpVO;

public class EmpMapper implements RowMapper<EmpVO> {

	@Override
	public EmpVO mapRow(ResultSet map, int arg1) throws SQLException {
		//
		EmpVO empVO = new EmpVO();
		empVO.setEmpno(map.getInt("empno"));
		empVO.setEname(map.getString("ename"));
		empVO.setHiredate(map.getDate("hiredate"));
		empVO.setJob(map.getString("job"));
		empVO.setSal(map.getDouble("sal"));
		empVO.setComm(map.getDouble("comm"));
		//
		DeptVO deptVO = new DeptVO();
		deptVO.setDeptno(map.getInt("deptno"));
		deptVO.setDname(map.getString("dname"));
		//
		empVO.setDeptVO(deptVO);
//
		return empVO;
	}

}
