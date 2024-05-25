package com.test.answerboard;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.comm.DatePatternBean;
import com.min.edu.database.SqlSessionFactorymanager;
import com.min.edu.dto.AnswerBoardDTO;
import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class Answerboard_JUnitTest {
	
	@Test
	public void beanTest() {
		/*
		 * DatePatternBean bean = new DatePatternBean(); String result =
		 * bean.datePattern("2023-07-10 16:28:00"); System.out.println(result);
		 */
	}
	
	
//	@Before
	public void test() {
		SqlSessionFactory manager = SqlSessionFactorymanager.getFactory();
		SqlSession session = manager.openSession();
		assertNotNull(session);
	}
	@Test
	public void daoTest() {
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
//		dao.selectAllBoard();
//		dao.selectDetailBoard("10");

		for (int i = 0; i < 150; i++) {
			AnswerBoardDTO dto = new AnswerBoardDTO();
			dto.setId("TEST_ID"+i);
			dto.setTitle("TEST_제목"+i);
			dto.setContent("TEST_내용"+i);
			dao.insertBoard(dto);
		}
//		dto.setSeq(23);
//		dto.setId("re_reply_id");
//		dto.setTitle("re_reply_제목");
//		dto.setContent("re_reply_내용");
//		dao.reply(dto);
//		dao.selectAllBoard();
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("seq", "23");
//		map.put("content", "수정된 내용");
//		dao.modifyBoard(map);
//		dao.selectDetailBoard("23");
		
//		String[] seq = {"27","23"};
//		dao.deleteBoard(seq);
//		dao.selectAllBoard();
		
//		dao.deleteBoardReal("28");
//		dao.selectAllBoard();
//		String[] seq = {"27","23"};
//		Map<String, String[]> map = new HashMap<String, String[]>();
//		map.put("seqs",seq);
//		int result = dao.multiDelete2(map);
//		System.out.println("결과 :  "+result);
//		
//		dao.selectAllBoard();
		
//		IUserDao dao = new UserDaoImpl();
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", "user");
//		map.put("password", "1234");
//		dao.loginSelect(map);
//		assertTrue(true);
	}
}
