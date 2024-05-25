package com.min.edu.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.JobVo;

public class JobIUDDaoImpl implements IJobIUDDao {
		private Logger logger = Logger.getLogger(JobIUDDaoImpl.class);
		private final String NS = "com.min.edu.model.JobIUDDaoImpl.";
		private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	
		
	@Override
	public int insert01(JobVo vo) {
//		SqlSession session = manager.openSession();
//		int n = session.insert(NS+"insert01",vo);	
//		session.commit();
		SqlSession session = manager.openSession(true);
		int n = session.insert(NS+"insert01",vo);	
		return n;
	}
	
	@Override
	public int delete01(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		return session.delete(NS+"delete01",map);
	}
	@Override
	public boolean update01(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		int n = session.update(NS+"update01",map);
		return (n>0)?true:false;
	}
}
