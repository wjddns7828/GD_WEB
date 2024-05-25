package com.test.supplyment;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.joindto.RootBoard;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class OneToMany_JUnitTest {
	@Test
	public void test() {
		SqlSessionFactory factory = SqlSessionFactoryManager.getFactory();
		SqlSession session = factory.openSession();
		RootBoard resultDto =  session.selectOne("OneToMany.oneToMany");
		System.out.println(resultDto);
		assertNotNull(resultDto);
	}
}
