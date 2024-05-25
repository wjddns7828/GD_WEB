package com.test.edu;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.All_Dto;
import com.min.edu.dto.Player_DTO4;
import com.min.edu.dto.Team_DTO;
import com.min.edu.dto.Team_DTO5;
import com.min.edu.manager.SqlSessionFactoryManager;
import com.min.edu.model.IsocerDao;
import com.min.edu.model.SoccerDaoImpl;

public class Mybatis_Join_JunitTest {

	private IsocerDao dao = new SoccerDaoImpl();
	
	@Before
	public void test() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		SqlSession session = manager.openSession();
		assertNotNull(session);
	}
	@Test	
	public void joinCombine01() {
//		List<All_Dto> lists = dao.joinCombine01();
//		List<Team_DTO> lists = dao.joinCombine02();
//		List<Player_DTO4> lists = dao.joinCombine04();
		List<Team_DTO5> lists = dao.joinCombine05();
		System.out.println(lists.size());
		System.out.println(lists.get(0));
		assertNotNull(lists);
	}
	

}
