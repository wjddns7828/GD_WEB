package com.test.supplyment;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.dto.EmployeesDto;
import com.min.edu.dto.JobsDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class TestJUnit {
//
	@Test
	public void test() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	 	SqlSession session = manager.openSession();
	 	System.out.println(session);
	 	assertNotNull(session);
	 	
	 	// MyBatis 테스트
	 	// 쿼리의 결과만을 출력하게 된다
	 	// 모든정보를 가지고 있는 객체 session이다
	 	
	 	List obj =session.selectList("mybatisTest.jobSelect","ST_CLERK");
	 	System.out.println(obj.size());
	 	System.out.println(obj.get(0));
	 	assertNotNull(obj);
	}

}







