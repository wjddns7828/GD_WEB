package com.min.edu.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.All_DTO;
import com.min.edu.manager.SqlSessionFactoryManager;

public class EmpDaoImpl implements IEmpDao {
	
	private Logger logger = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private String NS1 = "com.min.edu.join01.";
	
	@Override
	public List<All_DTO> selectAll() {
		logger.info("하나의 단일 DTO 조인 매핑");
		SqlSession session = manager.openSession();
		List<All_DTO> lists= session.selectList(NS1+"select01");
		return lists;
	}
}
