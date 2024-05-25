package com.test.jdbc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.min.edu.dao.EmpDAOImpl;
import com.min.edu.dao.IEmpDAO;
import com.min.edu.dto.Emp_DTO;

public class JDBC_Junit {
	private IEmpDAO dao;
	@Test
	public void test() {
		dao = new EmpDAOImpl();
		List<Emp_DTO> lists = dao.getAllemp();
		System.out.println(lists);
		assertNotNull(lists);
	}
}
