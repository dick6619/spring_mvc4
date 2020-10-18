package com.iii.emp.dao.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iii.emp.dao.EmpDAO;
import com.iii.emp.dao.mapper.EmpMapper;
import com.iii.emp.domain.DeptVO;
import com.iii.emp.domain.EmpVO;

@Repository
@Transactional
public class EmpDAOImpl implements EmpDAO {

	/**
	 * ## JPA Entity LifeCycle
	 * 
	 * 1. new : new出的VO, 尚未與資料庫有任何關係
	 * 
	 * 2. managed : 使用persist(新增), merge(更新), find(查詢), 會讓 Entity從detached 變為此狀態
	 * 
	 * 3. detached : 使用clear() 可進入此狀態, 已經對應至資料庫, 但為分離狀態, 此時Entity任一屬性不會影響
	 * 
	 * 4. removed : 使用remove() 刪除脫離
	 * 
	 */

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Override
	public void insert(EmpVO empVO) {
		entityManager.persist(empVO);
	}

	@Transactional(readOnly = true)
	@Override
	public EmpVO getEmp(EmpVO ePraram) {
		return entityManager.find(EmpVO.class, ePraram.getEmpno());
	}

	// @Transactional(readOnly = true)
	// @Override
	// public List<EmpVO> getEmps() {
	// List<EmpVO> results = new ArrayList<EmpVO>();
	// List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from
	// emp2 emp join dept2 dep on emp.deptno = dep.deptno");
	// Iterator<Map<String, Object>> it = rows.iterator();
	// while(it.hasNext()) {
	// Map<String, Object> map = (Map<String, Object>) it.next();
	// EmpVO empVO = new EmpVO();
	// empVO.setEmpno((Integer)map.get("empno"));
	// empVO.setEname((String)map.get("ename"));
	// empVO.setHiredate((Date)map.get("hiredate"));
	// empVO.setJob((String)map.get("job"));
	// BigDecimal sal = (BigDecimal)map.get("sal");
	// empVO.setSal(sal.doubleValue());
	// BigDecimal comm = (BigDecimal)map.get("comm");
	// empVO.setComm(comm.doubleValue());
	// DeptVO deptVO = new DeptVO();
	// deptVO.setDeptno((Integer)map.get("deptno"));
	// deptVO.setDname((String)map.get("dname"));
	// empVO.setDeptVO(deptVO);
	// results.add(empVO);
	// }
	// return results;
	//
	// }

	@Transactional(readOnly = true)
	@Override
	public List<EmpVO> getEmps() {

		List<EmpVO> empVOs = (List<EmpVO>) jdbcTemplate.query(
				"SELECT * FROM emp2 AS emp INNER JOIN dept2 AS dep ON emp.deptno = dep.deptno",
				new ResultSetExtractor<List<EmpVO>>() {
					@Override
					public List<EmpVO> extractData(ResultSet rs) throws SQLException {
						List<EmpVO> list = new ArrayList<>();
						for (int i = 0; rs.next(); i++) {
							list.add(new EmpMapper().mapRow(rs, i));
						}
						return list;
					}
				});
		return empVOs;

	}

	@Transactional
	@Override
	public EmpVO update(EmpVO empVO) {
		/*
		 * entityManager.merge(empVO); ... this line entity lifeCycle is managed, not
		 * yet commit
		 */
		return entityManager.merge(empVO);
	}

	@Transactional
	@Override
	public void delete(EmpVO ePraram) {
		// if you want delete this employee, entity lifeCycle must be managed
		EmpVO empVO = entityManager.find(EmpVO.class, ePraram.getEmpno());
		entityManager.remove(empVO);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<EmpVO> getEmpBySqlLike(EmpVO ePraram) {
		final String sql = "select * from emp2 where ename like '%" + ePraram.getEname() + "%'";
		// second param need to add, guess the program can't understand who in List
		Query query = entityManager.createNativeQuery(sql, EmpVO.class);
		return query.getResultList();
	}

}
