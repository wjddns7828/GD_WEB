package com.min.edu.sql;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.model.IJobSelectDao;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class JobSelectDaoImpl implements IJobSelectDao {

	private Logger log = Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.JobSelectDaoImpl";
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	
	
	/**
	 * SqlSession의 사용은 false인 경우 Transaction의 켜져 있음 : autoCommit이 false로 되어 있음
	 * 즉,select와 같은 실행에서는 OpenSession() 혹은 openSession(false)를 통해서 작업하면됨
	 * 	commit이 동작 되어야 하는 insert,delete,update의 경우는 OpenSession을 true로 해야 DB에 적용됨
	 */
	@Override
	public Integer select01(String id) {
		SqlSession session = manager.openSession(false);
		int maxSalary = session.selectOne(NS+"select01",id);
		return maxSalary;
	}
}
