package com.min.edu.model;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.JobVo;

public class JobSelectDaoImpl implements IJobSelectDao {

	private Logger log = Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.JobSelectDaoImpl.";
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
	@Override
	public JobVo select02(String job_id) {
		SqlSession session = manager.openSession();
		JobVo vo = session.selectOne(NS+"select02", job_id);
		log.info("쿼리 실행결과: " + vo);
		return vo;
	}
	
	/**
	 * 
	 */
	@Override
	public JobVo select03(String job_id) {
		SqlSession session = manager.openSession(false);
		JobVo vo = session.selectOne(NS+"select03", job_id);
		log.info("쿼리 실행결과: " + vo);
		return vo;
	}
	@Override
	public Map<String, JobVo> select04() {
		SqlSession session = manager.openSession();
		Map<String,JobVo> jobMap = session.selectMap(NS+"select04","JOB_ID");
		log.info(jobMap);
		return jobMap;
	}
	@Override
	public List<JobVo> select05(JobVo vo) {
		SqlSession session = manager.openSession();
		List<JobVo> lists = session.selectList(NS+"select05",vo);
		log.info(lists);
		return lists;
	}
	@Override
	public JobVo select06(Map<String, Object> map) {
		SqlSession session = manager.openSession();
		List<JobVo> one = session.selectList(NS+"select06",map);
		return (one.size()==1 ? one.get(0) : new JobVo());
	}
	@Override
	public List<JobVo> select07(Object obj) {
		SqlSession session = manager.openSession();
		List<JobVo> lists =	session.selectList(NS+"select07",obj);
		log.info(lists);
		return lists;
	}
}

