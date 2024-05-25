package com.test.edu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.dao.BoardDAOImpl;
import com.min.edu.dao.IBoardDAO;
import com.min.edu.dto.BoardDTO;
import com.min.edu.support.SqlSessionFactoryManager;


public class BoardJUnitTest {
	SqlSession session;
	IBoardDAO dao = new BoardDAOImpl();
	
	@Before
	public void test() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		session = manager.openSession();
		assertNotNull(session);
	}
//	@Test
	public void getAllBoard() {
		assertNotNull(dao.getAllBoard());
	}
//	@Test
	/*
	 * public void setInsertBoard() { assertEquals(dao.setInsertBoard(), 1); }
	 */
	@Test
	public void getOneboard() {
		assertNotNull(dao.getOneboard("몰랑"));
	}
//	@Test
	public void setDeleteBoard() {
		assertEquals(dao.setDeleteBoard("3"),1);
	}
	
//	@Test
	public void setUpdateBoard() {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("seq", "3");
		map.put("title", "뭉글뭉글의 삶");
		map.put("content", "뭉글은 뭉뭉글뭉글 하다");
		assertEquals(dao.setUpdateBoard(map), 1);
	}
}
