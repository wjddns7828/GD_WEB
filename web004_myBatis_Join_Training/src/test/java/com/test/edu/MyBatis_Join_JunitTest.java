package com.test.edu;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.All_DTO;
import com.min.edu.manager.SqlSessionFactoryManager;
import com.min.edu.model.EmpDaoImpl;
import com.min.edu.model.IEmpDao;

public class MyBatis_Join_JunitTest {
	
	IEmpDao dao = new EmpDaoImpl();
	
	@Before
	public void test() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		SqlSession session = manager.openSession();
		assertNotNull(session);
	}
	@Test
	public void All_join() {
		List<All_DTO> lists = dao.selectAll();
		assertNotNull(lists);
	}
}
