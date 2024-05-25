package com.test.edu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.model.IJobIUDDao;
import com.min.edu.model.JobIUDDaoImpl;
import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.JobVo;

public class JUnitTest_IUD {
	
	private SqlSession session;
	private IJobIUDDao dao;
	@Before
	public void createSession() {
		dao = new JobIUDDaoImpl();
		SqlSessionFactory manager= SqlSessionFactoryManager.getFactory();
		session =  manager.openSession();
		assertNotNull(manager);
	}
//	@Test
	public void insert01() {
		JobVo vo = new JobVo("IT","Programmer",1000,3000);
		int n =	dao.insert01(vo);
		assertEquals(n, 1);
	}
	/**
	 * 전달받은 Map의 key 값은 id로 해야한다
	 */
//	@Test
	public void delete01() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", "IT");
		int n = dao.delete01(map);
		assertEquals(n, 1);
	}
	
//	public void delete01() {
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put(삭제할 컬럼, 삭제 할 이름);
//		int n = dao.delete01(map);
//		assertEquals(n, 1);
//	}
	@Test
	public void update01() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", "IT_PROG");
		map.put("title", "Developer");
		boolean isc = dao.update01(map);
		assertTrue(isc);
	}
}
