package com.test.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.bean.DatePattern;
import com.min.edu.dto.CalendarDto;
import com.min.edu.dto.SqlSessionFactoryManager;
import com.min.edu.model.CalBoardDaoImpl;
import com.min.edu.model.ICalBoardDao;
import com.min.edu.util.CalendarUtil;


public class ScheduleBoardTest {
	@Test
	public void datePatternTest() {
		DatePattern dp = new DatePattern();
		dp.setToDate("202307281200");
		String convert = dp.getToDate();
		System.out.println(convert);
		assertNotNull(convert);
	}

//	@Before
	public void test() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		SqlSession session = manager.openSession();
		assertNotNull("MyBatis 세션 객체 생성",session);
		}
	
//	@Test
	public void utilTest() {
		String str = CalendarUtil.iTwoWord(1);
		System.out.println(str);
		
	}
	
//	@Test
	public void testDaoInsert() {
		ICalBoardDao dao = new CalBoardDaoImpl();
		CalendarDto dto = new CalendarDto();
//		dto.setId("RABIT");
//		dto.setTitle("멋쟁이 토마토");
//		dto.setContent("멋쟁이 토토마토토마토토탐토");
//		dto.setMdate("202307251111");
//		int n = dao.insertCalBoard(dto);
//		assertEquals(1,n);
		String[] seq = {"3","4"};
		boolean isc = dao.multiDel(seq);
		assertTrue(isc);
	}
//	@Test
	public void testDao() {
		ICalBoardDao dao = new CalBoardDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "RABIT");
		map.put("yyyymmdd", "20230725");
//		List<CalendarDto> lists = dao.getCalViewList(map);
//		List<CalendarDto> lists = dao.getCalList(map);
//		assertNotNull(lists);
//		int cnt = dao.getCalCount(map);
//		assertEquals(4, cnt);
		map.put("seq", 3);
		CalendarDto dto = dao.getCalDetail(map);
		assertNotNull(dto);
	}
}
	