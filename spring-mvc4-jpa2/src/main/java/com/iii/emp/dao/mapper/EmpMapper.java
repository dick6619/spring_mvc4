package com.iii.emp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iii.emp.domain.DeptVO;
import com.iii.emp.domain.EmpVO;

public class EmpMapper implements RowMapper<EmpVO> {

	@Override
	public EmpVO mapRow(ResultSet rs, int arg1) throws SQLException {
		//
		EmpVO empVO = new EmpVO();
		empVO.setEmpno(rs.getInt("empno"));
		empVO.setEname(rs.getString("ename"));
		empVO.setHiredate(rs.getDate("hiredate"));
		empVO.setJob(rs.getString("job"));
		empVO.setSal(rs.getDouble("sal"));
		empVO.setComm(rs.getDouble("comm"));
		//
		DeptVO deptVO = new DeptVO();
		deptVO.setDeptno(rs.getInt("deptno"));
		deptVO.setDname(rs.getString("dname"));
		//
		empVO.setDeptVO(deptVO);
		return empVO;
	}

}
