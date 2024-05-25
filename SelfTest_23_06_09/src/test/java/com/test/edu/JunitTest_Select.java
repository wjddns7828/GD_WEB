package com.test.edu;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.JobVo;

public class JunitTest_Select {
	SqlSession session;
	
	@Before
	public void createSqlSession() {
		SqlSessionFactory manager= SqlSessionFactoryManager.getFactory();
		session = manager.openSession();
		assertNotNull(manager);
	}
	
	@Test
	public void selectAllJob() {
		List<JobVo> lists = session.selectList("com.min.edu.job.selectAllJob");
		System.out.println(lists);
		assertNotNull(lists);
	}
}
