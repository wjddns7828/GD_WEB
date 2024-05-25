package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.Job_DTO;
import com.min.edu.mybatis.SqlDaoSupport;

public class DynamicDaoImpl implements IDynamicDao {
	private Logger logger = Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.DynamicDaoImpl.";
	private SqlSessionFactory manager = SqlDaoSupport.getFactory();
	
	@Override
	public List<Job_DTO> getJobIf(Map<String, Object> map) {
		SqlSession session = manager.openSession();
		List<Job_DTO> lists = session.selectList(NS+"getJobIf",map);
		return lists;
	}
	
	@Override
	public List<Job_DTO> getJobList(List<String> lists) {
		logger.info("전달받은 요청값 :"+lists);
		SqlSession session = manager.openSession();
		List<Job_DTO> list = session.selectList(NS+"getJobList",lists);
		return list;
	}
	
	@Override
	public List<Job_DTO> getJobMap(Map<String, String[]> map) {
		logger.info("전달받은 요청값 :"+map);
		SqlSession session = manager.openSession();
		List<Job_DTO> lists = session.selectList(NS+"getJobMap",map);
		return lists;
	}
	@Override
	public List<Job_DTO> getJobChoose(Job_DTO dto) {
		logger.info("전달 받은 요청 id 값: "+dto.getJobId());
		logger.info("전달 받은 요청 title 값: "+dto.getJobTitle());
		SqlSession session =  manager.openSession();
		List<Job_DTO> lists =  session.selectList(NS+"getJobChoose",dto);
		return lists;
	}
	@Override
	public List<Job_DTO> getJobTrim(Job_DTO dto) {
		logger.info("전달 받은 요청 id 값: "+dto.getJobId());
		logger.info("전달 받은 요청 title 값: "+dto.getJobTitle());
		SqlSession session = manager.openSession();
		List<Job_DTO> lists = session.selectList(NS+"getJobTrim",dto);
		return lists;
	}
	@Override
	public boolean updateJobSet(Job_DTO dto) {
		logger.info("전달 받은 요청 id 값: "+dto.getJobId());
		logger.info("전달 받은 요청 title 값: "+dto.getJobTitle());
		SqlSession session = manager.openSession(true);
		int n = session.update(NS+"updateJobSet",dto);
		return (n>0)?true:false;
	}
	
	@Override
	public int updateJobTrim(Job_DTO dto) {
		logger.info("전달 받은 요청 getJobTitle 값: "+dto.getJobTitle());
		logger.info("전달 받은 요청 getMinSalary 값: "+dto.getMinSalary());
		int n = 0;
		try {
			SqlSession session = manager.openSession();
			n = session.update(NS+"updateJobTrim",dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn(e.getMessage());
		}
		logger.info("오류 발생?");
		return n;
	}
}
