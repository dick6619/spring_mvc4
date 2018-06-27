package com.iii.emp.dao;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.iii.emp.domain.DeptVO;

@Repository
public interface DeptDAO {

	List<DeptVO> getDepts();

}
